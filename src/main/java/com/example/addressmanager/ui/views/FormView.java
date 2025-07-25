package com.example.addressmanager.ui.views;

import com.example.addressmanager.model.Address;
import com.example.addressmanager.ui.MainLayout;
import com.example.addressmanager.ui.uilogic.FormViewHandler;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./themes/my-theme/styles.css")
@PageTitle("Form | Address Manager")
@Route(value = "form", layout = MainLayout.class)
public class FormView extends FormLayout {

    // Variables
    FormLayout form = new FormLayout();
    TextField streetAndNumber = new TextField();
    TextField postcode = new TextField();
    TextField city = new TextField();
    Button saveNewAddress = new Button("Addresse speichern");

    // Constructor with dependency injection of FormViewHandler
    public FormView(@Autowired FormViewHandler handler) {

        // Setting placeholders for input fields
        streetAndNumber.setPlaceholder("Strasse und Hausnummer");
        postcode.setPlaceholder("Postleitzahl");
        city.setPlaceholder("Ort");

        // Click event for button saveNewAddress
        saveNewAddress.addClickListener(e -> {
            Address transmittedAddress = new Address(streetAndNumber.getValue(), postcode.getValue(), city.getValue());
            handler.create(transmittedAddress);
            streetAndNumber.clear();
            postcode.clear();
            city.clear();
            Notification.show("Neue Adresse hinzugefügt");
        });

        // Layout
        form.add(streetAndNumber, postcode, city);
        form.setColspan(streetAndNumber, 2);
        form.setColspan(postcode, 2);
        form.setColspan(city, 2);
        VerticalLayout layout = new VerticalLayout();
        layout.add(form, saveNewAddress);
        add(layout);
    }
}
