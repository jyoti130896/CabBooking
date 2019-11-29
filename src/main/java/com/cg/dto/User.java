package com.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_Master")
public class User {
	@Id
	@Column(name = "User_Id", length = 20)
	@NotEmpty(message = "User id cannot be empty")
	@Size(max = 20, message = "max size of user id is 20")
	private String userId;

	@Column(name = "User_Name", length = 20)
	@NotEmpty(message = "User name cannot be empty")
	@Size(max = 20, message = "max size of User name is 20")
	private String userName;

	@Column(name = "User_Password", length = 256)
	@NotEmpty(message = "Password cannot be empty")
	@Size(max = 256, message = "max size of Password is 256")
	private String userPassword;

	@Column(name = "User_Phone", length = 20)
	@NotEmpty(message = "User phone number cannot be empty")
	@Size(max = 20, message = "max size of phone number is 10")
	private String userPhone;

	@Column(name = "User_Role", length = 20)
	@NotEmpty(message = "User role cannot be empty")
	@Size(max = 20, message = "max size of User role is 20")
	private String userRole;

	public User() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
