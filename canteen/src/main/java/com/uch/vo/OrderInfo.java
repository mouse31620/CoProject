package com.uch.vo;

public class OrderInfo {
	private String foods_id;
	private String foods_name;
	private String foods_number;
	private String foods_price;
	private String subtotal;
	private String order_id;
	private String order_sn;
	
	public String getFoods_id() {
		return foods_id;
	}
	public void setFoods_id(String foods_id) {
		this.foods_id = foods_id;
	}
	public String getFoods_name() {
		return foods_name;
	}
	public void setFoods_name(String foods_name) {
		this.foods_name = foods_name;
	}
	public String getFoods_number() {
		return foods_number;
	}
	public void setFoods_number(String foods_number) {
		this.foods_number = foods_number;
	}
	public String getFoods_price() {
		return foods_price;
	}
	public void setFoods_price(String foods_price) {
		this.foods_price = foods_price;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public OrderInfo(String foods_id, String foods_name, String foods_number,String foods_price, String subtotal, String order_id, String order_sn) 
	{
		super();
		this.foods_id = foods_id;
		this.foods_name = foods_name;
		this.foods_number = foods_number;
		this.foods_price = foods_price;
		this.subtotal = subtotal;
		this.order_id = order_id;
		this.order_sn = order_sn;
	}
}
