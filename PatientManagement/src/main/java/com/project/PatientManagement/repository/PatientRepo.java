package com.project.PatientManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.PatientManagement.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer>{

	List<Patient> getByDoctorNumber(int doctornumber);

}
