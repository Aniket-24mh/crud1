package com.logproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String disciption;

	int prize;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisciption() {
		return disciption;
	}

	public void setDisciption(String disciption) {
		this.disciption = disciption;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", disciption=" + disciption + ", prize=" + prize + "]";
	}

	public Admin(int id, String disciption, int prize) {
		super();
		this.id = id;
		this.disciption = disciption;
		this.prize = prize;
	}

	public Admin() {
		super();
	}
	
	
	

}
