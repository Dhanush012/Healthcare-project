package com.project.appointmentManagement.Dto;

public class Patientdto {
	private int id;
	private String patientName;
	private String email;
	private int appointmentNumber;
	private int doctorNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(int appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}
	public int getDoctorNumber() {
		return doctorNumber;
	}
	public void setDoctorNumber(int doctorNumber) {
		this.doctorNumber = doctorNumber;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientName=" + patientName + ", email=" + email + ", appointmentNumber="
				+ appointmentNumber + ", doctorNumber=" + doctorNumber + "]";
	}
	public Patientdto(int id, String patientName, String email, int appointmentNumber, int doctorNumber) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.email = email;
		this.appointmentNumber = appointmentNumber;
		this.doctorNumber = doctorNumber;
	}
	public Patientdto() {
		super();
	}
}
