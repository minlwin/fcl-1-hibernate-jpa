package com.jdc.clinic.controller.utils;

import java.io.IOException;

import com.jdc.clinic.controller.base.BaseController;
import com.jdc.clinic.controller.utils.ViewHolder.ViewObject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ViewLoader {
	
	public static<T> Parent loadView(Class<T> controller) {
		try {
			String view  = controller.getSimpleName().concat(".fxml");
			return FXMLLoader.load(controller.getResource(view));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static<T extends BaseController> ViewObject<T> loadViewObject(Class<?> controller) {
		try {

			String view  = controller.getSimpleName().concat(".fxml");
			FXMLLoader loader = new FXMLLoader(controller.getResource(view));
			Parent root = loader.load();
			return new ViewObject<T>(root, loader.getController());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
