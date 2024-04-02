package com.edplus.repository;

import com.edplus.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where " +
            "lower(m.title) like concat('%', lower(:param), '%') or " +
            "lower(m.duration) like concat('%', lower(:param), '%') or " +
            "lower(m.releaseYear) like concat('%', lower(:param), '%') or " +
            "lower(m.classification) like concat('%', lower(:param), '%') or " +
            "lower(m.synopsis) like concat('%', lower(:param), '%') or " +
            "(exists (select d from Movie m2 join m2.director d where m2 = m and lower(d.name) like concat('%', lower(:param), '%')) or " +
            "exists (select s from Movie m3 join m3.starring s where m3 = m and lower(s.name) like concat('%', lower(:param), '%')) or " +
            "exists (select g from Movie m4 join m4.genres g where m4 = m and lower(g.name) like concat('%', lower(:param), '%')) or " +
            "exists (select c from Movie m5 join m5.characters c where m5 = m and lower(c.name) like concat('%', lower(:param), '%'))" +
            ")"//exists
    )//@Query
    List<Movie> findByAnyCriteria(String param);
}
