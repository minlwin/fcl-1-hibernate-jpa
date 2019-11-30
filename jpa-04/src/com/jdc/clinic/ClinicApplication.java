package com.jdc.clinic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClinicApplication extends Application{
	
	private static EntityManagerFactory EMF;
	
	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("PatientList.fxml"));
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	@Override
	public void init() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa-04");
	}
	
	@Override
	public void stop() throws Exception {
		EMF.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
