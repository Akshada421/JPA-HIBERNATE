package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passport_map1")
public class Passport {

	@Id
	private int pno;
	private String ptype;
	@OneToOne(mappedBy="passport",cascade=CascadeType.ALL)
	private Citizen citizen;
	
	
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	@Override
	public String toString() {
		return "Passport [pno=" + pno + ", ptype=" + ptype + "]";
	}
	
	
}
