package com.gopika.movieticketbookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String genre;
    private Integer minutes;

    // No-argument constructor
    public Movie() {
    }

    // Parameterized constructor
    public Movie(Integer id, String title, String genre,Integer minutes) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.minutes = minutes;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getMinutes() {
        return minutes;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}