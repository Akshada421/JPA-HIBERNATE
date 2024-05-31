package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Citizen_map1")
public class Citizen {

	@Id
	private int cid;
	private String cname;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_PID")
	private Passport passport;
	
	
	
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Citizen [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
	
}
