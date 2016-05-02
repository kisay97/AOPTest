package com.estsoft.AOPTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ApplicationContext applicationContext = 
        	new ClassPathXmlApplicationContext("config/applicationContext.xml");
        
        ProductService productService = (ProductService) applicationContext.getBean("productService");
        ProductVo vo = productService.findProduct("camera");
        System.out.println(vo);
        
        ((ConfigurableApplicationContext)applicationContext).close();
    }
}