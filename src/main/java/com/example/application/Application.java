package com.example.application;

import com.example.application.data.Listing;
import com.example.application.data.User;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 * All this code runs at startup -Peter
 */
@SpringBootApplication
@Theme(value = "Ikigai", variant="dark")
public class Application implements AppShellConfigurator {

    //initilizes application databases -Peter
    public static HashMap<String,Listing> listingDataBase;
    public static HashMap<String,User> userDataBase;
    public static Boolean admin;
    public static User currentUser;

    public static void main(String[] args) {

        initilizeData();
        SpringApplication.run(Application.class, args);
        
    }

    //initilizes fake users and listings -Peter
    public static void initilizeData(){
        listingDataBase = new HashMap<>();
        userDataBase = new HashMap<>();

        userDataBase.put("peterbuckley", new User("Peter", "Buckley", "Denver", "pbuckley@spear-tech.com","java", 19,
        "https://media.licdn.com/dms/image/C4E03AQETfy1jK_Yvzg/profile-displayphoto-shrink_200_200/0/1663210146272?e=1695254400&v=beta&t=Cft1VpTfgJAyHaPXMTw-I7mYhRggcPu8iuOFA6dIqdQ"));

        userDataBase.put("dougdimmadome", new User("Doug", "Dimmadome", "Dimmsdale", "ddimmadome@spear-tech.com","hat", 47,
        "https://media-cdn.tripadvisor.com/media/photo-s/1a/57/a0/4f/world-s-tallest-top-hat.jpg"));

        userDataBase.put("seaneisenstein", new User("Sean", "Eisenstein", "Denver", "seisenstein@spear-tech.com","chatgpt", 21,
        "https://media.licdn.com/dms/image/D5603AQHWZLFhoXJ1wA/profile-displayphoto-shrink_200_200/0/1688748378444?e=1695254400&v=beta&t=_lR-v02VMSv4k63VTTRte2wXEVVrrKX61CsRD-mBAcE"));

        userDataBase.put("tyleradams", new User("Tyler", "Adams", "Denver", "tadams@hrsoft.com","wine", 22,
        "https://media.licdn.com/dms/image/D4E03AQGgcptQXQsaPg/profile-displayphoto-shrink_100_100/0/1677601329507?e=1695254400&v=beta&t=KVh0mybNPKX9tZLagbKPrKk8QNCAr3T33gJ5IfRoM4A"));

        userDataBase.put("cartercroke", new User("Carter", "Croke", "Denver", "ccroke@hrsoft.com","construction", 21,
        "https://media.licdn.com/dms/image/D5603AQEjfQ3VAIamhA/profile-displayphoto-shrink_100_100/0/1689273614114?e=1695254400&v=beta&t=hTO7ywLqQCOQ11ge_Ni31wIwo09Epm_DkDjUrjdZcVU"));

        userDataBase.put("jackyounger", new User("Jack", "Younger", "Denver", "jyounger@xylime.com","math", 19,
        "https://media.licdn.com/dms/image/C4E03AQG2uGMy4J0YaA/profile-displayphoto-shrink_100_100/0/1652806060688?e=1695254400&v=beta&t=2VY3b5n6uPbmr98Z8z0-1EuoT5GoJdViuDuhYIj_14Q"));

        userDataBase.put("jameszieper", new User("James", "Zieper", "Denver", "jzieper@xylime.com","nw", 19,
        "https://media.licdn.com/dms/image/D5603AQEjfQ3VAIamhA/profile-displayphoto-shrink_100_100/0/1689273614114?e=1695254400&v=beta&t=hTO7ywLqQCOQ11ge_Ni31wIwo09Epm_DkDjUrjdZcVU"));



        listingDataBase.put("tallhatclass", new Listing(userDataBase.get("dougdimmadome"), "tallhatclass", "8/22/2023 2:00am", 0, "Tall Hat Class",
         "Have you ever wanted to be cool? Well now you can by properly learning how to wear a tall hat!", "Style", false,
         "https://bloximages.chicago2.vip.townnews.com/trib.com/content/tncms/assets/v3/editorial/2/f3/2f3df6dc-ede3-513d-85a0-29a3870896a0/5e5d93b36ac1f.preview.jpg?crop=732%2C384%2C0%2C508&resize=732%2C384&order=crop%2Cresize"
         ));
        
        listingDataBase.put("flytyingclass", new Listing(userDataBase.get("peterbuckley"), "flytyingclass", "8/15/2023 3:00pm", 0, "Fly Tying Class", 
        "Learn about basic fly tying materials/processes and tie your very own frenchie nymph! ", "Outdoors", false,
        "data:image/jpeg;base64,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"
         ));

        listingDataBase.put("skiboardwaxingclass", new Listing(userDataBase.get("seaneisenstein"), "skiboardwaxingclass", "8/19/2023 4:30pm", 0, "Ski / Board Waxing Class", 
        "In this course we will explore the simple process of waxing your own skis or snowboard.", "Outdoors", false,
        "https://static.evo.com/content/cms/guides/ski/ski%20wax.jpg"
         ));

        listingDataBase.put("winepairingclass", new Listing(userDataBase.get("tyleradams"), "winepairingclass", "8/20/2023 2:30pm", 0, "Wine Pairing Class", 
        "In this course we will learn how to bring out the complexities of flavor in wine through food.", "Food", false,
        "https://www.winetourism.com/files/2022/10/food_and_wine_pairing_2_-1170x334.webp?1670937402"
         ));

        listingDataBase.put("musicmixingclass", new Listing(userDataBase.get("cartercroke"), "musicmixingclass", "8/17/2023 4:00pm", 0, "Music Mixing Class", 
        "Learn the tools and software necessary to become a DJ. Additionally, we will cover beat matching and basic techniques of mixing.", "Music", false,
        "https://scontent-lax3-1.xx.fbcdn.net/v/t39.30808-6/305462028_5460197377359576_5527409720522594724_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=a26aad&_nc_ohc=9gR5_1BmrgEAX9og9Vn&_nc_ht=scontent-lax3-1.xx&oh=00_AfBUyyJjT76YG23rSNW7ttgXlrLPNVDmVW5rxCyDBL5yxw&oe=64BB60EC"
         ));

        listingDataBase.put("pianobasics", new Listing(userDataBase.get("jackyounger"), "pianobasics", "8/30/2023 2:00pm", 0, "Piano Basics", 
        "We tackle the basics of the keyboard, some of the theory behind your favorite songs' melodies, major and minor keys and chords, and at the conclusion you will know how to play viva la vida by Coldplay.", "Music", false,
        "https://www.musicnotes.com/images2/promos/store/900x520_piano-min.jpg"
         ));

        listingDataBase.put("chessstrategy", new Listing(userDataBase.get("jameszieper"), "chessstrategy", "8/25/2023 3:00pm", 0, "Chess Strategy", 
        "In this course, we will teach you how to not only understand the board, but also your opponent.", "Music", false,
        "https://assetsio.reedpopcdn.com/chess-playing-hand.jpeg?width=848&quality=80&format=jpg&auto=webp"
         ));

        currentUser = userDataBase.get("peterbuckley");
        admin = true;

    }
}
