package com.groupeisi.presentation;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.groupeisi.dao.IUser;
import com.groupeisi.dao.IUserImp;
import com.groupeisi.entities.User;

public class Main {

	private static Logger logger;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		IUser userdao = new IUserImp();
		User user = new User();
		user.setEmail("isi@groupeisi.com");
		user.setPassword("passer123#@");
		int result = userdao.create(user);
		
		logger.debug(result);	
	}

}
