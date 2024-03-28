package com.edplus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, length = 3)
    private String minutes;

    @Column(length = 7)
    private String duration;

    @Column(nullable = false, length = 4)
    private String releaseYear;

    @Column(nullable = false, length = 2)
    private String classification;

    private String cardURL;
    private String mainURL;

    @Column(nullable = false, columnDefinition = "text")
    private String synopsis;

    //construtor
    public Movie(String title, String minutes, String releaseYear, String classification, String cardURL, String mainURL, String synopsis) {

        this.title = title.toUpperCase();
        this.minutes = minutes;
        duration = fromMinutesToHoursAndMinutes(minutes);
        this.releaseYear = releaseYear;
        this.classification = classification.toUpperCase();
        this.cardURL = cardURL.toLowerCase();
        this.mainURL = mainURL.toLowerCase();
        this.synopsis = synopsis;
    }


    public String fromMinutesToHoursAndMinutes(String m) {
        try {
            Integer min = Integer.parseInt(String.valueOf(m));
            Integer hours = min / 60;
            Integer minutes = min % 60;

            return String.format("%sh %sm", hours, minutes);

        } catch (NumberFormatException e) {
            return null;
        }
    }


    //    equals and hshcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
