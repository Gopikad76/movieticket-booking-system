
package com.gopika.movieticketbookingsystem.service;

import com.gopika.movieticketbookingsystem.model.Screen;
import com.gopika.movieticketbookingsystem.model.Theatre;
import com.gopika.movieticketbookingsystem.repository.ScreenRepository;
import com.gopika.movieticketbookingsystem.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    public ScreenService(ScreenRepository screenRepository,
                         TheatreRepository theatreRepository) {
        this.screenRepository = screenRepository;
        this.theatreRepository = theatreRepository;
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen getScreenById(Integer id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen not found: " + id));
    }

    public Screen addScreen(Screen screen) {
        Integer theatreId = screen.getTheatre().getId();

        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found: " + theatreId));

        screen.setId(null);
        screen.setTheatre(theatre);

        return screenRepository.save(screen);
    }

    public Screen updateScreen(Integer id, Screen updatedScreen) {
        Screen existingScreen = getScreenById(id);

        existingScreen.setName(updatedScreen.getName());
        existingScreen.setSeats(updatedScreen.getSeats());

        if (updatedScreen.getTheatre() != null
                && updatedScreen.getTheatre().getId() != null) {

            Integer theatreId = updatedScreen.getTheatre().getId();

            Theatre theatre = theatreRepository.findById(theatreId)
                    .orElseThrow(() -> new RuntimeException(
                            "Theatre not found: " + theatreId));

            existingScreen.setTheatre(theatre);
        }

        return screenRepository.save(existingScreen);
    }

    public void deleteScreen(Integer id) {
        Screen screen = getScreenById(id);
        screenRepository.delete(screen);
    }
}
