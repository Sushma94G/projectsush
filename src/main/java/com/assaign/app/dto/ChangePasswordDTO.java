package com.assaign.app.dto;

public class ChangePasswordDTO {

	private String email;
	private String oPassword;
	private String nPassword;
	private String cnPassword;
	
	public ChangePasswordDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getoPassword() {
		return oPassword;
	}

	public void setoPassword(String oPassword) {
		this.oPassword = oPassword;
	}

	public String getnPassword() {
		return nPassword;
	}

	public void setnPassword(String nPassword) {
		this.nPassword = nPassword;
	}

	public String getCnPassword() {
		return cnPassword;
	}

	public void setCnPassword(String cnPassword) {
		this.cnPassword = cnPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordDTO [email=" + email + ", oPassword=" + oPassword + ", nPassword=" + nPassword
				+ ", cnPassword=" + cnPassword + "]";
	}
	
}
