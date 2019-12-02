package com.jdc.clinic.controller.utils;

import java.io.IOException;

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

}
