package com.jdc.clinic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.base.BaseController;
import com.jdc.clinic.controller.base.NeedToAddController;
import com.jdc.clinic.controller.base.ViewController;
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

public class ClinicHome implements Initializable, ViewController {

	@FXML
	private VBox sideMenu;
	@FXML
	private StackPane content;
	@FXML
	private Label header;
	@FXML
	private VBox addButton;
	
	private static ViewController controller;
	
	private static String ACTIVE_BACK = "p-light";
	private static String ACTIVE_TEXT = "white";

	public static void loadView() {
		Stage stage = new Stage(StageStyle.UNDECORATED);
		stage.setScene(new Scene(ViewLoader.loadView(ClinicHome.class)));
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		controller = this;
		
		ViewHolderLoadService service = new ViewHolderLoadService();
		
		service.setOnSucceeded(event -> {
			loadView(ViewId.Home);
		});
		
		service.start();
	}

	public void mouseClickMenu(MouseEvent event) {

		Object source = event.getSource();

		if (source instanceof VBox) {

			VBox menu = (VBox) source;

			if ("Logout".equals(menu.getId())) {
				menu.getScene().getWindow().hide();
			} else {				
				ViewId viewId = ViewId.valueOf(menu.getId());
				loadView(viewId);
			}
		}

	}
	
	public static ViewController getController() {
		return controller;
	}
		
	public void loadView(ViewId viewId) {
		
		// Add View Object to Content
		ViewObject<BaseController> vo = ViewHolder.getInstance().getView(viewId);
		header.setText(viewId.getTitle());
		content.getChildren().clear();
		content.getChildren().add(vo.getRoot());
		
		// Handle show or hide add button
		if(vo.getController() instanceof NeedToAddController) {
			
			addButton.setVisible(true);
			
			NeedToAddController adder = (NeedToAddController) vo.getController();
			
			addButton.setOnMouseClicked(event  -> {
				adder.addNew();
			});
		} else {
			addButton.setVisible(false);
		}
		
		// Activate Selected Menu
		sideMenu.getChildren().stream()
			.filter(menu -> menu.getId().equals(viewId.name()))
			.findAny().ifPresent(menu -> {
				// Remove All Active Style
				sideMenu.getChildren().forEach(a -> {
					
					a.getStyleClass().remove(ACTIVE_BACK);
					
					if(a instanceof VBox) {
						VBox box = (VBox) a;
						box.getChildren().forEach(b -> b.getStyleClass().remove(ACTIVE_TEXT));
					}
				});
				
				// activate menu
				activate((VBox) menu);
			});
	}
	
	private void activate(VBox menu) {
		menu.getStyleClass().add(ACTIVE_BACK);
		menu.getChildren().forEach(a  -> a.getStyleClass().add(ACTIVE_TEXT));
	}

}