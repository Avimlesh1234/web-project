package com.example.demo.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>  {

//	@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Users findByEmail (String email);
    
//    @Query(value = "SELECT * FROM users WHERE user_id = :id", nativeQuery = true)
    Optional<Users> findById( Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET first_name = :firstName, last_name = :lastName,address=:address WHERE user_id = :userId", nativeQuery = true)
	int updateUser( @Param("userId") Long userId,@Param("firstName") String firstName, @Param("lastName")String lastName,@Param("address") String address);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET password = :newpassword WHERE email = :email", nativeQuery = true)
	int changepassword(@Param("email")String email, @Param("newpassword")String encyptednewpwd);
    
    



}
