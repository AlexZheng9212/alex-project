package com.alex.common.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractBasicUploadFileService<T> {

  public abstract List<T> transfer(MultipartFile multipartFile);

  public static void uploadFile(String path, MultipartFile multipartFile) throws IOException {
    if (multipartFile.isEmpty()) {
      throw new IOException("Pls select one file to upload");
    }
    String filename = String.join("-", UUID.randomUUID().toString(), multipartFile.getOriginalFilename());
    File newFile = new File(path + filename);
    multipartFile.transferTo(newFile);
  }

  // TODO
  public static void ossUploadFile() {
  }
}
