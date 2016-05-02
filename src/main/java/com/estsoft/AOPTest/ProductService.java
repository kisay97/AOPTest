package com.estsoft.AOPTest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo findProduct(String name){
		System.out.println("finding product[" + name + "]......");
		return new ProductVo(name);
	}
}
