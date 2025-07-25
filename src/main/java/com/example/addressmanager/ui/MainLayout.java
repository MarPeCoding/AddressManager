package com.example.addressmanager.ui;

import com.example.addressmanager.ui.views.FormView;
import com.example.addressmanager.ui.views.RecordView;
import com.example.addressmanager.ui.views.WelcomeView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./themes/my-theme/styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Address Manager");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink welcomeLink = new RouterLink("Willkommen", WelcomeView.class);
        RouterLink recordLink = new RouterLink("Adressen anzeigen", RecordView.class);
        RouterLink entryLink = new RouterLink("Neuer Eintrag", FormView.class);
        recordLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                welcomeLink,
                recordLink,
                entryLink
        ));
    }
}
