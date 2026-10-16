package com.gopika.movieticketbookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;

    public Theatre(Integer id,String name,String location){
        this.id=id;
        this.name=name;
        this.location=location;
    }
    public Theatre() {
    }

    public String getName(){
        return name;
    }
    public String getLoc(){
        return location;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
