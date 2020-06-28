package com.alex.common.lang;

import org.junit.Assert;
import org.junit.Test;

public class CodecsTest {

  @Test
  public void testObjToBytes() {
    DemoMsg dmsg = new DemoMsg("abcde 1234");
    byte[] jsonBytes = Codecs.objToJsonBytes(dmsg);
    Assert.assertEquals(dmsg.msg, Codecs.jsonToObj(jsonBytes, DemoMsg.class).msg);
  }
}

class DemoMsg {
  public String msg;

  public DemoMsg() {
  }

  public DemoMsg(String msg) {
    this.msg = msg;
  }
}