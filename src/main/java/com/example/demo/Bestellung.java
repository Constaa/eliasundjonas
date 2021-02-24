package com.example.demo;

public class Bestellung {
    Kunde k = new Kunde();
    public Long bestellungsNr;
    public Long kundenNr = k.kundenNr;

    public Bestellung() {

    }
    public Bestellung(Long bestellungsNr, Long kundenNr) {
        this.bestellungsNr = bestellungsNr;
        this.kundenNr = kundenNr;
    }
}
