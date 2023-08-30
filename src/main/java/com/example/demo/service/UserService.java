package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.UserDto;


public interface UserService {

	List<UserDto> getUsers();

	UserDto addUsers(UserDto userdto);


}
