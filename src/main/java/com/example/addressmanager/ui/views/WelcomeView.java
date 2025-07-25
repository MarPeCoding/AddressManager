package com.example.addressmanager.ui.views;

import com.example.addressmanager.ui.MainLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./themes/my-theme/styles.css")
@PageTitle("Welcome | Address Manager")
@Route(value = "", layout = MainLayout.class)
public class WelcomeView extends VerticalLayout {

    public WelcomeView() {

        addClassName("welcome-view");
        setDefaultHorizontalComponentAlignment(Alignment.START);

        H2 greeting = new H2("Willkommen!");

        add(greeting);
    }
}