package com.groupeisi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.entities.User;

public class IUserImp  implements IUser{
private DB db = new DB();
private int ok;
private ResultSet rs;
public int create(User user) {
		
		try {
			String sql = "INSERT INTO users VALUES(null, ?, ?)";
			db.init(sql);
			db.getPstm().setString(1, user.getEmail());
			db.getPstm().setString(2, user.getPassword());
			db.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	public int update(User user) {
		String sql = "UPDATE users SET classe = ?, WHERE id = ?";
		try {
			db.init(sql);		
			db.getPstm().setInt(1, user.getId());
			db.getPstm().setString(3, user.getClasse());
			ok = db.executeMaj();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	public int remove(int id) {
		try {
			String sql = "DELETE FROM users WHERE id = ?";
			db.init(sql);
			db.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return id;
	}

	public User get(int id) {
		try {
			String sql = "DELETE FROM users WHERE id = ?";
			db.init(sql);
			db.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<User> getAll() {
		List<User> uuser = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		try {
			db.init(sql);
			ResultSet rs = db.executeSelect();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPassword(rs.getString(3));
				uuser.add(u);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return uuser;
	}


	public User login (String email, String password) {
		try {
			String sql = "SELECT * FROM users WHERE email = ?, password = ?";
			db.init(sql);
			User u = new User();
			u.setEmail(rs.getString(1));
			u.setPassword(rs.getString(2));
			db.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return login(email, password);
		
	}

}
