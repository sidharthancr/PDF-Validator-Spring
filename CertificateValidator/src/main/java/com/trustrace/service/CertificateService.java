package com.trustrace.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trustrace.beans.VerificationStatus;
import com.trustrace.constants.AppConstants;
import com.trustrace.utils.PDFUtill;

@Service
public class CertificateService {
	private static final Logger logger = LoggerFactory.getLogger(CertificateService.class);
	@Autowired
	FileStorageService fileStorageService;

	public VerificationStatus verify(MultipartFile file) throws IOException {
		VerificationStatus verificationStatus = new VerificationStatus();
		try {
			File givenFile = new File("temp");
			file.transferTo(givenFile);
			InputStream sampleFile = fileStorageService.loadFileAsResource(AppConstants.SAMPLE_DOC).getInputStream();
			String sampleData = PDFUtill.read(sampleFile);
			String givenData = PDFUtill.read(file.getInputStream());
			verificationStatus.status = sampleData.equals(givenData) ? AppConstants.VALID : AppConstants.INVALID;
		} catch (IOException e) {
			logger.error("Exception when accessing sample doc", e);
			throw e;
		}
		return verificationStatus;

	}

}
