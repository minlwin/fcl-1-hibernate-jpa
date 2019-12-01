package com.jdc.clinic.model.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class LoginService {
	
	private static Properties app;
	
	static {
		try {
			app = new Properties();
			app.load(Files.newInputStream(Paths.get("config/application.propreties"), StandardOpenOption.READ));
		} catch (Exception e) {
			e.getSuppressed();
		}
	}

	public String login(String loginId, String password) {
		
		if(loginId.isEmpty()) {
			
		}
		
		if(!loginId.equals(app.getProperty(""))) {
			
		}

		if(password.isEmpty()) {
			
		}
		
		if(!password.equals(app.getProperty(""))) {
			
		}

		return app.getProperty("");
	}

}