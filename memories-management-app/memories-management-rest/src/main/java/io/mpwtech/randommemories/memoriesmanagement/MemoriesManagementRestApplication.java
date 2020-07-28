package io.mpwtech.randommemories.memoriesmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@ServletComponentScan
@SpringBootApplication
public class MemoriesManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoriesManagementRestApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello!";
	}
}

