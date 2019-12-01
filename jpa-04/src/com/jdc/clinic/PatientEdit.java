package com.jdc.clinic;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.jdc.clinic.model.PatientException;
import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.entity.Patient.Gender;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
	
	@FXML
	private Label message;
	
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
		
		try {
			
			if(name.getText().isEmpty()) {
				throw new PatientException("Please enter Patient's name.");
			}
			
			if(dob.getValue() == null) {
				throw new PatientException("Please enter date of birth.");
			}
			
			if(gender.getValue() == null) {
				throw new PatientException("Please select gender.");
			}
			
			if(weight.getText().isEmpty()) {
				throw new PatientException("Please enter weight.");
			}
			
			if(phone.getText().isEmpty()) {
				throw new PatientException("Please enter Phone Number.");
			}
			
			Patient patient = new Patient();
			patient.setName(name.getText());
			patient.setAddress(address.getText());
			patient.setDob(dob.getValue());
			patient.setGender(gender.getValue());
			patient.setWeight(Integer.parseInt(weight.getText()));
			patient.setPhone(phone.getText());
			
			saveListener.accept(patient);
			
			name.getScene().getWindow().hide();			
		} catch (NumberFormatException e) {
			message.setText("Please enter weight with digit.");
		} catch (PatientException e) {
			message.setText(e.getMessage());
		}
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gender.getItems().addAll(Gender.values());
	}
}
