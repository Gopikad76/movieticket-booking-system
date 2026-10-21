package com.gopika.movieticketbookingsystem.controller;
import java.util.*;

import com.gopika.movieticketbookingsystem.model.Movie;
import com.gopika.movieticketbookingsystem.model.Theatre;
import com.gopika.movieticketbookingsystem.service.TheatreService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheatreController {
    private TheatreService theatreservice;
    public TheatreController(TheatreService theatreservice){
        this.theatreservice=theatreservice;
    }

    @GetMapping("/theatres")
    public List<Theatre> alltheatres(){
        return theatreservice.findtheatre();
    }
    @PostMapping("/theatres")
    public Theatre addTheatre(@RequestBody Theatre theatre){
        return theatreservice.addtheatre(theatre);
    }

    @GetMapping("/theatres/{id}")
    public Optional<Theatre> theatreById(@PathVariable int id) {
        return theatreservice.theatreById(id);
    }

    @DeleteMapping("/theatres/{id}")
    public void deleteTheatre(@PathVariable int id){
        theatreservice.deletetheatre(id);
    }

    @PutMapping("/theatres/{id}")
    public Theatre updateTheatre(@PathVariable int id,@RequestBody Theatre theatre){
        return theatreservice.updatetheatre(id,theatre);
    }
}
