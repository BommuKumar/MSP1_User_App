package com.naresh.Database.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.naresh.Database.Dto.PatientDto;

@FeignClient(name="MSP2-Patient-App")
public interface PatientFeignClients {
	
  @PostMapping(path="Patient/create/patient")
	
	public ResponseEntity<Integer>  createPatient(@RequestBody PatientDto patientDto);

}
