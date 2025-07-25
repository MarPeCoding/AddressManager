package com.example.addressmanager.ui.views;

import com.example.addressmanager.model.Address;
import com.example.addressmanager.ui.MainLayout;
import com.example.addressmanager.ui.uilogic.RecordViewHandler;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport("./themes/my-theme/styles.css")
@PageTitle("Records | Address Manager")
@Route(value = "records", layout = MainLayout.class)
public class RecordView extends VerticalLayout {

    // Variables and constants
    Button showAllAddresses = new Button("Alle Adressen anzeigen");
    private final Grid<Address> grid = new Grid<>();
    VerticalLayout layout = new VerticalLayout();

    // Constructor with dependency injection of RecordViewHandler
    public RecordView(@Autowired RecordViewHandler handler) {

        addClassName("record-view");
        setDefaultHorizontalComponentAlignment(Alignment.START);

        // Setting Vaadin Grid for displaying data
        grid.addColumn(Address::getStreetAndNumber).setHeader("Strasse und Hausnummer");
        grid.addColumn(Address::getPostcode).setHeader("Postleitzahl");
        grid.addColumn(Address::getCity).setHeader("Ort");

        // Click Event for Button showAllAddresses
        showAllAddresses.addClickListener(e -> {
            grid.setItems(handler.readAll());
        });

        // Layout
        layout.add(showAllAddresses, grid);
        add(layout);
    }
}
