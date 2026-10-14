package com.gopika.movieticketbookingsystem.repository;

import com.gopika.movieticketbookingsystem.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer>{


}
