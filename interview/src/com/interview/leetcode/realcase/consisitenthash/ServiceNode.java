package com.interview.leetcode.realcase.consisitenthash;

public class ServiceNode implements Node {
  private final String idc;
  private final String ip;
  private final String port;

  @Override
  public String getKey() {
    return idc + "-" + ip + "-" + port;
  }

  public ServiceNode(String idc, String ip, String port) {
    this.idc = idc;
    this.ip = ip;
    this.port = port;
  }

  @Override
  public String toString() {
    return getKey();
  }
}
