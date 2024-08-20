package com.naresh.Database.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.naresh.Database.Dto.DoctorDto;

@FeignClient("MSP3-Doctor-App")
public interface DoctorFeignClient {
	
	@PostMapping(path="doctor/create/doctor")
	public ResponseEntity<Integer> createDoctor(@RequestBody DoctorDto doctorDto);
	 
}
