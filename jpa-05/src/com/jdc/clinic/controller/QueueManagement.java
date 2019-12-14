package com.jdc.clinic.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.base.NeedToAddController;
import com.jdc.clinic.controller.base.SearchableController;
import com.jdc.clinic.model.entity.QueueInfo;
import com.jdc.clinic.model.entity.QueueInfo.Status;
import com.jdc.clinic.model.entity.TokenNumber.Type;
import com.jdc.clinic.model.service.QueueService;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class QueueManagement implements SearchableController, NeedToAddController {

	@FXML
	private DatePicker from;
	@FXML
	private ComboBox<Type> section;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	
	@FXML
	private TableView<QueueInfo> table;
	
	private QueueService service;

	public void search() {
		table.getItems().clear();
		List<QueueInfo> list = service.search(from.getValue(), section.getValue(), name.getText(), phone.getText());
		table.getItems().addAll(list);
	}

	public void addNew() {
		QueueManagementEdit.loadView(null, this::save);
	}

	private void save(QueueInfo q) {
		service.save(q);
		search();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		section.getItems().addAll(Type.values());
		service = QueueService.getService();
		clear();
		
		ContextMenu menu = new ContextMenu();
		MenuItem edit = new MenuItem("Edit Queue");
		edit.setOnAction(event -> {
			QueueInfo queueInfo = table.getSelectionModel().getSelectedItem();
			if(null != queueInfo) {
				QueueManagementEdit.loadView(queueInfo, this::save);
			}
		});
		
		MenuItem regist = new MenuItem("Check In");
		regist.setOnAction(event -> {
			
		});
		
		MenuItem delete = new MenuItem("Cancel");
		delete.setOnAction(event -> {
			QueueInfo queueInfo = table.getSelectionModel().getSelectedItem();
			if(null != queueInfo) {
				queueInfo.setStatus(Status.Cancel);
				service.save(queueInfo);
			}
			search();
		});
		
		menu.getItems().addAll(edit, regist, delete);
		table.setContextMenu(menu);
		
	}

	@Override
	public void clear() {

		from.setValue(LocalDate.now());
		section.setValue(null);
		name.clear();
		phone.clear();
		table.getItems().clear();
	}

}