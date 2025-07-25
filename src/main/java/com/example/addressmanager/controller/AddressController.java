package com.example.addressmanager.controller;

import com.example.addressmanager.model.Address;
import com.example.addressmanager.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AddressController {

    // Creating variable of type AddressService
    private final AddressService addressService;

    // Dependency injection of AddressRepository
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // HTTP method POST
    @PostMapping(value = "/addresses")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        Address newAddress = this.addressService.create(address);

        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    // HTTP method GET
    @GetMapping(value = "/addresses")
    public ResponseEntity<List<Address>> read() {
        final List<Address> addresses = addressService.readAll();

        return addresses != null && !addresses.isEmpty()
                ? new ResponseEntity<>(addresses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // HTTP method GET with specific ID
    @GetMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> read(@PathVariable(name = "id") long id) {
        final Address address = addressService.read(id);

        return address != null
                ? new ResponseEntity<>(address, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // HTTP method PUT
    @PutMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> update(@PathVariable(name = "id") long id, @RequestBody Address address) {
        Address updatedAddress = this.addressService.update(id, address);

        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    // HTTP method DELETE
    @DeleteMapping(value = "/addresses/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        this.addressService.delete(id);

        return new ResponseEntity<>("Address with id: " + id + " was deleted successfully", HttpStatus.OK);
    }
}