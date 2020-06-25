package com.alex.blog.config;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Properties;

import com.alex.common.annotation.MybatisIntercept;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * change sql before execute sql.
 * 
 * we can use annotation to control which sql we want to change.
 */
@Component
@Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class MybatisInterceptor implements Interceptor {
  private final static Logger LOGGER = LoggerFactory.getLogger(MybatisInterceptor.class);

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
        SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
    MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
    Class<?> classType = Class.forName(mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf(".")));
    String methodName = mappedStatement.getId().substring(mappedStatement.getId().lastIndexOf(".") + 1,
        mappedStatement.getId().length());
    for (Method method : classType.getDeclaredMethods()) {
      MybatisIntercept mybatisIntercept = method.getAnnotation(MybatisIntercept.class);
      if (method.isAnnotationPresent(MybatisIntercept.class) && methodName.equals(method.getName())
          && mybatisIntercept.flag()) {
        LOGGER.info("修改sql语句");
      }
    }
    String id = mappedStatement.getId();
    String sqlCommandType = mappedStatement.getSqlCommandType().toString();
    BoundSql boundSql = statementHandler.getBoundSql();
    String sql = boundSql.getSql();
    LOGGER.info("SQL: \n {} \n ID: {} \n TYPE: {}", sql, id, sqlCommandType);
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    if (target instanceof StatementHandler) {
      return Plugin.wrap(target, this);
    } else {
      return target;
    }
  }

  @Override
  public void setProperties(Properties properties) {
    // TODO Auto-generated method stub

  }
}