package com.edplus.entity.dto;

import com.edplus.entity.Movie;
import lombok.Getter;

@Getter
public class MovieCardDTO {

    private Long id;
    private String title;
    private String duration;
    private String releaseYear;
    private String classification;
    private String cardURL;

    public MovieCardDTO(Movie movie){
        id = movie.getId();
        title = movie.getTitle();
        duration = movie.getDuration();
        releaseYear = movie.getReleaseYear();
        classification = movie.getClassification();
        cardURL = movie.getCardURL();
    }

}
