package com.example.addressmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AddressManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressManagerApplication.class, args);
	}
}

/*
TO DO:
- implement all crud operations from the backend (UI)
- implement data binding and validation (UI)
- database migration to local database
- implement unit tests
- implement security and login
- add source code comments
- use JavaDoc in source code
 */