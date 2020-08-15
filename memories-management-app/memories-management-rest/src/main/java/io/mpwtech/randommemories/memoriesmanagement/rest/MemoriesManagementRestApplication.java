package io.mpwtech.randommemories.memoriesmanagement.rest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import io.mpwtech.randommemories.memoriesmanagement.ComponentScanBasePackageClass;
import io.mpwtech.randommemories.memoriesmanagement.rest.memory.TestMongoStreamingAppRunner;

@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackageClasses = {ComponentScanBasePackageClass.class})
public class MemoriesManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesManagementRestApplication.class, args);
	}

	@Bean
	ApplicationRunner getAppRunner() {
		return new TestMongoStreamingAppRunner();
	}

}

