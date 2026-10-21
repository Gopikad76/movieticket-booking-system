
package com.gopika.movieticketbookingsystem.controller;

import java.util.List;
import java.util.Optional;

import com.gopika.movieticketbookingsystem.model.Show;
import com.gopika.movieticketbookingsystem.service.ShowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    // Get all shows
    @GetMapping
    public List<Show> getShows() {
        return showService.getShows();
    }

    // Get show by ID
    @GetMapping("/{id}")
    public Optional<Show> getShowsById(@PathVariable int id) {
        return showService.getShowsById(id);
    }

    // Create show
    @PostMapping
    public Show addShows(@RequestBody Show show) {
        return showService.addShows(show);
    }

    // Update show
    @PutMapping("/{id}")
    public Show updateShows(
            @PathVariable int id,
            @RequestBody Show show) {
        return showService.updateShows(id, show);
    }

    // Delete show
    @DeleteMapping("/{id}")
    public String deleteShows(@PathVariable int id) {
        return showService.deleteShows(id);
    }
}
