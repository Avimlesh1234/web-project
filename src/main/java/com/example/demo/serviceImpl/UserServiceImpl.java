package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.ChangePasswordDto;
import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.MessageDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Dto.UserDtoRegister;
import com.example.demo.Utils.AesEncyption;
import com.example.demo.config.UserAuthProvider;
import com.example.demo.mappers.UserMapper;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	private final UserMapper userMapper;
	
	private final UserAuthProvider userAuthProvider;

	@Override
	public List<UserDto> getUsers() {
		try {
			List<UserDto> userDtolist = new ArrayList<>();
			UserDto userDto = new UserDto();
			List<Users> userslist = userrepo.findAll();
			if (userslist.size() > 0) {
				for (Users users : userslist) {
					userDto = new UserDto();
//				        userDto.setFirstName(users.getFirstName());
//				        userDto.setLastName(users.getLastName());
//				        userDto.setUsername(users.getUsername());
//				        userDto.setEmail(users.getEmail());
//				        userDto.setPassword(users.getPassword());
//				        userDto.setRole_id(users.getRole_id());
//				        userDto.setMobileNo(users.getMobileNo());
//				        userDto.setCreateDate(users.getCreateDate());
//				        userDto.setModifiedDate(users.getModifiedDate());
//				        userDto.setModifiedBy(users.getModifiedBy());
//				        userDto.setAddress(users.getAddress());
					BeanUtils.copyProperties(users, userDto);
					// userDto.setStatus(1);

					userDtolist.add(userDto);
				}
			}

			else {
				System.out.println("No data Pressent in the database");
			}
			return userDtolist;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto addUsers(UserDto userdto) {
		LocalDateTime onborderdDate = LocalDateTime.now();
		Users user = new Users();
		user.setFirstName(userdto.getFirstName());
		user.setLastName(userdto.getLastName());
		user.setUsername(userdto.getUsername());
		user.setEmail(userdto.getEmail());
		user.setRole_id(userdto.getRole_id());
		user.setMobileNo(userdto.getMobileNo());
		user.setModifiedBy(userdto.getModifiedBy());
		user.setAddress(userdto.getAddress());
		user.setCreateDate(onborderdDate);
		user.setModifiedDate(onborderdDate);
		String encyptedpassword = AesEncyption.encrypt(userdto.getPassword());
		user.setPassword(encyptedpassword);
		user.setStatus(1);

		user = userrepo.save(user);

		userdto.setUserId(user.getUserId());
		return userdto;
	}

	@Override
	public MessageDto userLogin(LoginDto loginvo) {
		// TODO Auto-generated method stub
		MessageDto  messageDto= new MessageDto();
		UserDtoRegister useresgisterdto=new UserDtoRegister();
		try {
			
			String encyptedpassword = AesEncyption.encrypt(loginvo.getPassword());		
			String useremail=loginvo.getEmail();
			Users user=(Users)userrepo.findByEmail(useremail);
			useresgisterdto=userMapper.toUserDtoRegister(user);
			
			useresgisterdto.setToken(userAuthProvider.createToken(useresgisterdto));
			
			
		//	String decyptedpassword = AesEncyption.de(loginvo.getPassword());
			if(user!=null)
			{
				if(user.getPassword().equals(encyptedpassword))
				{
					messageDto.setMessage("User Successfully Login");
					messageDto.setStatus(200);
					messageDto.setHttpstatus(HttpStatus.OK);
					messageDto.setData(useresgisterdto);
					return messageDto;
				}
				messageDto.setMessage("Password Missmatch");
				messageDto.setStatus(400);
				messageDto.setHttpstatus(HttpStatus.BAD_REQUEST);
				return messageDto;
				
			}
			messageDto.setMessage("user not found");
			messageDto.setStatus(400);
			messageDto.setHttpstatus(HttpStatus.BAD_REQUEST);
			return messageDto;
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return messageDto;
	}

	@Override
	public UserDto findUserByemail(String email) {
		try {
			Users user=(Users)userrepo.findByEmail(email);
			
			UserDto userdto=new UserDto();
			BeanUtils.copyProperties(user, userdto);
			return userdto;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateprofiledetails(UserDto userdto) {
		
		int status=0;
		try {
			Optional<Users> userdata;
			Users user=new Users();
			LocalDateTime date=LocalDateTime.now();
			Long userid=userdto.getUserId();
			userdata=userrepo.findById(userid);
			
			
			
			if(userdata!=null) {
				user.setUserId(userid);
				user.setFirstName(userdto.getFirstName());
				user.setLastName(userdto.getLastName());
				user.setAddress(userdto.getAddress());
				user.setModifiedDate(date);
				 try {
					status= userrepo.updateUser(user.getUserId(),user.getFirstName(),user.getLastName(),user.getAddress());
					
			        } catch (DataAccessException e) {
			           e.printStackTrace();
			           
			        }
				
			}
			else {
				return status;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
}
		
		return status;
	}

	@Override
	public int changePassword(UserDto userdto, ChangePasswordDto changepassworddto) {
		int status=0;
		Users user=new Users();
		String email=null;
		try {
			 user=(Users)userrepo.findByEmail(userdto.getEmail());
			String encyptednewpwd=null;
			email=user.getEmail();
		
			String oldpwd=AesEncyption.encrypt(changepassworddto.getOldpassword());
			if(!changepassworddto.getOldpassword().equals("") && user.getPassword().equalsIgnoreCase(oldpwd)) {
				encyptednewpwd=AesEncyption.encrypt(changepassworddto.getNewpassword());
				status=userrepo.changepassword(email,encyptednewpwd);
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
