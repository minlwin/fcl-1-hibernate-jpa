package com.jdc.clinic.controller.utils;

import java.util.HashMap;
import java.util.Map;

import com.jdc.clinic.controller.*;
import com.jdc.clinic.controller.base.BaseController;

import javafx.scene.Parent;

public class ViewHolder<T extends BaseController> {
	
	private static ViewHolder<BaseController> instance;
	
	public static ViewHolder<BaseController> getInstance() {
		
		if(null == instance) {
			instance = new ViewHolder<BaseController>();
		}
		
		return instance;
	}
	
	private ViewHolder() {
		try {
			map = new HashMap<>();
			
			for(ViewId id : ViewId.values()) {
				map.put(id, ViewLoader.loadViewObject(id.controller));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<ViewId, ViewObject<T>> map;
	
	public ViewObject<T> getView(String viewId) {
		return map.get(ViewId.valueOf(viewId));
	}

	public ViewObject<T> getView(ViewId viewId) {
		return map.get(viewId);
	}

	public static class ViewObject<T> {

		private Parent root;
		private T controller;
		
		public ViewObject(Parent root, T controller) {
			super();
			this.root = root;
			this.controller = controller;
		}

		public Parent getRoot() {
			return root;
		}

		public void setRoot(Parent root) {
			this.root = root;
		}

		public T getController() {
			return controller;
		}

		public void setController(T controller) {
			this.controller = controller;
		}

	}

	public static enum ViewId {

		Home("Clinic Management", Report.class), 
		PatientsEdit("Add New Patient", PatientEdit.class),
		Patients("Patients Management", PatientManagement.class),
		Queue("Queue Management", QueueManagement.class),
		QueueEdit("Queue Edit", QueueManagementEdit.class),
		Registry("Daily Registrations", DailyRegistrations.class);

		private String title;
		private Class<?> controller;

		private ViewId(String title, Class<?> controller) {
			this.title = title;
			this.controller = controller;
		}

		public String getTitle() {
			return title;
		}

		public Class<?> getController() {
			return controller;
		}
	}
}
