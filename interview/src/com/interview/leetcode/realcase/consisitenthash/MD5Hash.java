package com.interview.leetcode.realcase.consisitenthash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
  MessageDigest instance;

  public MD5Hash() throws NoSuchAlgorithmException {
    instance = MessageDigest.getInstance("MD5");
  }

  public long hash(String key) {
    instance.reset();
    instance.update(key.getBytes());
    byte[] digest = instance.digest();

    long h = 0;
    for (int i = 0; i < 4; i++) {
      h <<= 8;
      h |= ((int) digest[i]) & 0xFF;
    }
    return h;
  }
}
