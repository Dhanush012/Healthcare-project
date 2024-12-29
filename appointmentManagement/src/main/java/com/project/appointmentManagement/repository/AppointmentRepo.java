package com.project.appointmentManagement.repository;

import java.util.List;
import java.util.Optional;

//import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.project.appointmentManagement.Dto.Responsedto;
import com.project.appointmentManagement.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
	
//    boolean existsByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
	List<Appointment> findByDoctorNumber(int doctorNumber);

}
