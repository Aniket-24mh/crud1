package com.logproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String moleculerformula;
	
	
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
	public String getMoleculerformula() {
		return moleculerformula;
	}
	public void setMoleculerformula(String moleculerformula) {
		this.moleculerformula = moleculerformula;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", moleculerformula=" + moleculerformula +  "]";
	}
	public Product(int id, String name, String moleculerformula, int prize) {
		super();
		this.id = id;
		this.name = name;
		this.moleculerformula = moleculerformula;
	}
	public Product() {
		super();
	}
	public void setBought(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
