package com.groupeisi.dao;

import java.util.List;

import com.groupeisi.entities.Inscription;

public interface IInscription {
	public int create(Inscription  inscription);
	public int update(Inscription  inscription);
	public int remove(int id);
	public List<Inscription> liste();
	
}
