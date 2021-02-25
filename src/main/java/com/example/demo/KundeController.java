package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/kunden")
public class KundeController {

    private KundeStorage kunden;

    @Autowired KundeController(KundeStorage kundeStorage) {
        this.kunden = kundeStorage;
    }

    @GetMapping
    public Collection<Kunde> getAllKunden() {
        Collection<Kunde> kundeCollection = kunden.values();
        return kundeCollection;
    }

    @GetMapping(path = "/{id}")
    public Kunde getKunde(@PathVariable Long id) {
        return kunden.get(id);
    }

    @PostMapping
    public Kunde postKunde(@RequestBody Kunde kunde) {
        kunden.put(kunde.kundenNr, kunde);
        return kunde;
    }

    @PutMapping(path = "/{id}")
    public Kunde putKunde(@PathVariable Long id,
                               @RequestBody Kunde kunde) {
        Kunde kun = kunden.get(id);
        if (kun != null) {
            if (kunde.kundenNr!=null)
                kun.kundenNr = kunde.kundenNr;
            if (kunde.vorname!=null)
                kun.vorname = kunde.vorname;
            if (kunde.nachname!=null)
                kun.nachname = kunde.nachname;
            if (kunde.strasse!=null)
                kun.strasse = kunde.strasse;
            if (kunde.hausnr!=null)
                kun.hausnr = kunde.hausnr;
            if (kunde.plz!=null)
                kun.plz = kunde.plz;
            if (kunde.ort!=null)
                kun.ort = kunde.ort;
            return kunde;
        } else {
            kunden.put(id, kunde);
            return kunde;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteKunde(@PathVariable Long id) {
        kunden.remove(id);
    }

}
