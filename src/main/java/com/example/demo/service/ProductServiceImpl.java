package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Dto.SearchDto;
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
	@Override
	public List<ProductDto> getProductlist() {
		try {
			List<ProductDto> productdtoList=new ArrayList<>();
			ProductDto productdto=new ProductDto();
			List<Product> productlist=productrepo.findAll();
			for(Product product:productlist ) {
				productdto=new ProductDto();
				BeanUtils.copyProperties(product, productdto);
				productdtoList.add(productdto);
			}
			return productdtoList;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<ProductDto> serachproduct(List<SearchDto> searchdtolist) {
		List<Product>productlist=new ArrayList<>();
		List<ProductDto>productdtolist=new ArrayList<>();
		
		SearchDto searchdto=new SearchDto();
		try {
			
			int size=searchdtolist.size();
			while(size>0) {
				searchdto=new SearchDto();
				searchdto=searchdtolist.get(size-1);
				//productlist=productrepo.searchproductlist(searchdto.getSearchkey(),searchdto.getSearchvalue());
				size--;
				
			}
			
			return productdtolist ;
		}catch(Exception e) {
			
			
		}
		return null;
	}
	

}
