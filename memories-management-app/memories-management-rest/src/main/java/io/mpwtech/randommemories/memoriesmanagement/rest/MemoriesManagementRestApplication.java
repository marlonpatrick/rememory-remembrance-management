package io.mpwtech.randommemories.memoriesmanagement.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import io.mpwtech.randommemories.memoriesmanagement.ComponentScanBasePackageClass;

@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackageClasses = {ComponentScanBasePackageClass.class})
public class MemoriesManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesManagementRestApplication.class, args);
	}
}

