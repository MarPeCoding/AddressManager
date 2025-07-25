package com.example.addressmanager.ui.uilogic;
import com.example.addressmanager.client.AddressClient;
import com.example.addressmanager.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormViewPresenter implements FormViewHandler {

    // Creating variable of type AddressClient
    final AddressClient addressClient;

    // Constructor with dependency injection of AddressClient
    @Autowired
    public FormViewPresenter(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    // Implementation of method create()
    @Override
    public Address create(Address address) {
        return addressClient.create(address).getBody();
    }
}
