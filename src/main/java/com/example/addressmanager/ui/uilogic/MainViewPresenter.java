package com.example.addressmanager.ui.uilogic;

import com.example.addressmanager.controller.AddressController;
import com.example.addressmanager.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MainViewPresenter implements MainViewHandler {

    // Creating variable of type AddressController
    final AddressController addressController;

    // Dependency injection of AddressController
    @Autowired
    public MainViewPresenter(AddressController addressController) {
        this.addressController = addressController;
    }

    // Implementation of method create()
    @Override
    public Address create(Address address) {
        return addressController.create(address).getBody();
    }

    // Implementation of method readAll()
    @Override
    public List<Address> readAll() {
        return addressController.read().getBody();
    }

    // Implementation of method read()
    @Override
    public Address read(long id) {
        return addressController.read(id).getBody();
    }

    // Implementation of method update()
    @Override
    public Address update(long id, Address address) {
        return addressController.update(id, address).getBody();
    }

    // Implementation of method delete()
    @Override
    public void delete(long id) {
        addressController.delete(id);
    }
}
