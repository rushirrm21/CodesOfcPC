package com.has.rl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.has.rl.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String>{

}
