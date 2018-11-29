package com.trustrace.certificate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.trustrace.config.FileStorageProperties;
@EnableConfigurationProperties({
    FileStorageProperties.class
})
@SpringBootApplication(scanBasePackages= {"com.trustrace"})
public class CertificateValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertificateValidatorApplication.class, args);
	}
}
