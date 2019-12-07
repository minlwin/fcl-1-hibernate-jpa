package com.jdc.clinic.controller;

import static com.jdc.clinic.controller.utils.ProxyWorker.*;
import static com.jdc.clinic.controller.utils.ViewHolder.getInstance;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.base.BaseController;
import com.jdc.clinic.controller.utils.ViewHolder.ViewId;
import com.jdc.clinic.controller.utils.ViewHolder.ViewObject;
import com.jdc.clinic.model.entity.TokenNumber.Type;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QueueManagementEdit implements BaseController{

	@FXML
	private DatePicker date;
	@FXML
	private ComboBox<Type> type;
	@FXML
	private TextField name;
	@FXML
	private TextField phone;
	@FXML
	private Label message;
	
	public void save() {
		
	}

	public void close() {
		phone.getScene().getWindow().hide();
	}

	public static void loadView() {
		execute(() -> {
			try {
				Stage stage = new Stage(StageStyle.UNDECORATED);
				stage.initModality(Modality.APPLICATION_MODAL);
				
				ViewObject<BaseController> vo = getInstance().getView(ViewId.QueueEdit);
				
				stage.setScene(new Scene(vo.getRoot()));

				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		type.getItems().addAll(Type.values());
		setMessage(message);
	}

}