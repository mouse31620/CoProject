package com.uch.vo;

public class FoodOrderInfo {
	private int orderID;
	private String reciver;
	private String address;
	private String email;
	private String tel;
	private String mobile;
	private String notice;
	private String atTime;
	private double totalPrice;
	private int user_id;
	private String order_sn;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAtTime() {
		return atTime;
	}
	public void setAtTime(String atTime) {
		this.atTime = atTime;
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
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public FoodOrderInfo(String reciver, String address, String email,String tel, String mobile,
			String notice,	double totalPrice, int user_id, String order_sn) {
		super();
		this.reciver = reciver;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.mobile = mobile;
		this.notice = notice;
		this.totalPrice = totalPrice;
		this.user_id=user_id;
		this.order_sn = order_sn;
	}
	

}
