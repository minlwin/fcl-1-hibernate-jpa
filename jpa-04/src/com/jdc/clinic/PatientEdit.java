package com.jdc.clinic;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.entity.Patient.Gender;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PatientEdit implements Initializable{
	
	@FXML
	private ComboBox<Gender> gender;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private TextField weight;
	@FXML
	private DatePicker dob;
	@FXML
	private TextArea address;
	
	private Consumer<Patient> saveListener;
	
	public static void show(Consumer<Patient> saveListener) {
		
		try {
			
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(PatientEdit.class.getResource("PatientEdit.fxml"));
			
			Parent root = loader.load();
			PatientEdit controller = loader.getController();
			controller.saveListener = saveListener;
			
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void clear() {
		gender.setValue(null);
		name.clear();
		phone.clear();
		weight.clear();
		dob.setValue(null);
		address.clear();
	}
	
	public void save() {
		
		Patient patient = new Patient();
		patient.setName(name.getText());
		patient.setAddress(address.getText());
		patient.setDob(dob.getValue());
		patient.setGender(gender.getValue());
		patient.setWeight(Integer.parseInt(weight.getText()));
		patient.setPhone(phone.getText());
		
		saveListener.accept(patient);
		
		name.getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gender.getItems().addAll(Gender.values());
	}
}
