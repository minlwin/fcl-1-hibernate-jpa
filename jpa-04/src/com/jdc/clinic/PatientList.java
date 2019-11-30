package com.jdc.clinic;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jdc.clinic.model.PatientRepo;
import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.entity.Patient.Gender;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PatientList implements Initializable{
	
	@FXML
	private ComboBox<Gender> gender;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private TableView<Patient> table;
	
	private PatientRepo repo;
	
	public void search() {
		
		table.getItems().clear();
		List<Patient> list = repo.search(gender.getValue(), name.getText(), phone.getText());
		table.getItems().addAll(list);
		
	}
	
	public void add() {
		PatientEdit.show(this::save);
	}
	
	private void save(Patient patient) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		repo = new PatientRepo(ClinicApplication.getEntityManager());
		gender.getItems().addAll(Gender.values());
	}

}
