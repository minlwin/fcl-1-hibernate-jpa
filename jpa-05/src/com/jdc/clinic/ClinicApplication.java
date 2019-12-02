package com.jdc.clinic;

import com.jdc.clinic.controller.Login;
import com.jdc.clinic.model.ModelContext;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClinicApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Login.loadView(stage);
	}
	
	@Override
	public void init() throws Exception {
		ModelContext.init();
	}
	
	@Override
	public void stop() throws Exception {
		ModelContext.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}