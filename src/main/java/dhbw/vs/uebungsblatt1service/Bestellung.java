package dhbw.vs.uebungsblatt1service;

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

    public String toString() {
        return "Bestellung " + bestellungsNr + " für Kunde " + kundenNr;
    }
}
