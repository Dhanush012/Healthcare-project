package com.project.appointmentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.appointmentManagement.Dto.Appointmentdto;
import com.project.appointmentManagement.Dto.Patientdto;
import com.project.appointmentManagement.Dto.Responsedto;
import com.project.appointmentManagement.model.Appointment;
import com.project.appointmentManagement.repository.AppointmentRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AppointmentService {

    @Autowired
    private WebClient webclient;

    @Autowired
    private AppointmentRepo repo;

    public List<Appointment> getAllAppointments() {
        return repo.findAll();
    }

    public Appointment addAppointment(Appointment appointment) {
        return repo.save(appointment);
    }

    @CircuitBreaker(name = "appointmentService", fallbackMethod = "fallbackGetPatient")
    public Responsedto getPatient(int doctorNumber) {
        Responsedto responseDto = new Responsedto();

        // Fetch all appointments by doctor number
        List<Appointment> appointments = repo.findByDoctorNumber(doctorNumber);
        if (appointments.isEmpty()) {
            throw new RuntimeException("No appointments found for the specified doctor number");
        }

        // Map the first appointment to AppointmentDto (assuming one-to-one mapping)
        Appointmentdto appointmentDto = mapToAppointmentDto(appointments.get(0));

        // Fetch patient data using WebClient
        List<Patientdto> patientDtos = webclient.get()
                .uri("http://localhost:8085/patients/" + doctorNumber)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Patientdto>>() {})
                .block();

        // Populate response DTO
        responseDto.setAppointmentdto(appointmentDto);
        responseDto.setPatientdto(patientDtos);

        return responseDto;
    }

    public Responsedto fallbackGetPatient(int doctorNumber, Throwable throwable) {
        // Handle fallback logic
        Responsedto fallbackResponse = new Responsedto();
        fallbackResponse.setAppointmentdto(null); // No appointment in fallback
        fallbackResponse.setPatientdto(null); // No patient details in fallback
        return fallbackResponse;
    }

    private Appointmentdto mapToAppointmentDto(Appointment appointment) {
        Appointmentdto dto = new Appointmentdto();
        dto.setId(appointment.getId());
        dto.setDoctorNumber(appointment.getDoctorNumber());
        dto.setAppointmentNumber(appointment.getAppointmentNumber());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        return dto;
    }
    
    
}
