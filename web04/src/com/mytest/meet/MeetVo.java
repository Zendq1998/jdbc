package com.mytest.meet; //映射一条数据。vo是跟数据库做映射关系的。

import java.text.SimpleDateFormat;
import java.util.Date;

public class MeetVo {
	private Date createTime;
	private String position;
	private Integer one;
	private String station;
	private String phone;
	private Integer id;
	private String name;
	
	public Date getCreateTime() {
		return createTime;
	}
	public String getCteateTimestr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String createTimestr = sdf.format(createTime);
		return createTimestr;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getOne() {
		return one;
	}
	public void setOne(Integer one) {
		this.one = one;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	
	
}