package com.example.application.views;

import com.example.application.Application;
import com.example.application.data.Listing;
import com.example.application.data.RandomLineSelector;
import com.example.application.views.ListingView;
import com.example.application.views.MainLayout;
import com.example.application.views.home.HomeViewCard;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("My Listings")
@Route(value = "mylistings", layout = MainLayout.class)
public class MyListingsView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    public MyListingsView() {
        constructUI();



        for (Listing l : Application.currentUser.getUserListings()){

            //adds home view card to homepage -Peter
            HomeViewCard temp = new HomeViewCard(l);
            //hashkey to be passed -Peter
            String clickedListing = l.getKey();
            //adds click listener to navigate to ListingView.java -Peter
            temp.addClickListener(event -> UI.getCurrent().navigate(ListingView.class, clickedListing));
            imageContainer.add(temp);

        }
    }

    private void constructUI() {
        addClassNames("home-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Manage Your Shared Passions and Inspirations!");
        //<theme-editor-local-classname>
        header.addClassName("home-view-h2-1");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
        Paragraph description = new Paragraph(RandomLineSelector.selectRandomLineFromFile("src/main/resources/MotivationalQoutes.txt"));
        //<theme-editor-local-classname>
        description.addClassName("home-view-p-1");
        description.addClassNames(Margin.Bottom.XLARGE, Margin.Top.NONE, TextColor.SECONDARY);
        headerContainer.add(header, description);

        Select<String> sortBy = new Select<>();
        //<theme-editor-local-classname>
        sortBy.setOverlayClassName("home-view-select-1");
        //<theme-editor-local-classname>
        sortBy.addClassName("home-view-select-1");
        sortBy.setLabel("Sort by");
        sortBy.setItems("Popularity", "Newest first", "Oldest first");
        sortBy.setValue("Popularity");

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        container.add(headerContainer, sortBy);
        add(container, imageContainer);

    }
}
