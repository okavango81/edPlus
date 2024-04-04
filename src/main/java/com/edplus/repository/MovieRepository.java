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
            "exists (select d from Movie m2 join m2.director d where m2 = m and lower(d.name) like concat('%', lower(:param), '%')) or " +
            "exists (select i from Movie m3 join m3.interpreters i where m3 = m and lower(i.name) like concat('%', lower(:param), '%')) or " +
            "exists (select g from Movie m4 join m4.genres g where m4 = m and lower(g.name) like concat('%', lower(:param), '%')) or " +
            "exists (select p from Movie m5 join m5.papers p where m5 = m and lower(p.name) like concat('%', lower(:param), '%'))"
    )//@Query

    List<Movie> findByAnyCriteria(String param);
}
