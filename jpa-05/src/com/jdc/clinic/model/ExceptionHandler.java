package com.jdc.clinic.model;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class ExceptionHandler {
	
	private static Label message;
	
	public static void setMessage(Label message) {
		ExceptionHandler.message = message;
	}
	
	public static void handle(Throwable ex) {
		
		if(ex instanceof ClinicException) {
			handle((ClinicException)ex);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fatal Error");
			alert.setContentText("Please contact to Development Team.");
			
			alert.setOnHiding(event -> {
				Platform.exit();
			});
			
			alert.show();
		}
	}
	

	private static void handle(ClinicException ex) {
		
		if(ex.isShowPopUp()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fatal Error");
			alert.setContentText(ex.getMessage());
			alert.show();
		} else  {
			message.setText(ex.getMessage());
		}
		
	}

}
