package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.UserDto;

import com.example.demo.Utils.AesEncyption;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;

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
		String encyptedpassword = AesEncyption.hashPassword(userdto.getPassword());
		user.setPassword(encyptedpassword);
		user.setStatus(1);

		user = userrepo.save(user);

		userdto.setUserId(user.getUserId());
		return userdto;
	}

}
