package com.groupeisi.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.entities.Inscription;
import com.groupeisi.entities.User;

public class InscriptionImp implements IInscription {
	private DB db = new DB();
	private int ok;
	private ResultSet rs;
	public int create(Inscription inscription) {
		String sql = "INSERT INTO inscriptions VALUES(NULL, ?, ? )";
		try {
			db.init(sql);
			db.getPstm().setString(2, inscription.getClasse());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
			db.getPstm().setString(1, sdf.format(inscription.getDate()));			
			ok = db.executeMaj();
			db.closeConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	public int update(Inscription inscription) {
		String sql = "UPDATE inscriptions SET classe = ?, WHERE id = ?";
		try {
			db.init(sql);		
			db.getPstm().setInt(2, inscription.getId());
			db.getPstm().setString(3, inscription.getClasse());
			ok = db.executeMaj();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	public int remove(int id) {
		try {
			String sql = "DELETE FROM inscriptions WHERE id = ?";
			db.init(sql);
			db.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public List<Inscription> liste() {
		List<Inscription> iinscription = new ArrayList<Inscription>();
		String sql = "SELECT * FROM inscriptions";
		try {
			db.init(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Inscription i = new Inscription();
				i.setId(rs.getInt(1));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				i.setDate(sdf.parse(rs.getString(2)));
				i.setClasse(rs.getString(3));
				iinscription.add(i);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return iinscription;
		
	}


}
