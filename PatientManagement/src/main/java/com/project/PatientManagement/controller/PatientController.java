package com.project.PatientManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.PatientManagement.model.Patient;
import com.project.PatientManagement.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@PostMapping("/addpatient")
	public Patient addPatient(@RequestBody Patient patient) {
		return service.addPatient(patient);
	}
	
	@GetMapping("/getallpatient")
	public List<Patient> getallPatient(){
		return service.getAllPatient();
	}
	
	@GetMapping("{doctorNumber}")
	public List<Patient> getBydoctorNumber(@PathVariable("doctorNumber") int doctornumber){
		return service.getBydoctorNumber(doctornumber);
	}
}
