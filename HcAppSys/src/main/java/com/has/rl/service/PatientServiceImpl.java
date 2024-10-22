package com.has.rl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.has.rl.repository.PatientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
}
