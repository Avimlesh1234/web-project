package com.example.demo.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class UserDtoRegister {
	private Long id;
	private Long userId;

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private String mobileNo;

	private LocalDateTime createDate;

	private LocalDateTime modifiedDate;

	private String modifiedBy;

	private String address;
	
	private String token;
	
	

}
