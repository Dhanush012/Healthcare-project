package com.project.appointmentManagement.Dto;

import java.util.List;

public class Responsedto {
	
	private List<Patientdto> patientdto;
	private Appointmentdto appointmentdto;
	
	
	
	public List<Patientdto> getPatientdto() {
		return patientdto;
	}
	public void setPatientdto(List<Patientdto> patientdto) {
		this.patientdto = patientdto;
	}
	public Appointmentdto getAppointmentdto() {
		return appointmentdto;
	}
	public void setAppointmentdto(Appointmentdto appointmentdto) {
		this.appointmentdto = appointmentdto;
	}
	@Override
	public String toString() {
		return "responsedto [patientdto=" + patientdto + ", appointmentdto=" + appointmentdto + "]";
	}
	public Responsedto(List<Patientdto> patientdto, Appointmentdto appointmentdto) {
		super();
		this.patientdto = patientdto;
		this.appointmentdto = appointmentdto;
	}
	public Responsedto() {
		super();
	}
	
	
}
