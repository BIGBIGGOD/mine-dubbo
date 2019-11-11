package com.mine.consumer.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

/**
 * 拦截器实现日志输出
 * Created by jiangqd on 2019/3/20.
 */
@Slf4j
public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        String className = invocation.getClass().getName();
        String methodName = invocation.getMethod().getName();

        long startTime = System.currentTimeMillis();

        try {
            Object result = invocation.proceed();

            long finishTime = System.currentTimeMillis();
            System.out.println("我是日志拦截器");
            log.info("service finished,serviceName={}#{} args={} result={} duration={}ms", className, methodName, invocation.getArguments(), result, finishTime - startTime);

            return result;
        } catch (Exception e) {
            long finishTime = System.currentTimeMillis();
            log.error("service exception, serviceName={}#{} args={} duration={}ms exception:",
                className, methodName, invocation.getArguments(), finishTime - startTime, e);
            throw e;
        }
    }
}
