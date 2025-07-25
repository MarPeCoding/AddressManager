package com.example.addressmanager.ui.uilogic;

import com.example.addressmanager.model.Address;
import java.util.List;

public interface RecordViewHandler {

    // Returns list of all existing addresses
    List<Address> readAll();
}
