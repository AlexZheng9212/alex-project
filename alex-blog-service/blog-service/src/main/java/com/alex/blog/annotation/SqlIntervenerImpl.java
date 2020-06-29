package com.alex.blog.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.alex.common.db.intervener.AbstractSqlIntervener;
import com.google.common.base.Splitter;

import org.springframework.stereotype.Service;

@Service
public class SqlIntervenerImpl extends AbstractSqlIntervener {
  /**
   * [POC]: just active in Article
   */
  @Override
  public void doReplace(Object inputParam) {
    if (inputParam.getClass().getName().contains("Article")) {
      try {
        Method method = inputParam.getClass().getMethod("getCategory");
        String invokeResult = (String) method.invoke(inputParam);
        List<String> regionList = new ArrayList<>(Splitter.on(",").splitToList(invokeResult.toString()));
        // java 反射修改属性值
        // regionList.add("test");
        Field f = inputParam.getClass().getDeclaredField("category");
        f.setAccessible(true);
        f.set(inputParam, regionList.toString());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void genAndReplaceSql() {
    System.out.println("gen and replace sql");
  }

}