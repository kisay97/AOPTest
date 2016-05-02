package com.estsoft.AOPTest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component					//bean 생성
@Aspect						//프록시 빈 생성
public class MyAspect {
	
	@Before("execution( public ProductVo com.estsoft.AOPTest.ProductService.findProduct(String))") //JoinPoint
	public void before(){	//advice 정의
		System.out.println("call [Befor Advice]");
	}
	
}
