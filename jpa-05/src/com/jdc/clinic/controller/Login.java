package com.jdc.clinic.controller;

import static com.jdc.clinic.controller.utils.ProxyWorker.execute;
import static com.jdc.clinic.controller.utils.ProxyWorker.setMessage;

import com.jdc.clinic.model.service.LoginService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login {

    private LoginService service;
    
    @FXML
    private Label message;
    @FXML
    private TextField loginId;
    @FXML
    private PasswordField password;

    public void login() {
    	execute(() -> {
    		// Login
    		service.login(loginId.getText(), password.getText());
    		
    		// Load Clinic Home
    		ClinicHome.loadView();
    		
    		// Close Login View
    		message.getScene().getWindow().hide();
    	});
    }
    
    public void close() {
    	loginId.getScene().getWindow().hide();
    }

	public static void loadView(Stage stage) throws Exception{

		Parent root = FXMLLoader.load(Login.class.getResource("Login.fxml"));
		stage.setScene(new Scene(root));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}

	@FXML
	private void initialize() {
		service = LoginService.getService();
		setMessage(message);
	}

}