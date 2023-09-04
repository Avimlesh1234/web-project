package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.UserDto;
import com.example.demo.model.Users;
import com.example.demo.Dto.LoginDto;
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
	
	@GetMapping("/Hello")
	public void good() {
		System.out.println("Hello");
	}
	
	@GetMapping(value="/getuser")
	public ResponseEntity<MessageDto> findUserByemail(@RequestParam String email){
		MessageDto messagedto=new MessageDto();
	    try {
	    	String Email=email;
	    	UserDto userdto=userService.findUserByemail(Email);
	    	if(userdto!=null) {
	    		messagedto.setStatus(200);
	    		messagedto.setHttpstatus(HttpStatus.OK);
	    		messagedto.setMessage("Welcome "+userdto.getUsername());
	    		messagedto.setData(userdto);
	    		return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
	    	}
	    	else {
	    		messagedto.setStatus(403);
	    		messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
	    		messagedto.setMessage("Unable to Navigate On DashBoard");
	    		messagedto.setData(userdto);
	    	}
	    	
	    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
	}
	
	@PostMapping(value="/updateprofiledetails")
	public ResponseEntity<MessageDto> updateprofiledetails(@RequestBody UserDto userdto){
		MessageDto messagedto=new MessageDto();
		try {
			
			int status=userService.updateprofiledetails(userdto);
			if(status==1) {
				messagedto.setMessage("Details Succesfully Updated");
				messagedto.setStatus(200);
				messagedto.setHttpstatus(HttpStatus.OK);
			}
			else {
				messagedto.setMessage("Updation Failed");
				messagedto.setStatus(403);
				messagedto.setHttpstatus(HttpStatus.BAD_REQUEST);
			}
			
			
			
		}catch(Exception e) {
			
		}
		return ResponseEntity.status(messagedto.getHttpstatus()).body(messagedto);
	}
	
	@PostMapping(value="userlogin")
	public  @ResponseBody MessageDto userLogin(@RequestBody LoginDto loginvo)
	{
		MessageDto res=new MessageDto();
		try {
			if(!loginvo.getEmail().equals("") && !loginvo.getPassword().equals("") && loginvo!=null)
			{
				 res=userService.userLogin(loginvo);
				return res;	
			}
			res.setMessage("invalid filed");
			res.setStatus(400);
			res.setHttpstatus(HttpStatus.BAD_REQUEST);
			return res;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
		
	}
	
	
	

}
