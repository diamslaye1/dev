package com.groupeisi.entities;

import java.sql.Date;

public class Inscription {
	private int id;
	private Date date;
	private String classe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date2) {
		this.date = (Date) date2;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
}
