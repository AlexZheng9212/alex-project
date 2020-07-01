package com.alex.blog.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.alex.blog.api.constant.ArticleStatus;
import com.alex.blog.api.domain.Article;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl {
  private final String ossBucket = "/Users/alex.zheng/Documents/";
  private final String type2003 = ".xls";
  private final String type2007 = ".xlsx";

  public void uploadFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
    if (multipartFile.isEmpty())
      throw new IOException("Pls select one file to upload");
    String originFileInfo = multipartFile.getOriginalFilename();
    String newName = genNewFileName(originFileInfo);
    File dest = new File(newName);
    multipartFile.transferTo(dest);
  }

  private String genNewFileName(String info) {
    StringBuilder builder = new StringBuilder(ossBucket);
    builder.append(UUID.randomUUID().toString() + "-");
    builder.append(info);
    return builder.toString();
  }

  private void save(MultipartFile multipartFile) {
    List<Article> articles = new ArrayList<>();
    Workbook workbook = null;
    String fileName = multipartFile.getOriginalFilename();
    try {
      if (fileName.endsWith(type2003)) {
        workbook = new HSSFWorkbook(multipartFile.getInputStream());
      } else if (fileName.endsWith(type2007)) {
        workbook = new XSSFWorkbook(multipartFile.getInputStream());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (workbook == null) {
        System.out.println("no no no");
        return;
      }
    }
    int numOfSheet = workbook.getNumberOfSheets();

    for (int i = 0; i < numOfSheet; i++) {
      Sheet sheet = workbook.getSheetAt(i);
      int totalLines = sheet.getLastRowNum();
      for (int j = totalLines; j > 0; j--) {
        Row row = sheet.getRow(j);
        String id = genCellValue(row.getCell(0));
        String title = genCellValue(row.getCell(1));
        String category = genCellValue(row.getCell(2));
        String author = genCellValue(row.getCell(3));
        ArticleStatus status = ArticleStatus.valueOf(genCellValue(row.getCell(4)));
        Article article = new Article(id, title, category, author, status);
        articles.add(article);
      }
    }
  }

  private String genCellValue(Cell cell) {
    CellType cellType = cell.getCellType();
    switch (cellType) {
      case NUMERIC:
        return cell.getStringCellValue();
      case STRING:
        return cell.getStringCellValue();
      case BOOLEAN:
        return String.valueOf(cell.getBooleanCellValue());
      case FORMULA:
        return cell.getCellFormula();
      case BLANK:
        return StringUtils.EMPTY;
      case ERROR:
        return String.valueOf(cell.getErrorCellValue());
      default:
        return StringUtils.EMPTY;
    }
  }

}
