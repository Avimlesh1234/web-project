package com.example.demo.mappers;

import org.mapstruct.Mapper;

import com.example.demo.Dto.UserDtoRegister;
import com.example.demo.model.Users;

@Mapper(componentModel="spring")
public interface UserMapper {
 
	UserDtoRegister toUserDtoRegister(Users user);

}
