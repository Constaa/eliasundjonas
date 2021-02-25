package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/bestellungen")
public class BestellungController {

    private BestellungStorage bestellungen;

    @Autowired BestellungController(BestellungStorage bestellungStorage) {
        this.bestellungen = bestellungStorage;
    }

    @GetMapping
    public Collection<Bestellung> get() {
        Collection<Bestellung> bestellungCollection = bestellungen.values();
        return bestellungCollection;
    }

    @GetMapping(path = "/{id}")
    public Bestellung get(@PathVariable Long id) {
        return bestellungen.get(id);
    }
    @GetMapping(path = "kundenNr/{value}")
    public ArrayList<Bestellung> getKunde(@PathVariable Long value) {
        ArrayList<Bestellung> b = new ArrayList<Bestellung>();
        for (Long i = 0L; i < bestellungen.size(); i++) {
            if (bestellungen.get(i).kundenNr == value) {
                b.add(bestellungen.get(i));
            }
        }
        return b;
    }

    @PostMapping
    public Bestellung post(@RequestBody Bestellung bestellung) {
        bestellungen.put(bestellung.bestellungsNr, bestellung);
        return bestellung;
    }

    @PutMapping(path = "/{id}")
    public Bestellung put(@PathVariable Long id,
                               @RequestBody Bestellung bestellung) {
        Bestellung best = bestellungen.get(id);
        if (best != null) {
            if (bestellung.bestellungsNr!=null)
                best.bestellungsNr = bestellung.bestellungsNr;
            if (bestellung.kundenNr!=null)
                best.kundenNr = bestellung.kundenNr;
            return bestellung;
        } else {
            bestellungen.put(id, bestellung);
            return bestellung;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        bestellungen.remove(id);
    }

}
