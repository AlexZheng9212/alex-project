package com.alex.common.utils;

import java.util.UUID;

public class UUIDUtils {
  public static UUID convertToUUID(String str) {
    if (str == "" || str == null)
      return null;
    try {
      return UUID.fromString(str);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }
}