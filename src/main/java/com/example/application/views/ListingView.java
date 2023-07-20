package com.example.application.views;

import com.example.application.data.Listing;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("ListingView")
@Route("ListingView")
public class ListingView extends VerticalLayout implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        // This method will be called when you navigate to this view and pass a parameter.
        // The parameter will be the ID of the card that was clicked.
        // You can use this ID to customize the view.
    }
}
