package com.jdc.clinic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.base.BaseController;
import com.jdc.clinic.controller.utils.ViewHolder;
import com.jdc.clinic.controller.utils.ViewHolder.ViewId;
import com.jdc.clinic.controller.utils.ViewHolder.ViewObject;
import com.jdc.clinic.model.entity.QueueInfo;
import com.jdc.clinic.model.entity.Registration;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DailyRegistrationEdit implements BaseController{
	
	@FXML
	private TextField queue;
	@FXML
	private TextField patient;
	@FXML
	private TextField phone;

	public static void loadView(QueueInfo queue) {
		ViewObject<BaseController> vo = ViewHolder.getInstance().getView(ViewId.RegistrationEdit);
		DailyRegistrationEdit edit = (DailyRegistrationEdit) vo.getController();
		edit.queue.setText(queue.getQueue());
		edit.patient.setText(queue.getName());
		edit.phone.setText(queue.getPhone());
		
		ClinicHome.getController().loadView(ViewId.RegistrationEdit);
	}

    public void save() {
        // TODO implement here
    }

    public void clear() {
        // TODO implement here
    }

    public void close() {
        // TODO implement here
    }

    public static void loadView(Registration r) {
        // TODO implement here
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}