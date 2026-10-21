package com.gopika.movieticketbookingsystem.service;

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
    public void deletetheatre(int id){
        theatrerepo.deleteById(id);
    }

    public Theatre updatetheatre(int id,Theatre theatre){
        Theatre exist=theatrerepo.findById(id).orElseThrow(() -> new RuntimeException("theatre not found"));
        exist.setName(theatre.getName());
        exist.setLocation(theatre.getLocation());
        return theatrerepo.save(exist);
    }
}
