package com.example.demo;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

@RequestMapping("/artikel")
public class ArtikelController {

    private ArtikelStorage artikels;

    @Autowired
    ArtikelController(ArtikelStorage artikelStorage) {
        this.artikels = artikelStorage;
    }

    @GetMapping(path = "/{id}")
    public Artikel get(@PathVariable String id) {
        return artikels.get(id);
    }
}