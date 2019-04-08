package com.qianfeng.fxmall.commons.spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogProxy {

    Logger  logger = Logger.getLogger(LogProxy.class);

    @Around("execution(public * com.qianfeng.fxmall.goodsku.Service.GoodSkuServiceImpl.*(..))")
    public void logger(ProceedingJoinPoint joinPoint){
        try {
            //传入的参数
            String kind = joinPoint.getKind();
            Object args = joinPoint.getArgs();
            logger.debug(kind+":"+args);

            //返回的参数
            Object proceed = joinPoint.proceed();
            logger.debug("返回的值为："+proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            //记录错误日志
            logger.warn(throwable.getMessage());
        }
    }
}
