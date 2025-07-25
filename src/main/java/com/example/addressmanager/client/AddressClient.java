package com.example.addressmanager.client;

import com.example.addressmanager.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Defining as feign client
@FeignClient(name = "ADDRESS-SERVICE", url = "http://localhost:8080")
public interface AddressClient {

    // HTTP method POST
    @PostMapping(value = "/addresses")
    public ResponseEntity<Address> create(@RequestBody Address address);

    // HTTP method GET
    @GetMapping(value = "/addresses")
    public ResponseEntity<List<Address>> read();

    // HTTP method GET with specific ID
    @GetMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> read(@PathVariable(name = "id") long id);

    // HTTP method PUT
    @PutMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> update(@PathVariable(name = "id") long id, @RequestBody Address address);

    // HTTP method DELETE
    @DeleteMapping(value = "/addresses/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id);
}