package com.jdc.clinic.controller;

import static com.jdc.clinic.model.ProxyWorker.execute;
import static com.jdc.clinic.model.ProxyWorker.setMessage;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.model.service.LoginService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login implements Initializable{

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

	public static void loadView(Stage stage) throws Exception{

		Parent root = FXMLLoader.load(Login.class.getResource("Login.fxml"));
		stage.setScene(new Scene(root));
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		service = LoginService.getService();
		setMessage(message);
	}

}