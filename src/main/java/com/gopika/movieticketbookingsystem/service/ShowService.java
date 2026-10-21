
package com.gopika.movieticketbookingsystem.service;

import java.util.List;
import java.util.Optional;

import com.gopika.movieticketbookingsystem.model.Show;
import com.gopika.movieticketbookingsystem.repository.ShowRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    private final ShowRepository showrep;

    public ShowService(ShowRepository showrep) {
        this.showrep = showrep;
    }

    // Get all shows
    public List<Show> getShows() {
        return showrep.findAll();
    }

    // Get show by ID
    public Optional<Show> getShowsById(int id) {
        return showrep.findById(id);
    }

    // Add show
    public Show addShows(Show show) {
        return showrep.save(show);
    }

    // Update show
    public Show updateShows(int id, Show show) {
        Show existingShow = showrep.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Show not found"));

        existingShow.setMovie(show.getMovie());
        existingShow.setScreen(show.getScreen());
        existingShow.setDatetime(show.getDatetime());
        existingShow.setPrice(show.getPrice());

        return showrep.save(existingShow);
    }

    // Delete show
    public String deleteShows(int id) {
        Show show = showrep.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Show not found"));

        showrep.delete(show);

        return "Show deleted successfully";
    }
}
