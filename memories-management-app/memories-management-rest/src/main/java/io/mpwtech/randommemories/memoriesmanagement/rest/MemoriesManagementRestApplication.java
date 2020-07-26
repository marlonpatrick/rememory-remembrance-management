package io.mpwtech.randommemories.memoriesmanagement.rest;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ServletComponentScan
@SpringBootApplication
public class MemoriesManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesManagementRestApplication.class, args);
	}

	@Autowired
	Environment env;

	@GetMapping("/")
	public String test(Locale locale) {
		return "Hello World|" + List.of(env.getActiveProfiles()) + "|"
				+ env.getProperty("spring.application.name") + "|" + locale;
	}
}

