package com.uch.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	private FoodInfo foodInfo;
	private UserId userid;
	private int count;
	public FoodInfo getFoodInfo() {
		return foodInfo;
	}
	public void setFoodInfo(FoodInfo foodInfo) {
		this.foodInfo = foodInfo;
	}
	
	public UserId getUserId() {
		return userid;
	}
	public void setUserId(UserId userid) {
		this.userid = userid;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String order_sn() {
		final String PREFIX = "D";
		String str = new SimpleDateFormat("yyMMddHHmmSS").format(new Date());
		return PREFIX+str;
	}
	
	
}