package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.MessageDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.model.Users;


public interface UserService {

	List<UserDto> getUsers();

	UserDto addUsers(UserDto userdto);

	MessageDto userLogin(LoginDto loginvo);

	UserDto findUserByemail(String email);


}
