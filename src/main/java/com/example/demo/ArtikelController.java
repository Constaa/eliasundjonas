package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    private ArtikelStorage artikel;

    @Autowired ArtikelController(ArtikelStorage artikelStorage) {
        this.artikel = artikelStorage;
    }

    @GetMapping(path = "/{id}")
    public Artikel get(@PathVariable Long id) {
        return artikel.get(id);
    }

    @GetMapping
    public Collection<Artikel> get(){
        Collection<Artikel> artikelCollection = artikel.values();
        return artikelCollection;
    }

    @PostMapping
    public Artikel post(@RequestBody Artikel newArtikel) {
        artikel.put(newArtikel.artikelNr, newArtikel);
        return newArtikel;
    }

    @PutMapping(path = "/{id}")
    public Artikel put(@PathVariable Long id,
                       @RequestBody Artikel newArtikel) {
        Artikel art = artikel.get(id);
        if (art != null) {
            if (newArtikel.artikelNr!=null)
                art.artikelNr = newArtikel.artikelNr;
            if (newArtikel.bezeichnung!=null)
                art.bezeichnung = newArtikel.bezeichnung;
            if (newArtikel.einzelpreis!=null)
                art.einzelpreis = newArtikel.einzelpreis;
            return newArtikel;
        } else {
            this.artikel.put(id, newArtikel);
            return newArtikel;
        }
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        artikel.remove(id);
    }

}
