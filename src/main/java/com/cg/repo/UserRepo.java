package com.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.cg.dto.User;

public interface UserRepo extends JpaRepository<User, String>{
	@Query("SELECT u FROM User u WHERE u.userRole=:userRole")
	List<User> getByUserRole(String userRole);

}
