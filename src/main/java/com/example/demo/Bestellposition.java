package com.example.demo;

public class Bestellposition {
    public Long bestellposNr;
    public Long bestellungsNr;
    public Long artikelNr;
    public Integer anzahl;

    public Bestellposition() {

    }
    public Bestellposition(Long bestellposNr, Long bestellungsNr, Long artikelNr, Integer anzahl) {
        this.bestellposNr = bestellposNr;
        this.bestellungsNr = bestellungsNr;
        this.artikelNr = artikelNr;
        this.anzahl = anzahl;
    }
}
