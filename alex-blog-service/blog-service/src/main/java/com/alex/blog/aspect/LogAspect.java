package com.alex.blog.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.hutool.json.JSONUtil;

/**
 * aop demo component
 */
@Component
@Aspect
public class LogAspect {
  private final static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

  @Pointcut("execution(* com.alex.blog.rest..*.*(..))")
  public void restLog() {
  }

  @Around("restLog()")
  public Object doAround(ProceedingJoinPoint point) throws Throwable {
    LOGGER.info("Request Log Start...");
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = (HttpServletRequest) requestAttributes
        .resolveReference(RequestAttributes.REFERENCE_REQUEST);
    LOGGER.info(request.getProtocol());
    LOGGER.info(request.getMethod() + " " + request.getRequestURI());
    if (request.getMethod().equalsIgnoreCase(RequestMethod.POST.toString())) {
      LOGGER.info("Request Body: {}", JSONUtil.toJsonStr(point.getArgs()));
    }
    Object proceed = point.proceed();
    LOGGER.info("Request Log Finish...");
    return proceed;
  }
}