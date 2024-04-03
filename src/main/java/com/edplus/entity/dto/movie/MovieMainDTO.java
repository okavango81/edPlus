package com.edplus.entity.dto.movie;

import com.edplus.entity.Character;
import com.edplus.entity.Director;
import com.edplus.entity.Genre;
import com.edplus.entity.Interpreter;
import com.edplus.entity.Movie;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MovieMainDTO {

    private Long id;
    private String title;
    private String duration;
    private String releaseYear;
    private String classification;
    private String mainURL;
    private String synopsis;
    private Director director;
    private List<Interpreter> starring = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();

    public MovieMainDTO(Movie movie){
        id = movie.getId();
        title = movie.getTitle();
        duration = movie.getDuration();
        releaseYear = movie.getReleaseYear();
        classification = movie.getClassification();
        mainURL = movie.getMainURL();
        synopsis = movie.getSynopsis();
        director = movie.getDirector();
        starring = movie.getStarring();
        genres = movie.getGenres();
        characters = movie.getCharacters();
    }

}
