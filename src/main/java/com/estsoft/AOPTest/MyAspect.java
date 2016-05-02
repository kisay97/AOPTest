package com.estsoft.AOPTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component					//bean 생성
@Aspect						//프록시 빈 생성
public class MyAspect {
	
	@Before("execution( public ProductVo com.estsoft.AOPTest.ProductService.findProduct(String))") //JoinPoint + JoinCut
	public void before(){	//advice 정의
		System.out.println("call [Before Advice]");
	}
	
	//execution(접근자 반환타입 패키지.클래스(인터페이스).메소드(인수) throws 에외
	//접근자, 예외, 패키지명.클래스명 생략 가능, * (와일드카드) 사용 가능, 패키지 경로에서 와일드카드는 .. 을 사용
	@After("execution( * *..AOPTest.ProductService.*(..) )") //모든 리턴타입의, 경로 끝에 AOPTest, 클래스는 ProductService, 메서드는 모든것(인수 모름 아무거나)
	public void after(){
		System.out.println("call [after Advice]");
	}
	
	@Around("execution( * *..AOPTest.*.*(..) )")
	public ProductVo around(ProceedingJoinPoint pjp) throws Throwable{
		//Before
		System.out.println("call [around.before Advice]");
		
		ProductVo vo = (ProductVo)pjp.proceed();
		
		//After
		System.out.println("call [around.after Advice]");
		
		return vo;
	}
}
