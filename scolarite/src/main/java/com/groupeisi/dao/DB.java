package com.groupeisi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DB {
	private static Logger logger = Logger.getLogger(DB.class);
	private PreparedStatement pstm;
	private Connection cnx;
	private ResultSet rs;
	private int result;
	private int ok;
	
	private void openConnection() {
		BasicConfigurator.configure();
		String url = "jdbc:mysql://localhost:3306/scolaritedb";
		String userMysql = "root";
		String passwordMysql = "";
		
		
	try {
		cnx = DriverManager.getConnection(url, userMysql, passwordMysql);
		logger.debug("Connexion ok");
	}catch(Exception e){
		logger.error("Connexion non ok");
		e.printStackTrace();
	}
 }
	public void init(String sql) {
	try {
		openConnection();
		pstm = cnx.prepareStatement(sql);
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	public ResultSet executeUpdate() {
		try {
			
			rs = pstm.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void closeConnection() {
		try {
			if (cnx!= null) {
				cnx.close();
			}
			if(rs!= null) {
				rs.close();
			}
			if(pstm!= null) {
				pstm.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getPstm() {
		return pstm;
	}
	
	public ResultSet executeSelect() {
		try {
			rs = pstm.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int executeMaj() {
		try {
			ok = pstm.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}
	
	
}
