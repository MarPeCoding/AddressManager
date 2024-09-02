package com.example.addressmanager.repository;

import com.example.addressmanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Defining interface as repository (Spring Data repository abstraction)
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
