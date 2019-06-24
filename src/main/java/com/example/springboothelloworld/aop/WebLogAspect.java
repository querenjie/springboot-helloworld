package com.example.springboothelloworld.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.example.springboothelloworld.util.Log4jUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogAspect {

//	private static Logger logger = Logger.getLogger(WebLogAspect.class);
	private static final Logger logger = LogManager.getLogger(WebLogAspect.class);


	@Pointcut("execution(public * com.example.springboothelloworld.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Log4jUtil.info(logger, "#####################请求开始####################");
		// 记录下请求内容
		Log4jUtil.info(logger, "URL : " + request.getRequestURL().toString());
		Log4jUtil.info(logger, "HTTP_METHOD : " + request.getMethod());
		Log4jUtil.info(logger, "IP : " + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			Log4jUtil.info(logger, "name:{" + name + "},value:{" + request.getParameter(name) + "}");
		}
		
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		Log4jUtil.info(logger, "RESPONSE : " + ret);
		Log4jUtil.info(logger, "#####################请求结束####################");
	}
}
