package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class ProductController {
	
	@Autowired 
	private ProductCatRepository catrepository;
	
	@Autowired 
	private ProductCatSubRepository subcatrepository;
	
	@Autowired 
	private ProductRepo productrepo;
	
	
	@PostMapping("/add_prod_cat")
	
	public @ResponseBody ProductResponse addProfdCat(@RequestBody ProductCat prodcat)
	{
		ProductResponse res=new ProductResponse();

		try {
			
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

		try {
			
			ProductSubCat productcatt= subcatrepository.save(prodsubcat);
			
			if(productcatt!=null)
			{
				res.setMsg("sucess");
				res.setStatus("200");
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

@PostMapping("/add_product")

public @ResponseBody ProductResponse fileupload(@RequestParam("image") MultipartFile image,@RequestParam("productCategory")String productCategory,@RequestParam("productSubCategory")String productSubCategory,@RequestParam("brandnName")String brandnName,@RequestParam("price")String price,@RequestParam("serialNo")String serialNo,@RequestParam("quantity")String quantity)
{
	
		
			ProductResponse rees=new ProductResponse();
			
			String path="C:\\Users\\Lenovo\\"+image;
			
			String fileName=null;
			try {
				ProductController controller=new ProductController();
				  fileName=controller.uploadImage(path,image);
				  Product product =new Product();		  																																																			
				  product.setFilename(fileName); 
				  product.setBrandname(brandnName);
				  product.setPrice(price);
				  product.setProductname(productCategory);
				  product.setSubcategory(productSubCategory);
				  product=  productrepo.save(product);
				  if(product!=null)
				  { rees.setStatus("200");
				  rees.setMsg("save");
					  return rees;
				  }
				  return rees;
				 
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return rees;		
}

public String uploadImage(String path, MultipartFile file) {
	String  name=file.getOriginalFilename();
	
	
	String filepath=path+ File.separator+name;
	
	
	// create foleder if not created
	
	File f=new File(path);
	if(!f.exists())
	{
		f.mkdir();
	}
			
	return filepath;
	}
	 
	



}
