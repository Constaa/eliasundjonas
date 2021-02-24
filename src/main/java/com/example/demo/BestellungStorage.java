package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class BestellungStorage
        extends ConcurrentHashMap<Long,Bestellung> {
    private BestellungStorage() {
        this.put(0l, new Bestellung(0L, 2L));
        this.put(1L, new Bestellung(1L, 2L));
        this.put(2L, new Bestellung(2L, 1L));
        this.put(3L, new Bestellung(3L, 3L));
    }
}
