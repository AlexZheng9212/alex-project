package com.alex.common.file;

import java.io.File;

interface NativeUploadFile {
  void uploadFile(String destination, File file);
}