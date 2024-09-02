package com.example.addressmanager.ui;

import com.example.addressmanager.model.Address;
import com.example.addressmanager.ui.uilogic.MainViewHandler;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./themes/my-theme/styles.css")
@Route("")
public class MainView extends VerticalLayout {

    // Creating variables and constants
    private final TextField streetAndNumber;
    private final TextField postcode;
    private final TextField city;
    private final TextField generatedId;
    private final Grid<Address> grid = new Grid<>();
    private static final String VALUEWIDTHTEXTFIELDS = "17.00%";
    private static final String VALUEWIDTHBUTTONS = "12.57%";

    // Constructor with dependency injection of MainViewHandler
    MainView(@Autowired MainViewHandler handler) {

        // Creating Heading and Subheading
        H1 pageTitle = new H1("Adressverwaltung");
        H2 subTitle = new H2("Erweiterte Operationen");

        // Creating and styling TextFields
        streetAndNumber = new TextField("Strasse und Hausnummer");
        streetAndNumber.setWidth(VALUEWIDTHTEXTFIELDS);
        postcode = new TextField("Postleitzahl");
        postcode.setWidth(VALUEWIDTHTEXTFIELDS);
        city = new TextField("Ort");
        city.setWidth(VALUEWIDTHTEXTFIELDS);
        generatedId = new TextField("ID (nur anzugeben bei erweiterten Operationen)");
        generatedId.setWidth(VALUEWIDTHTEXTFIELDS);

        // Creating and styling Buttons
        Button enterInput = new Button("Neue Adresse abschicken");
        enterInput.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        enterInput.setWidth(VALUEWIDTHBUTTONS);
        Button showAllAddresses = new Button("Alle Adressen anzeigen");
        showAllAddresses.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        showAllAddresses.setWidth(VALUEWIDTHBUTTONS);
        Button readSpecificAddress = new Button("Adresse anzeigen");
        readSpecificAddress.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        readSpecificAddress.setWidth(VALUEWIDTHBUTTONS);
        Button updateSpecificAddress = new Button("Adresse aktualisieren");
        updateSpecificAddress.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        updateSpecificAddress.setWidth(VALUEWIDTHBUTTONS);
        Button deleteAddress = new Button("Adresse löschen");
        deleteAddress.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteAddress.setWidth(VALUEWIDTHBUTTONS);

        // Click event for button enterInput
        enterInput.addClickListener(e -> {
           Address transmittedAddress = new Address(streetAndNumber.getValue(), postcode.getValue(), city.getValue());
           handler.create(transmittedAddress);
           grid.setItems(handler.readAll());
           streetAndNumber.clear();
           postcode.clear();
           city.clear();
           Notification.show("Neue Adresse zur Datenbank hinzugefügt");
        });

        // Click Event for Button showAllAddresses
        showAllAddresses.addClickListener(e -> {
           grid.setItems(handler.readAll());
        });

        // Click Event for Button readSpecificAddress
        readSpecificAddress.addClickListener(e -> {
            long convertedValue = Long.parseLong(generatedId.getValue());
            grid.setItems(handler.read(convertedValue));
            generatedId.clear();
        });

        // Click Event for Button updateSpecificAddress
        updateSpecificAddress.addClickListener(e -> {
            long convertedValue = Long.parseLong(generatedId.getValue());
            Address updatedAddress = new Address(streetAndNumber.getValue(), postcode.getValue(), city.getValue());
            handler.update(convertedValue, updatedAddress);
            grid.setItems(handler.readAll());
            generatedId.clear();
            streetAndNumber.clear();
            postcode.clear();
            city.clear();
            Notification.show("Adresse aktualisiert");
        });

        // Click Event for Button deleteAddress
        deleteAddress.addClickListener(e -> {
            long convertedValue = Long.parseLong(generatedId.getValue());
            handler.delete(convertedValue);
            grid.setItems(handler.readAll());
            generatedId.clear();
            Notification.show("Adresse aus Datenbank gelöscht");
        });

        // Displaying data in Vaadin Grid
        grid.addColumn(Address::getId).setHeader("ID");
        grid.addColumn(Address::getStreetAndNumber).setHeader("Strasse und Hausnummer");
        grid.addColumn(Address::getPostcode).setHeader("Postleitzahl");
        grid.addColumn(Address::getCity).setHeader("Ort");

        // Layout
        VerticalLayout layout = new VerticalLayout();
        layout.add(pageTitle);
        layout.add(generatedId);
        layout.add(streetAndNumber);
        layout.add(postcode);
        layout.add(city);
        layout.add(enterInput);
        layout.add(showAllAddresses);
        layout.add(subTitle);
        layout.add(readSpecificAddress);
        layout.add(updateSpecificAddress);
        layout.add(deleteAddress);
        layout.add(grid);
        add(layout);
    }
}
