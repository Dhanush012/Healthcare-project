package com.project.PatientManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.PatientManagement.model.PatientUser;

@Repository
public interface UserRepo extends JpaRepository<PatientUser,Integer>{

	PatientUser findByUsername(String username);

}
