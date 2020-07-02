package com.alex.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.alex.blog.api.constant.ArticleStatus;
import com.alex.blog.api.domain.Article;
import com.alex.common.file.AbstractBasicUploadFileService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.alex.common.utils.CellUtils.genCellValue;

@Service
public class UploadArticleFileService extends AbstractBasicUploadFileService<Article> {
  private final String type2003 = ".xls";
  private final String type2007 = ".xlsx";

  @Override
  public List<Article> transfer(MultipartFile multipartFile) {
    Workbook workbook = null;
    String fileName = multipartFile.getOriginalFilename();
    System.out.println(fileName);
    try {
      if (fileName.endsWith(type2003)) {
        System.out.println("xls");
        workbook = new HSSFWorkbook(multipartFile.getInputStream());
      } else if (fileName.endsWith(type2007)) {
        System.out.println("xlsx");
        workbook = new XSSFWorkbook(multipartFile.getInputStream());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (workbook == null) {
      throw new Error("workbook is null");
    }
    List<Article> articles = new ArrayList<>();
    int numOfSheet = workbook.getNumberOfSheets();
    for (int i = 0; i < numOfSheet; i++) {
      Sheet sheet = workbook.getSheetAt(i);
      int totalLines = sheet.getLastRowNum();
      for (int j = totalLines; j > 0; j--) {
        Row row = sheet.getRow(j);
        String title = genCellValue(row.getCell(1));
        String category = genCellValue(row.getCell(2));
        String author = genCellValue(row.getCell(3));
        ArticleStatus status = ArticleStatus.valueOf(genCellValue(row.getCell(4)));
        Article article = new Article();
        article.id = UUID.randomUUID();
        article.setTitle(title);
        article.setContent("bili");
        article.setCategory(category);
        article.setStatus(status);
        article.setAuthor(author);
        System.out.println(article.id + " " + article.toString());
        articles.add(article);
      }
    }
    return articles;
  }

}
