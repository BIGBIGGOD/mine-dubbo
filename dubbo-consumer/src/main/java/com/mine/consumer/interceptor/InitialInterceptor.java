package com.mine.consumer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jiangqd on 2019/3/21.
 */
@Order(0)
@Aspect
@Component
@Slf4j
public class InitialInterceptor {

    @Pointcut("execution(* com.mine.consumer.controller.*.*(..))")
    public void initialMethod() {
    }

    @Around("initialMethod()")
    public Object beforeInitial(ProceedingJoinPoint joinPoint) {
        //获取request和response对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        Object data = null;
        String token = request.getHeader("token");
        try {
//            if (StringUtils.isBlank(token)) {
//                Map<String, Object> responseMap = new HashMap<>();
//                responseMap.put("errCode", "错误码");
//                responseMap.put("errMsg", "错误原因");
//                String json = new Gson().toJson(responseMap);
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json; charset=utf-8");
//                response.getWriter().write(json);
//                return data;
//            }else {
//                String version = request.getHeader("miniAppVersion");
//                String source = request.getHeader("source");
                data = joinPoint.proceed();
                return data;
//            }
        } catch (Throwable e) {
            log.error("InitialInterceptor.beforeInitial error :", e);
            return data;
        }

    }

}
