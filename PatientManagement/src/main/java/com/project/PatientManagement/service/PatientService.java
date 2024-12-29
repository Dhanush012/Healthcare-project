package com.project.PatientManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.PatientManagement.model.Patient;
import com.project.PatientManagement.repository.PatientRepo;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepo repo;
	
	public Patient addPatient(Patient patient) {
		return repo.save(patient);
	}
	
	public List<Patient> getAllPatient(){
		return repo.findAll();
	}
	
	public List<Patient> getBydoctorNumber(int doctornumber){
		return repo.getByDoctorNumber(doctornumber);
	}
}
