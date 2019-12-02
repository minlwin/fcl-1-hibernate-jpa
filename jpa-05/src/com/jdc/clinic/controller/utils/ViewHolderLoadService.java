package com.jdc.clinic.controller.utils;

import com.jdc.clinic.controller.base.BaseController;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ViewHolderLoadService extends Service<ViewHolder<BaseController>> {

	@Override
	protected Task<ViewHolder<BaseController>> createTask() {

		return new Task<ViewHolder<BaseController>>() {

			@Override
			protected ViewHolder<BaseController> call() throws Exception {
				return ViewHolder.getInstance();
			}
		};
	}

}
