package com.core.pojo.dto;

import java.io.Serializable;

public class TestIdCardDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String code;
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
