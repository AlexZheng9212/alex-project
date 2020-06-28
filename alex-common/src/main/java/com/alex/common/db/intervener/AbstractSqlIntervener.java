package com.alex.common.db.intervener;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractSqlIntervener implements SqlReplacer {
  public abstract void genAndReplaceSql();

  boolean matchCondition(String condition) {
    return conditions.contains(condition);
  }
}

interface SqlReplacer {
  List<String> conditions = Arrays.asList(new String[] { "category like" });

  void doReplace(Object inputParam);
}