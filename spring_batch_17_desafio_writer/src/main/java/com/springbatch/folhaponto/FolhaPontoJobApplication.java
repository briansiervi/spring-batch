package com.springbatch.folhaponto;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FolhaPontoJobApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
		SpringApplication.run(FolhaPontoJobApplication.class, args);
	}

}
