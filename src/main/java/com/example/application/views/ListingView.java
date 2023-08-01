package com.example.application.views;

import com.example.application.Application;
import com.example.application.data.Listing;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

@PageTitle("Listing")
@Route(value = "ListingView", layout = MainLayout.class)
public class ListingView extends Main implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event, String parameter) {

        Listing l = Application.listingDataBase.get(parameter);
        //String titleString, String subtitleString, String textString, String imageURL, String tag
        addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                BorderRadius.LARGE);

//------------------------------------------------------------------------------------------------------------------//
        HorizontalLayout mainLayout = new HorizontalLayout();

    //--------------------------------------------------------------------------------------------------------------//
        VerticalLayout left = new VerticalLayout();

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.FULL);
        div.setHeight("100%");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(l.getImageURL());
        image.setAlt(l.getTextString());

        div.add(image);

        left.add(div);

        Span descriptionTitle = new Span();
        //<theme-editor-local-classname>
        descriptionTitle.addClassName("Listing-span-4");
        descriptionTitle.addClassNames(FontSize.XXXLARGE, FontWeight.BOLD);
        descriptionTitle.setText("Description:");

        Paragraph description = new Paragraph(l.getTextString());
        //<theme-editor-local-classname>
        description.addClassName("Listing-para-1");
        description.addClassName(Margin.Vertical.MEDIUM);

        left.add(descriptionTitle, description);


        mainLayout.add(left);
    //--------------------------------------------------------------------------------------------------------------//
        VerticalLayout right = new VerticalLayout();
        right.setPadding(false); // Disable default spacing
        right.setSpacing(true); // Enable custom spacing between components

        Span header = new Span();
        //<theme-editor-local-classname>
        header.addClassName("Listing-span-2");
        header.addClassNames(FontSize.XXXLARGE, FontWeight.BOLD);
        header.setText(l.getTitleString());

        right.add(header);

        Span subtitle = new Span();
        //<theme-editor-local-classname>
        subtitle.addClassName("Listing-span-1");
        subtitle.addClassNames(FontSize.XLARGE, TextColor.SECONDARY);
        subtitle.setText("Hosted By: " + l.getPublisher().getFirstName() + " " + l.getPublisher().getLastName());

        right.add(subtitle);

        Span dateTimeSpan = new Span();
        //<theme-editor-local-classname>
        dateTimeSpan.addClassName("Listing-span-3");
        //<theme-editor-local-classname>
        dateTimeSpan.addClassNames(FontSize.XXLARGE, TextColor.SECONDARY);
        dateTimeSpan.setText(l.getDateVerbal());

        right.add(dateTimeSpan);

        if(Application.currentUser.getAcceptedListings().contains(l)){

        Button accepted = new Button("Accepted");
        //<theme-editor-local-classname>
        accepted.addClassName("listing-view-button-1");
        accepted.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        accepted.setWidth("300px");
        accepted.setHeight("50px");

        right.add(accepted);

        }
        else{
        Button rsvp = new Button("RSVP");
        rsvp.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        rsvp.setWidth("300px");
        rsvp.setHeight("50px");

        rsvp.addClickListener(e -> {
            // Approves and Pushes listing
            Application.currentUser.acceptListing(l);

            // Refresh the page
            getUI().ifPresent(ui -> ui.getPage().reload());
        });

        right.add(rsvp);
        }

        mainLayout.add(right);

    //---------------------------------------------------------------------------------------------------------//

        Span badge = new Span();
        //<theme-editor-local-classname>
        badge.addClassName("home-view-card-span-3");
        badge.getElement().setAttribute("theme", "badge");

        badge.setText(l.getTag());

        add(mainLayout);
    }
}
