package com.edplus.service;

import com.edplus.entity.Movie;
import com.edplus.entity.dto.movie.MovieCardDTO;
import com.edplus.entity.dto.movie.MovieMainDTO;
import com.edplus.entity.dto.movie.MovieRegisterDTO;
import com.edplus.entity.dto.movie.MovieUpdateURLDTO;
import com.edplus.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<MovieCardDTO>> allMovies(){
        return ResponseEntity.ok().body(movieRepository.findAll().stream().map(MovieCardDTO::new).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<MovieMainDTO> queryId(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        return ResponseEntity.ok().body( new MovieMainDTO(movie.get()));
    }

    @Transactional
    public ResponseEntity<MovieCardDTO> updateURL(MovieUpdateURLDTO movie, Long id){
        Optional<Movie> m = movieRepository.findById(id);
        m.get().setCardURL(movie.getCardURL());
        m.get().setMainURL(movie.getMainURL());

        return ResponseEntity.ok().body(new MovieCardDTO(m.get()));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<MovieCardDTO>> search(String param){
        return ResponseEntity.ok().body(movieRepository.findByAnyCriteria(param).stream().map(MovieCardDTO::new).collect(Collectors.toList()));
    }
}
