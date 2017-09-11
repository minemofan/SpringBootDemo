package com.core.pojo.dto;

import java.io.Serializable;

public class TestUserRoleDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private Integer roleId;
	
	private TestRoleDTO role;	//多对多
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public TestRoleDTO getRole() {
		return role;
	}
	public void setRole(TestRoleDTO role) {
		this.role = role;
	}
	
	
}
