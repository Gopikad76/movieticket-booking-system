package com.gopika.movieticketbookingsystem.model;
import com.gopika.movieticketbookingsystem.model.Theatre;
import jakarta.persistence.*;

@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer seats;
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    public Screen(Integer id,String name,Integer seats,Theatre theatre){
        this.id=id;
        this.name=name;
        this.seats=seats;
        this.theatre=theatre;
    }

    public Screen(){}

    public Integer getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public Integer getSeats(){
        return seats;
    }
    public Theatre getTheatre(){ return theatre;}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSeats(Integer seats){ this.seats=seats;}
    public void setTheatre(Theatre theatre){ this.theatre=theatre;}
}
