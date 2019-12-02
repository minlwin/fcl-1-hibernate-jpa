package com.jdc.clinic.model.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.jdc.clinic.model.ClinicException;

public class LoginService {
	
	private Properties app;
	
	private static LoginService service;
	
	private String loginUser;
	
	public static LoginService getService() {
		
		if(null == service) {
			service = new LoginService();
		}
		
		return service;
	}
	
	private LoginService() {
		try {
			app = new Properties();
			app.load(new FileInputStream("config/application.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getAppName() {
		return app.getProperty("app.name");
	}
	
	public String getLoginUser() {
		return loginUser;
	}

	public void login(String loginId, String password) {
		
		if(loginId.isEmpty()) {
			ClinicException.throwAsMessage("Please enter Login Id.");
		}
		
		if(!loginId.equals(app.getProperty("app.user.login"))) {
			ClinicException.throwAsMessage("Please check Login Id.");
		}

		if(password.isEmpty()) {
			ClinicException.throwAsMessage("Please enter Password.");
		}
		
		if(!password.equals(app.getProperty("app.user.password"))) {
			ClinicException.throwAsMessage("Please check Password.");
		}

		this.loginUser = app.getProperty("app.user.name");
	}

}