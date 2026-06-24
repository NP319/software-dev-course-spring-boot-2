package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("Thriller", "Michael Jackson", 1982, 9));
        add(new Album("1989", "Taylor Swift", 2014, 13));
        add(new Album("Abbey Road", "The Beatles", 1969, 17));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml() {

        String albumList = "<ul>";

        for (Album album : albums) {
            albumList += "<li>" + album + "</li>";
        }

        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                </html>
                """;
    }
}