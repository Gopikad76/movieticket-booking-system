package com.gopika.movieticketbookingsystem.service;
import com.gopika.movieticketbookingsystem.model.Movie;
import com.gopika.movieticketbookingsystem.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class MovieService {
    private final MovieRepository movierepo ;
    public MovieService(MovieRepository movierepo){
        this.movierepo=movierepo;
    }
    public List<Movie> getMovies() {

        return movierepo.findAll();
    }

    public Optional<Movie> getMoviesById(int n){
        return movierepo.findById(n);
    }

    public Movie addmovies(Movie movie){
        return movierepo.save(movie);
    }
}
