package com.beans;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="rent1")
	private double rent1;
	@Column(name="rent2")
	private double rent2;
	@Column(name="rent3")
	private double rent3;
	@Column(name="deposit")
	private double deposit;
	@Column(name="photo")
	private String photo;
	@Column(name="isonuse")
	private boolean isOnUse;
	@Column(name="userid")
	private int userId;
	@Column(name="isrecycle")
	private boolean isRecycle;
	@Column(name="intro")
	private String intro;
	@Column(name="extra")
	private String extra;
	@Column(name="starttime")
	private Date startTime;
	@Column(name="endtime")
	private Date endTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getRent1() {
		return rent1;
	}
	public void setRent1(double rent1) {
		this.rent1 = rent1;
	}
	public double getRent2() {
		return rent2;
	}
	public void setRent2(double rent2) {
		this.rent2 = rent2;
	}
	public double getRent3() {
		return rent3;
	}
	public void setRent3(double rent3) {
		this.rent3 = rent3;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isOnUse() {
		return isOnUse;
	}
	public void setOnUse(boolean isOnUse) {
		this.isOnUse = isOnUse;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isRecycle() {
		return isRecycle;
	}
	public void setRecycle(boolean isRecycle) {
		this.isRecycle = isRecycle;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
