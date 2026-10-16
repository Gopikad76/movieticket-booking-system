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
    public Movie updatemovies(int id,Movie movie){
        Movie existingMovie = movierepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setMinutes(movie.getMinutes());
        return movierepo.save(existingMovie);
    }
    public List<Movie> deletemovies(int id){
        movierepo.deleteById(id);
        return movierepo.findAll();
    }
    public Movie addmovies(Movie movie){
        return movierepo.save(movie);
    }
}
