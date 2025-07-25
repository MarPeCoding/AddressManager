package com.example.addressmanager.service;

import com.example.addressmanager.exception.NoAddressFoundException;
import com.example.addressmanager.model.Address;
import com.example.addressmanager.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

// Defining as service class
@Service
public class AddressServiceImpl implements AddressService {

    // Creating variable of type AddressRepository
    private final AddressRepository addressRepository;

    // Constructor with dependency injection of AddressRepository
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Implementation of method create()
    @Override
    public Address create(Address address) {
        return this.addressRepository.save(address);
    }

    // Implementation of method readAll()
    @Override
    public List<Address> readAll() {
        return this.addressRepository.findAll();
    }

    // Implementation of method read()
    @Override
    public Address read(long id) {
        Optional<Address> addressId = this.addressRepository.findById(id);

        if (addressId.isEmpty()) {
            throw new NoAddressFoundException("No address found with id " + id);
        }
        return addressId.get();
    }

    // Implementation of method update()
    @Override
    public Address update(long id, Address address) {
        Optional<Address> addressId = this.addressRepository.findById(id);

        if (addressId.isEmpty()) {
            throw new NoAddressFoundException("No adress found with id " + id);
        }
        else {
            addressId.get().setStreetAndNumber(address.getStreetAndNumber());
            addressId.get().setPostcode(address.getPostcode());
            addressId.get().setCity(address.getCity());
        }

        return this.addressRepository.save(addressId.get());
    }

    // Implementation of method delete()
    @Override
    public void delete(long id) {
        Optional<Address> addressId = this.addressRepository.findById(id);

        if (addressId.isEmpty()) {
            throw new NoAddressFoundException("No address found with id " + id);
        }
        else {
            addressRepository.deleteById(id);
        }
    }
}