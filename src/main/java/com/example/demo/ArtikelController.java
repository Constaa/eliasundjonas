package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    private ArtikelStorage artikel;

    @Autowired ArtikelController(ArtikelStorage artikelStorage) {
        this.artikel = artikelStorage;
    }

    @GetMapping
    public Artikel get(@RequestParam Long id) {
        return artikel.get(id);
    }
}
