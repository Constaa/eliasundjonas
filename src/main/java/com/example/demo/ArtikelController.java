package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        artikel.remove(id);
    }

}
