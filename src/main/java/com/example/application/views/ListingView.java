package com.example.application.views;

import com.example.application.Application;
import com.example.application.data.Listing;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
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

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.FULL);
        div.setHeight("160px");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(l.getImageURL());
        image.setAlt(l.getTextString());

        div.add(image);

        Span header = new Span();
        //<theme-editor-local-classname>
        header.addClassName("home-view-card-span-1");
        header.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD);
        header.setText(l.getTitleString());

        Span subtitle = new Span();
        //<theme-editor-local-classname>
        subtitle.addClassName("home-view-card-span-2");
        subtitle.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        subtitle.setText(l.getPublisher().getFirstName() + " " + l.getPublisher().getLastName());

        Span dateTimeSpan = new Span();
        //<theme-editor-local-classname>
        dateTimeSpan.addClassName("home-view-card-span-4");
        //<theme-editor-local-classname>
        dateTimeSpan.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        dateTimeSpan.setText(l.getDate());

        Paragraph description = new Paragraph(l.getTextString());
        //<theme-editor-local-classname>
        description.addClassName("home-view-card-p-1");
        description.addClassName(Margin.Vertical.MEDIUM);

        Span badge = new Span();
        //<theme-editor-local-classname>
        badge.addClassName("home-view-card-span-3");
        badge.getElement().setAttribute("theme", "badge");

        badge.setText(l.getTag());

        add(div, header, subtitle, dateTimeSpan, description, badge);
    }
}