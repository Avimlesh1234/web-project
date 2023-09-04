package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Dto.SearchDto;
import com.example.demo.model.Product;
import com.example.demo.vo.ProductVo;

public interface ProductService {

	Product addproduct(ProductVo prodvo);

	List<ProductDto> getProductlist();

	List<ProductDto> serachproduct(List<SearchDto> searchdto);

}
