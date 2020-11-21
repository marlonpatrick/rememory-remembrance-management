package io.mpwtech.rememory.remembrancemanagement.rest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import io.mpwtech.rememory.remembrancemanagement.ComponentScanBasePackageClass;
import io.mpwtech.rememory.remembrancemanagement.rest.remembrance.TestMongoStreamingAppRunner;

@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackageClasses = {ComponentScanBasePackageClass.class})
public class RemembranceManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemembranceManagementRestApplication.class, args);
	}

	@Bean
	ApplicationRunner getAppRunner() {
		return new TestMongoStreamingAppRunner();
	}

}

