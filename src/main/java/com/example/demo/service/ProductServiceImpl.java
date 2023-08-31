package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired 
	private ProductRepo productrepo;
	@Override
	public Product addproduct(ProductVo prodvo) {
		// TODO Auto-generated method stub
		
		Product product=new Product();
		try {
			BeanUtils.copyProperties(prodvo, product);
			product=productrepo.save(product);
			return product;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return product;
	}

}
