package com.uch.vo;

public class UserInfo {
	private Integer user_id;
	private String user_name;
	private String login_id;
	private String login_pw;
	private String email;
	private String tel;
	private String mobile;
	private String address;
	private String contact;
	private String lastlogin;
	private Integer permission;
	
	
	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getLogin_id() {
		return login_id;
	}


	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getLogin_pw() {
		return login_pw;
	}


	public void setLogin_pw(String login_pw) {
		this.login_pw = login_pw;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getLastlogin() {
		return lastlogin;
	}


	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}


	public int getPermission() {
		return permission;
	}


	public void setPermission(int permission) {
		this.permission = permission;
	}


	public UserInfo(String user_name, String login_id,
			String login_pw, String email,	String tel, String mobile,
			String address, String lastlogin) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.login_id = login_id;
		this.login_pw = login_pw;
		this.email = email;
		this.tel = tel;
		this.mobile = mobile;
		this.address = address;
		this.contact = contact;
		this.lastlogin = lastlogin;
		this.permission = permission;
	}	
}
