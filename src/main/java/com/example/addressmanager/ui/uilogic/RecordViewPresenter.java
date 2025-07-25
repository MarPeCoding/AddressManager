package com.example.addressmanager.ui.uilogic;

import com.example.addressmanager.client.AddressClient;
import com.example.addressmanager.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RecordViewPresenter implements RecordViewHandler {

    // Creating variable of type AddressClient
    final AddressClient addressClient;

    // Constructor with dependency injection of AddressClient
    @Autowired
    public RecordViewPresenter(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    // Implementation of method readAll()
    @Override
    public List<Address> readAll() {
        return addressClient.read().getBody();
    }
}
