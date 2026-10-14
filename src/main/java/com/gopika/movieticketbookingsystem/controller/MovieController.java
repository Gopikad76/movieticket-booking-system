package com.gopika.movieticketbookingsystem.controller;
import com.gopika.movieticketbookingsystem.service.MovieService;
import com.gopika.movieticketbookingsystem.model.Movie;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovieById(@PathVariable int id) {
        return movieService.getMoviesById(id);
    }
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        System.out.println("POST API REACHED");
        System.out.println(movie.getTitle());
        return movieService.addmovies(movie);
    }
}
