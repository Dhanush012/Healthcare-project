package com.project.appointmentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.appointmentManagement.Dto.Responsedto;
import com.project.appointmentManagement.model.Appointment;
import com.project.appointmentManagement.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;
	
	@PostMapping("/addAppointment")
	public Appointment addAppointment(@RequestBody Appointment appointment) {
		return service.addAppointment(appointment);
	}
	
	
	@GetMapping("/getappointment")
	public List<Appointment> getAllappointment(){
		return service.getAllAppointments();
	}
	
	@GetMapping("{doctorNumber}")
	public Responsedto getPatient(@PathVariable("doctorNumber") int doctorNumber) {
		return service.getPatient(doctorNumber);
	}
}
