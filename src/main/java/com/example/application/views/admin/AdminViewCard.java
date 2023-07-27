package com.example.application.views.admin;

import com.example.application.data.Listing;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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

//This class makes home viewcard object for listings --peter

public class AdminViewCard extends ListItem {

    public AdminViewCard(Listing l) {

        //String titleString, String subtitleString, String textString, String imageURL, String tag
        addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                BorderRadius.LARGE);
        setWidth("900px");

        //------------------------------------------------------------------------------------//

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.FULL);
        div.setHeight("160px");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(l.getImageURL());
        image.setAlt(l.getTextString());

        div.add(image);

        //-----------------------------------------------------------------------------------//

        HorizontalLayout adminLayout = new HorizontalLayout();

        //-----------------------------------------------------------------------------------//

        VerticalLayout postInfo = new VerticalLayout();

        Span header = new Span();
        //<theme-editor-local-classname>
        header.addClassName("home-view-card-span-1");
        header.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD);
        header.setText(l.getTitleString());

        HorizontalLayout profile = new HorizontalLayout();
        profile.addClassName("home-view-card-horizontal-layout-1");

        Span subtitle = new Span();
        //<theme-editor-local-classname>
        subtitle.addClassName("home-view-card-span-2");
        subtitle.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        subtitle.setText(l.getPublisher().getFirstName() + " " + l.getPublisher().getLastName());

        Image profilePic = new Image();
        profilePic.setSrc(l.getPublisher().getProfilePicUrl());
        profilePic.setAlt("profilepic");
        profilePic.setWidth("30px"); // Set the desired width
        profilePic.setHeight("30px");
        profilePic.getStyle().set("border-radius", "50%");
        profilePic.getStyle().set("overflow", "hidden");
        profile.add(subtitle, profilePic);

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

        postInfo.add(header, profile, dateTimeSpan, description, badge);

        //----------------------------------------------------------------------------------------------------------//

        VerticalLayout materials = new VerticalLayout();

        Span materialsTitle = new Span();
        //<theme-editor-local-classname>
        materialsTitle.addClassName("home-view-card-span-1");
        materialsTitle.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD, Margin.Vertical.SMALL);
        materialsTitle.setText("Materials Requested");

        materials.add(materialsTitle);

        for (String item : l.getMaterialsList()) {
            Span bulletPoint = new Span("\u2022 " + item); // Using Unicode bullet point character (U+2022).
            //<theme-editor-local-classname>
            bulletPoint.addClassName("admin-view-card-span-1");
            materials.add(bulletPoint);
        }

        Span materialsCost = new Span();
        //<theme-editor-local-classname>
        materialsCost.addClassName("home-view-card-span-1");
        materialsCost.addClassNames(FontSize.MEDIUM, FontWeight.SEMIBOLD);
        materialsCost.setText("Cost: $" + l.getMaterialsCost());

        materials.add(materialsCost);

        //----------------------------------------------------------------------------------------------------------//

        VerticalLayout approveDeny = new VerticalLayout();

        Button approveButton = new Button("Approve");
        approveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        approveButton.setWidth("200px");
        approveButton.setHeight("50px");

        approveButton.addClickListener(e -> {
            // Approves and Pushes listing
            l.Approve();
            l.push();

            // Refresh the page
            getUI().ifPresent(ui -> ui.getPage().reload());
        });

        Button denyButton = new Button("Deny");
        denyButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        denyButton.setWidth("200px");
        denyButton.setHeight("50px");

        denyButton.addClickListener(e -> {
            // Denys listing
            l.Deny();
            l.push();

            // Refresh the page
            getUI().ifPresent(ui -> ui.getPage().reload());
        });



        approveDeny.add(approveButton, denyButton);

//----------------------------------------------------------------------------------------------------------//

        adminLayout.add(postInfo, materials, approveDeny);

//---------------------------------------------------------------------------------------------------------//

        add(div,adminLayout);
    }
}
