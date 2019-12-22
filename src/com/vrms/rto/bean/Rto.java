package com.vrms.rto.bean;
import javax.validation.constraints.Size;
public class Rto {
	private int id;
	@Size(min=1,message="required") 
	private String name;
	@Size(min=1,message="required") 
	private String postedAt;    
	@Size(min=1,message="required") 
	private String address;
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
	public String getPostedAt() {
		return postedAt;
	}
	public void setPostedAt(String postedAt) {
		this.postedAt = postedAt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
