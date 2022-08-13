package com.garage.gerbackg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int bookingid;
	
	@Column
	private int userid;
	
	@Column
	private String cartype;
	
	@Column
	private String carmake;
	
	@Column
	private String carengine;
	
	@Column
	private String carplate;
	
	@Column
	private String carmodel;
	
	@Column
	private String caryear;
	
	@Column
	private String date;
	
	@Column
	private String bookingtype;
	
	@Column
	private String bookingstatus;
	
	@Column
	private String mechanic;
	
	@Column
	private String comments;
	
	@Column
	private int servicetime;

	public Booking() {
		
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarmake() {
		return carmake;
	}

	public void setCarmake(String carmake) {
		this.carmake = carmake;
	}

	public String getCarengine() {
		return carengine;
	}

	public void setCarengine(String carengine) {
		this.carengine = carengine;
	}

	public String getCarplate() {
		return carplate;
	}

	public void setCarplate(String carplate) {
		this.carplate = carplate;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getCaryear() {
		return caryear;
	}

	public void setCaryear(String caryear) {
		this.caryear = caryear;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBookingtype() {
		return bookingtype;
	}

	public void setBookingtype(String bookingtype) {
		this.bookingtype = bookingtype;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getServicetime() {
		return servicetime;
	}

	public void setServicetime(int servicetime) {
		this.servicetime = servicetime;
	}

}
