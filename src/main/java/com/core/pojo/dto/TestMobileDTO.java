package com.core.pojo.dto;

import java.io.Serializable;

public class TestMobileDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Long mobileNum;
	private String remark;
	private TestUserDTO user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public TestUserDTO getUser() {
		return user;
	}
	public void setUser(TestUserDTO user) {
		this.user = user;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	
	
}
