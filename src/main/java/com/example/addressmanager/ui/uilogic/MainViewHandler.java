package com.example.addressmanager.ui.uilogic;

import com.example.addressmanager.model.Address;
import java.util.List;

public interface MainViewHandler {

    // Creates new Address
    Address create(Address address);

    // Returns list of all existing addresses
    List<Address> readAll();

    // Returns address based on its ID
    Address read(long id);

    // Updates address with given ID, according to the passed address
    Address update(long id, Address address);

    // Deletes address with given ID
    void delete(long id);
}