package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bestellposition")
public class BestellpositionController {

    private BestellpositionStorage bestellpositionen;

    @Autowired BestellpositionController(BestellpositionStorage bestellungpositionStorage) {
        this.bestellpositionen = bestellungpositionStorage;
    }
    @GetMapping
    public Bestellposition get() {
        return bestellpositionen.get(0L);
    }
}
