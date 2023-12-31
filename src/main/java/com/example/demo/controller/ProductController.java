package com.example.demo.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
import com.example.demo.model.ProductCat;
import com.example.demo.model.ProductSubCat;
import com.example.demo.repository.ProductCatRepository;
import com.example.demo.repository.ProductCatSubRepository;
import com.example.demo.repository.ProductRepo;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.ProductService;
import com.example.demo.vo.ProductVo;

@RestController

@CrossOrigin("*")
public class ProductController {
	
	@Autowired 
	private ProductCatRepository catrepository;
	
	@Autowired 
	private ProductCatSubRepository subcatrepository;
	
	@Autowired 
	private ProductRepo productrepo;
	
	@Autowired
	private ProductService prodservice;
	
	
	@GetMapping("/getproductcat")
	
	public @ResponseBody List<ProductCat> getcategorybyId()
	{
		
		List<ProductCat> productcatt= (List<ProductCat>) catrepository.findAll();
		return productcatt;
		
	}
	

	@GetMapping("/getproductsubcat")
	
	public @ResponseBody List<ProductSubCat> getsubcategorybyId(@RequestParam Integer pcid)
	{
		
		List<ProductSubCat> productcatt= subcatrepository.findByPcid(pcid);
		return productcatt;
		
	}
	
	
	
	@PostMapping("/add_prod_cat")
	
	public @ResponseBody ProductResponse addProfdCat(@RequestBody ProductCat prodcat)
	{
		ProductResponse res=new ProductResponse();

		try {
			
			
			if(prodcat.getCategory()!=null && prodcat.getDescription()!=null) {
						
			ProductCat productcatt= catrepository.save(prodcat);
			
			if(productcatt!=null)
			{	res.setMsg("sucess");
			res.setStatus("200");
			return res;
				
			}
			res.setMsg("failed");
			res.setStatus("400");
			return res;
			
			}
			
			res.setMsg("failed");
			res.setStatus("400");
			return res;
		}
		catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
	
		return res;		
		
	}
	
	
@PostMapping("/add_prod_subcat")
	
	public @ResponseBody ProductResponse addProfdCat(@RequestBody ProductSubCat prodsubcat)
	{
		ProductResponse res=new ProductResponse();
		  ProductSubCat productsubcatt=new ProductSubCat();

		try {
			if(!prodsubcat.getPcid().equals("") && !prodsubcat.getSubcategory().equals(""))
			{
			
			
			  if(prodsubcat.getPcid()!=null) {
				  
			 Optional<ProductCat>  productcatt=catrepository.findById(Long.valueOf(prodsubcat.getPcid()));
			  System.out.println(productcatt);
			  
			  
			  if(productcatt!=null)
			  {
				  productsubcatt	= subcatrepository.save(prodsubcat);
				
				if(!productcatt.isEmpty())
				{
					res.setMsg("sucess");
					res.setStatus("200");
					return res;
				}
				res.setMsg("failed");
				res.setStatus("400");
				return res;
			}
			  res.setMsg("failed");
				res.setStatus("400");
				return res;
			  }
			  
			  }
		
		 res.setMsg("failed");
			res.setStatus("400");
			return res;
		}
			 
			
			
		catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
	
		return res;
		
		
	}

@PostMapping("/add_product")

public @ResponseBody ProductResponse uploadproduct(@RequestBody ProductVo prodvo)
{
	
		
			ProductResponse res=new ProductResponse();
			
			//String path="C:\\Users\\Lenovo\\"+image;
		//	MultipartFile m=prodvo.getImage().toString();
			// fileName=controller.uploadImage(path,image);
			
			try {
				if(prodvo!=null)
				{
					
				  Product product=prodservice.addproduct(prodvo);
				  
				  if(product!=null)
				  {
					  res.setMsg("save success");
					 res.setStatus("200");
					 return res;

				  }
				  res.setMsg("failed");
					 res.setStatus("400");
					return res;
				}
				 res.setMsg("failed");
				 res.setStatus("400");
				return res;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return res;		
}

/*
 * public String uploadImage(String path, MultipartFile file) { String
 * name=file.getOriginalFilename();
 * 
 * 
 * String filepath=path+ File.separator+name;
 * 
 * 
 * // create foleder if not created
 * 
 * File f=new File(path); if(!f.exists()) { f.mkdir(); }
 * 
 * return filepath; }
 * 
 * 
 */


}
