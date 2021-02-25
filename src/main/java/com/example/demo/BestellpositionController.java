package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/bestellpositionen")
public class BestellpositionController {

    private BestellpositionStorage bestellpositionen;

    @Autowired BestellpositionController(BestellpositionStorage bestellpositionStorage) {
        this.bestellpositionen = bestellpositionStorage;
    }

    @GetMapping
    public Collection<Bestellposition> getAllBestellpositionen() {
        Collection<Bestellposition> bestellpositionCollection = bestellpositionen.values();
        return bestellpositionCollection;
    }

    @GetMapping(path = "bestellungsNr/{value}")
    public ArrayList<Bestellposition> getBestellungFromBestellposition(@PathVariable Long value) {
        ArrayList<Bestellposition> b = new ArrayList<Bestellposition>();
        for (Long i = 0L; i < bestellpositionen.size(); i++) {
            if (bestellpositionen.get(i).bestellungsNr == value) {
                b.add(bestellpositionen.get(i));
            }
        }
        return b;
    }

    @GetMapping(path = "/{id}")
    public Bestellposition getBestellposition(@PathVariable Long id) {
        return bestellpositionen.get(id);
    }

    @PostMapping
    public Bestellposition postBestellposition(@RequestBody Bestellposition bestellposition) {
        bestellpositionen.put(bestellposition.bestellposNr, bestellposition);
        return bestellposition;
    }

    @PutMapping(path = "/{id}")
    public Bestellposition putBestellposition(@PathVariable Long id,
                       @RequestBody Bestellposition bestellposition) {
        Bestellposition best = bestellpositionen.get(id);
        if (best != null) {
            if (bestellposition.bestellposNr!=null)
                best.bestellposNr = bestellposition.bestellposNr;
            if (bestellposition.bestellungsNr!=null)
                best.bestellungsNr = bestellposition.bestellungsNr;
            if (bestellposition.artikelNr!=null)
                best.artikelNr = bestellposition.artikelNr;
            if (bestellposition.anzahl!=null)
                best.anzahl = bestellposition.anzahl;
            return bestellposition;
        } else {
            bestellpositionen.put(id, bestellposition);
            return bestellposition;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBestellposition(@PathVariable Long id) {
        bestellpositionen.remove(id);
    }
}
