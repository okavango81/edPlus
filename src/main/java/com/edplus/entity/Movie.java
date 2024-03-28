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

    private String title;
    private String minutes;
    private String duration;
    private String releaseYear;
    private String classification;
    private String cardURL;
    private String mainURL;
    private String synopsis;

    public Movie(String title, String minutes, String releaseYear, String classification, String cardURL, String mainURL, String synopsis) {

        this.title = title;
        this.minutes = minutes;
        duration = fromMinutesToHoursAndMinutes(minutes);
        this.releaseYear = releaseYear;
        this.classification = classification;
        this.cardURL = cardURL;
        this.mainURL = mainURL;
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
