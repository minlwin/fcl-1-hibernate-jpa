package com.jdc.clinic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.utils.ViewLoader;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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

	public static void loadView() {
		Stage stage = new Stage(StageStyle.UNDECORATED);
		stage.setScene(new Scene(ViewLoader.loadView(ClinicHome.class)));
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void mouseOnMenu(MouseEvent event) {
		Object source = event.getSource();

		if (source instanceof VBox) {
			VBox menu = (VBox) source;
			menu.getStyleClass().add("s-dark");
		}
	}

	public void mouseDownMenu(MouseEvent event) {
		Object source = event.getSource();

		if (source instanceof VBox) {
			VBox menu = (VBox) source;
			menu.getStyleClass().remove("s-dark");
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
			}
		}

	}

}