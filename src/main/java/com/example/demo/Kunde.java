package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Kunde {
    public Long kundenNr;
    public String vorname;
    public String nachname;
    public String strasse;
    public Integer hausnr;
    public Integer plz;
    public String ort;

    public Kunde() {

    }
    public Kunde(Long kundenNr, String vorname, String nachname, String strasse, Integer hausnr, Integer plz, String ort) {
        this.kundenNr = kundenNr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.strasse = strasse;
        this.hausnr = hausnr;
        this.plz = plz;
        this.ort = ort;
    }
}
