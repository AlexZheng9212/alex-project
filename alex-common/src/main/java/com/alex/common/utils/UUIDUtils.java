package com.alex.common.utils;

import java.util.UUID;

public class UUIDUtils {
  public static UUID convertToUUID(String str) {
    try {
      return UUID.fromString(str);
    } catch (Exception e) {
      return null;
    }
  }
}