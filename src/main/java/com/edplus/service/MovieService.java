package com.edplus.service;

import com.edplus.entity.Movie;
import com.edplus.entity.dto.MovieCardDTO;
import com.edplus.entity.dto.MovieRegisterDTO;
import com.edplus.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public ResponseEntity<MovieCardDTO> register(MovieRegisterDTO movieRegisterDTO) {

        Movie movie = new Movie(movieRegisterDTO.getTitle(), movieRegisterDTO.getMinutes(),
                movieRegisterDTO.getReleaseYear(), movieRegisterDTO.getClassification(),
                movieRegisterDTO.getCardURL(), movieRegisterDTO.getMainURL(), movieRegisterDTO.getSynopsis());

        movieRepository.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(new MovieCardDTO(movie));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<MovieCardDTO> queryId(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        return ResponseEntity.ok().body( new MovieCardDTO(movie.get()));
    }
}
