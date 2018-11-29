package com.trustrace.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trustrace.service.CertificateService;
@RequestMapping("/certificate")
@RestController
public class CertificateController {
	private static final Logger logger = LoggerFactory.getLogger(CertificateController.class);


	@Autowired
	private CertificateService certificateService;

	@PostMapping("/verify")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			return ResponseEntity.ok().body(certificateService.verify(file));
		}
		catch(Exception ex)
		{
			logger.error("Exception", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
		
		
	}

	
}
