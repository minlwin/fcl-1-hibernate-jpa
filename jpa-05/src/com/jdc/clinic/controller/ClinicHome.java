package com.jdc.clinic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.base.BaseController;
import com.jdc.clinic.controller.utils.ViewHolder;
import com.jdc.clinic.controller.utils.ViewHolderLoadService;
import com.jdc.clinic.controller.utils.ViewLoader;
import com.jdc.clinic.controller.utils.ViewHolder.ViewId;
import com.jdc.clinic.controller.utils.ViewHolder.ViewObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClinicHome implements Initializable {

	@FXML
	private VBox sideMenu;
	@FXML
	private StackPane content;
	@FXML
	private Label header;
	
	private static String HOVER_BACK = "p-color";
	private static String HOVER_TEXT = "white";

	public static void loadView() {
		Stage stage = new Stage(StageStyle.UNDECORATED);
		stage.setScene(new Scene(ViewLoader.loadView(ClinicHome.class)));
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ViewHolderLoadService service = new ViewHolderLoadService();
		
		service.setOnSucceeded(event -> {
			loadView(ViewId.Home);
		});
		
		service.start();
	}

	public void mouseOnMenu(MouseEvent event) {
		Object source = event.getSource();

		if (source instanceof VBox) {
			VBox menu = (VBox) source;
			menu.getStyleClass().add(HOVER_BACK);
			menu.getChildren().forEach(node  -> node.getStyleClass().add(HOVER_TEXT));
		}
	}

	public void mouseDownMenu(MouseEvent event) {
		Object source = event.getSource();

		if (source instanceof VBox) {
			VBox menu = (VBox) source;
			menu.getStyleClass().remove(HOVER_BACK);
			menu.getChildren().forEach(node  -> node.getStyleClass().remove(HOVER_TEXT));
		}
	}

	public void mouseClickMenu(MouseEvent event) {

		Object source = event.getSource();

		if (source instanceof VBox) {

			VBox menu = (VBox) source;

			if ("Logout".equals(menu.getId())) {
				menu.getScene().getWindow().hide();
			} else {
				sideMenu.getChildren().forEach(a -> a.getStyleClass().remove("s-color"));
				menu.getStyleClass().add("s-color");
				
				ViewId viewId = ViewId.valueOf(menu.getId());
				loadView(viewId);
			}
		}

	}
	
	private void loadView(ViewId viewId) {
		ViewObject<BaseController> vo = ViewHolder.getInstance().getView(viewId);
		header.setText(viewId.getTitle());
		content.getChildren().clear();
		content.getChildren().add(vo.getRoot());
	}

}