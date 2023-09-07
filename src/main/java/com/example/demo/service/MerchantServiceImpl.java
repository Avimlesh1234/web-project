package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Merchant;
import com.example.demo.repository.MerchantRepository;
import com.example.demo.vo.MerchanrtVo;
@Service
public class  MerchantServiceImpl implements  MerchantService {
	@Autowired
	private MerchantRepository  merchantRepository;
	

	@Override
	public Merchant saveMerchantDetails(MerchanrtVo merchanrtVo) {
		// TODO Auto-generated method stub
		Merchant res=new Merchant();
		
		try {
			Merchant merchant =new Merchant();
			BeanUtils.copyProperties(merchanrtVo ,merchant);
			
		Merchant merchants	=merchantRepository.save(merchant);
		if(merchants!=null)
		{
			
			return res;
			
			
		}
		return null;
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
