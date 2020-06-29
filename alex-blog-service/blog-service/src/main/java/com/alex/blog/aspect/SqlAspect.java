package com.alex.blog.aspect;

import com.alex.blog.annotation.SqlIntervenerImpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SqlAspect {
  private final static Logger LOGGER = LoggerFactory.getLogger(SqlAspect.class);

  @Autowired
  private SqlIntervenerImpl sqlIntervenerImpl;

  @Pointcut("@annotation(com.alex.common.annotation.SqlIntervener)")
  public void sqlAspect() {
  }

  @Before("sqlAspect()")
  public void doBefore(JoinPoint point) {
    LOGGER.info("do before......");
    doBeforeExecutor(point);
  }

  @After("sqlAspect()")
  public void doAfter() {
    LOGGER.info("do after......");
  }

  // @Around("sqlAspect()")
  // public Object doAround(ProceedingJoinPoint point) throws Throwable {
  // LOGGER.info(point.getSignature().getName().toString());
  // Object result = point.proceed();
  // return result;
  // }

  private void doBeforeExecutor(JoinPoint point) {
    Object[] objs = point.getArgs();
    for (Object obj : objs) {
      sqlIntervenerImpl.doReplace(obj);
    }
  }
}