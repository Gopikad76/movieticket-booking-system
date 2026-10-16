package com.gopika.movieticketbookingsystem.service;
import com.gopika.movieticketbookingsystem.model.Movie;
import com.gopika.movieticketbookingsystem.repository.TheatreRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import com.gopika.movieticketbookingsystem.model.Theatre;

@Service
public class TheatreService {
    private TheatreRepository theatrerepo;
    public TheatreService(TheatreRepository theatrerepo){
        this.theatrerepo=theatrerepo;
    }

    public List<Theatre> findtheatre(){
        return theatrerepo.findAll();
    }
    public Theatre addtheatre(Theatre theatre){
        return theatrerepo.save(theatre);
    }
    public Optional<Theatre> theatreById(int n){
        return theatrerepo.findById(n);
    }

}
