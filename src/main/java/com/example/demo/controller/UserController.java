package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.MessageDto;
import com.example.demo.service.UserService;

@RestController()
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="addusers")
	public ResponseEntity <MessageDto> addUser(@RequestBody UserDto userdto){
		try {
			UserDto usersdto=new UserDto();
			MessageDto messagedto=new MessageDto();
			List<UserDto>userdtos=userService.getUsers();
			if(userdtos.size()>0 && userdtos!=null) {
				for(UserDto user:userdtos) {
					if( user.getEmail().equalsIgnoreCase(userdto.getEmail())) {
						messagedto.setMessage("Email is Duplicate or Email is null");
						messagedto.setStatus(403);
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					else if(user.getMobileNo().equalsIgnoreCase(userdto.getMobileNo())) {
						messagedto.setMessage("Mobile No is Duplicate or Mobile No is null");
						messagedto.setStatus(403);
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					else if(   user.getUsername().equalsIgnoreCase(userdto.getUsername())) {
						messagedto.setMessage("Username is Duplicate or UserName is null");
						messagedto.setStatus(403);
						messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
						return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
					}
					
				}
				
				
			}
			usersdto=userService.addUsers(userdto);
			if(userdto!=null) {
				messagedto.setMessage("User Successfully Added");
				messagedto.setStatus(200);
				messagedto.setHttpstatus(HttpStatus.OK);
				messagedto.setData(userdto);
			}
			
			
		
		return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}