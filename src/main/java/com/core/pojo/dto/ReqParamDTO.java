package com.core.pojo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ReqParamDTO {
	
	@NotBlank(message="用户名不能为空")
	private String username;
	
	@NotNull(message="密码不能为null")
	private String password;
	
	
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Min(value=10, message="年龄的最小值为10")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
