package com.has.rl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.has.rl.dto.PatientDTO;
import com.has.rl.dto.RegistrationResponse;
import com.has.rl.service.PatientServiceImpl;

@RestController
@RequestMapping("/healthcareappsys")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegLogController {
	
	@Autowired
	PatientServiceImpl patientService;
	
	@PostMapping("/registerpatient")
	public ResponseEntity<RegistrationResponse> registerUser(@RequestBody PatientDTO patient) {
		
		
		
		RegistrationResponse regRes = null;
		return new ResponseEntity<RegistrationResponse>(regRes, HttpStatus.OK);
	}
}
