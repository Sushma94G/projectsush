package com.assaign.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class UserDTO implements Serializable {

	
	private String fname;
	private String lname;
	private String cCode;
	private long mobileNo;
	@Id
	private String email;
	private boolean newUser;
	private String password;
	private Date lastLogin;
	private int failCount;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isNewUser() {
		return newUser;
	}
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	@Override
	public String toString() {
		return "UserDTO [fname=" + fname + ", lname=" + lname + ", cCode=" + cCode + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", newUser=" + newUser + ", password=" + password + ", lastLogin=" + lastLogin
				+ ", failCount=" + failCount + "]";
	}
	
	
}
