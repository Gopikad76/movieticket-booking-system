
package com.gopika.movieticketbookingsystem.controller;

import com.gopika.movieticketbookingsystem.model.Screen;
import com.gopika.movieticketbookingsystem.service.ScreenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/screens")
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/screens/{id}")
    public Screen getScreenById(@PathVariable Integer id) {
        return screenService.getScreenById(id);
    }

    @PostMapping("/screens")
    public Screen addScreen(@RequestBody Screen screen) {
        return screenService.addScreen(screen);
    }

    @PutMapping("/screens/{id}")
    public Screen updateScreen(@PathVariable Integer id,
                               @RequestBody Screen screen) {
        return screenService.updateScreen(id, screen);
    }

    @DeleteMapping("/screens/{id}")
    public void deleteScreen(@PathVariable Integer id) {
        screenService.deleteScreen(id);
    }
}
