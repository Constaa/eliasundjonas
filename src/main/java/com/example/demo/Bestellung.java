package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Bestellung {

    public Long bestellungsNr;
    public Long kundenNr;

    public Bestellung() {

    }
    public Bestellung(Long bestellungsNr, Long kundenNr) {
        this.bestellungsNr = bestellungsNr;
        this.kundenNr = kundenNr;
    }
}
