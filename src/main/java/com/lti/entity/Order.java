package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name="Order_map1")
public class Order {

	@Id
	private int oid;
	private String oname;
	
	@ManyToMany(mappedBy="order_list")
	private List<Product>prodlist=new ArrayList<>();	
	
	public List<Product> getProdlist() {
		return prodlist;
	}
	public void setProdlist(List<Product> prodlist) {
		this.prodlist = prodlist;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oname=" + oname + "]";
	}
	
	
	
}
