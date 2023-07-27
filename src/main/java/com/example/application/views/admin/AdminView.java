package com.example.application.views.admin;

import com.example.application.Application;
import com.example.application.data.Listing;
import com.example.application.data.RandomLineSelector;
import com.example.application.views.ListingView;
import com.example.application.views.MainLayout;
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

@PageTitle("Admin")
@Route(value = "admin", layout = MainLayout.class)
public class AdminView extends Main implements HasComponents, HasStyle {

    private VerticalLayout imageContainer; // Change the type to VerticalLayout

    public AdminView() {
        constructUI();

        for (Listing l : Application.listingDataBase.values()) {
            if (l.getPending().equals(true)) {
                // adds home view card to homepage -Peter
                AdminViewCard temp = new AdminViewCard(l);
                // adds click listener to navigate to ListingView.java -Peter
                imageContainer.add(temp);
            }
        }
    }

    private void constructUI() {
        addClassNames("home-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Approve passions to let your workforce flourish!");
        //<theme-editor-local-classname>
        header.addClassName("home-view-h2-1");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);

        headerContainer.add(header);

        // Use VerticalLayout instead of OrderedList for imageContainer
        imageContainer = new VerticalLayout();
        imageContainer.addClassNames(Gap.MEDIUM, Margin.NONE, Padding.NONE);

        container.add(headerContainer);
        add(container, imageContainer);
    }
}
