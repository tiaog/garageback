package com.garage.gerbackg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplies")
public class Supplies {
	
	@Id
	@Column
	private String productname;
	
	@Column
	private double unitprice;
	
	public Supplies() {
		super();
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

}
