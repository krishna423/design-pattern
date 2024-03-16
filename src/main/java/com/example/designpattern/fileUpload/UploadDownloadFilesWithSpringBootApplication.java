package com.example.designpattern.fileUpload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		exclude = {
				SecurityAutoConfiguration.class,
		})
@EnableConfigurationProperties({
    FileStoragePojo.class
})
public class UploadDownloadFilesWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadDownloadFilesWithSpringBootApplication.class, args);
	}


}
