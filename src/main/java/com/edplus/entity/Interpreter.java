package com.edplus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Interpreter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "must have not be null")
    @Size(min = 4, message = "must have at least {min} characters")
    private String name;

    @ManyToMany(mappedBy = "starring")
    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();

    @OneToMany(mappedBy = "interpreter")
    @JsonIgnore
    private List<Character> characters = new ArrayList<>();

    public Interpreter(String name){
        this.name = name.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interpreter that = (Interpreter) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
