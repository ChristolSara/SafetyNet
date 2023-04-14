package com.SafetyNet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;


@SpringBootApplication
@EnableSwagger2

public class SafetyNetApplication  {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SafetyNetApplication.class, args);

	}
}