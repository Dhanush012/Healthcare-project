package com.project.appointmentManagement.Dto;

import java.time.LocalDateTime;


public class Appointmentdto {
	
    private Long id;
    private int appointmentNumber;
    private int doctorNumber;
    private LocalDateTime appointmentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentNumber=" + appointmentNumber + ", doctorNumber=" + doctorNumber
				+ ", appointmentTime=" + appointmentTime + "]";
	}
	public Appointmentdto(Long id, int appointmentNumber, int doctorNumber, LocalDateTime appointmentTime) {
		super();
		this.id = id;
		this.appointmentNumber = appointmentNumber;
		this.doctorNumber = doctorNumber;
		this.appointmentTime = appointmentTime;
	}
	public Appointmentdto() {
		super();
	}
}
