package com.jdc.clinic.controller;

import static com.jdc.clinic.controller.utils.ProxyWorker.execute;
import static com.jdc.clinic.controller.utils.ProxyWorker.setMessage;
import static com.jdc.clinic.controller.utils.ViewHolder.getInstance;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.jdc.clinic.controller.base.BaseController;
import com.jdc.clinic.controller.utils.ViewHolder.ViewId;
import com.jdc.clinic.controller.utils.ViewHolder.ViewObject;
import com.jdc.clinic.model.entity.QueueInfo;
import com.jdc.clinic.model.entity.QueueInfo.Status;
import com.jdc.clinic.model.entity.QueueInfoPK;
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
	private Label title;

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
	
	private Consumer<QueueInfo> consumer;
	private QueueInfo queueInfo;
	
	private static Stage stage;
	
	public void save() {
		
		execute(() -> {
			
			if(null == queueInfo.getId()) {
				QueueInfoPK id = new QueueInfoPK();
				id.setRefDate(date.getValue());
				id.setType(type.getValue());			
				queueInfo.setId(id);
			}
			
			queueInfo.setName(name.getText());
			queueInfo.setPhone(phone.getText());
			
			consumer.accept(queueInfo);
			
			close();
		});
		
	}

	public void close() {
		setMessage(null);
		phone.getScene().getWindow().hide();
	}
	
	
	private void init(QueueInfo queueInfo, Consumer<QueueInfo> consumer) {
		this.consumer = consumer;
		this.queueInfo = queueInfo;
		
		if(null == queueInfo) {
			title.setText("Add New Queue");
			this.queueInfo = new QueueInfo();
			this.queueInfo.setStatus(Status.Register);
			date.setValue(null);
			date.setEditable(true);
			type.setValue(null);
			type.setDisable(false);
			name.clear();
			phone.clear();
		} else {
			title.setText("Edit Queue");
			date.setValue(queueInfo.getId().getRefDate());
			date.setEditable(false);
			type.setValue(queueInfo.getId().getType());
			type.setDisable(true);
			name.setText(queueInfo.getName());
			phone.setText(queueInfo.getPhone());
		}
	}

	public static void loadView(QueueInfo queueInfo, Consumer<QueueInfo> consumer) {
		execute(() -> {
			try {
				
				ViewObject<BaseController> vo = getInstance().getView(ViewId.QueueEdit);

				if(null == stage) {
					stage = new Stage(StageStyle.UNDECORATED);
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setScene(new Scene(vo.getRoot()));
				}
				
				QueueManagementEdit controller = (QueueManagementEdit) vo.getController();
				setMessage(controller.message);
				
				controller.init(queueInfo, consumer);
				
				stage.show();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		type.getItems().addAll(Type.values());
	}

}