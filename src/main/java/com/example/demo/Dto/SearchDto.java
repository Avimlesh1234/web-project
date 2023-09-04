package com.example.demo.Dto;

import java.util.List;
import java.util.Map;

public class SearchDto {
	private String searchkey;
	private String searchvalue;
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public String getSearchvalue() {
		return searchvalue;
	}
	public void setSearchvalue(String searchvalue) {
		this.searchvalue = searchvalue;
	}
	@Override
	public String toString() {
		return "SearchDto [searchkey=" + searchkey + ", searchvalue=" + searchvalue + "]";
	}
	
	
	
	
	

}
