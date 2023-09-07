package com.example.demo.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.MessageDto;
import com.example.demo.model.Merchant;
import com.example.demo.model.Users;
import com.example.demo.repository.MerchantRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MerchantService;
import com.example.demo.service.UserService;
import com.example.demo.vo.MerchanrtVo;

@RestController
@RequestMapping("/merchant")
@CrossOrigin("*")
public class MerchantController {

	@Autowired 
	private UserService userservice;
	
	@Autowired 
	private MerchantService merchantService;
	
	@Autowired 
	private MerchantRepository merchantRepository;
	@Autowired 
	private  UserRepository userRepository;
	
	
	@PostMapping("addmerchantdetails")
	public @ResponseBody MessageDto addMerchant(@RequestBody MerchanrtVo merchanrtVo)
	{
		MessageDto messageDto=new MessageDto();
		try {		
			Users  user=userRepository.findByEmail(merchanrtVo.getEmail());
		     if(user.getMid()!=null )
		     {
		    	Merchant merchant =merchantRepository.findByid(user.getMid());
		    	 merchanrtVo.setId(merchant.getId());
		    	 if(merchant!=null)
		    	 {
		    		 
		    		 Merchant merchants=merchantService.saveMerchantDetails(merchanrtVo);
		    		 
		    		 if(merchants!=null)
		    		 {
		    			 messageDto.setMessage("merchant  save");
			    		 messageDto.setStatus(200);;
		    			 
		    		 }
		    		 
		    		 messageDto.setMessage("merchant not save");
		    		 messageDto.setStatus(400);;
		    		 
		    	 }
		    	 messageDto.setMessage("merchant not found");
	    		 messageDto.setStatus(400);;
	    		 
		    	 
		     }
		       
		  
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
}
