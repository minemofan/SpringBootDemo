
package com.core.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class TestUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String type;
	private BigDecimal money;
	private Date birthdate;
	private Time time;
	private String remark;
	
	private TestIdCardDTO idCard;
	private List<TestMobileDTO> mobiles;
	private List<TestRoleDTO> roles;
	private List<TestUserRoleDTO> userRoles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public TestIdCardDTO getIdCard() {
		return idCard;
	}
	public void setIdCard(TestIdCardDTO idCard) {
		this.idCard = idCard;
	}
	public List<TestMobileDTO> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<TestMobileDTO> mobiles) {
		this.mobiles = mobiles;
	}
	public List<TestRoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<TestRoleDTO> roles) {
		this.roles = roles;
	}
	public List<TestUserRoleDTO> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<TestUserRoleDTO> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	
	
}
