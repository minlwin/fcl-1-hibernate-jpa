package com.jdc.clinic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.clinic.controller.base.NeedToAddController;
import com.jdc.clinic.controller.base.SearchableController;
import com.jdc.clinic.controller.utils.ViewHolder.ViewId;
import com.jdc.clinic.model.entity.Patient;
import com.jdc.clinic.model.service.PatientService;

public class PatientManagement implements SearchableController , NeedToAddController{

    public PatientManagement() {
    }

    private PatientService service;

    public void addNew() {
    	ClinicHome.getController().loadView(ViewId.PatientsEdit);
    }

    public void showDetails() {
        // TODO implement here
    }

    public void edit() {
        // TODO implement here
    }

    private void save(Patient p) {
        // TODO implement here
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}