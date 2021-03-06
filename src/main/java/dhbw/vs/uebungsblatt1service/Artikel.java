package dhbw.vs.uebungsblatt1service;

import org.springframework.stereotype.Component;

@Component
public class Artikel {

  public Long artikelNr;
  public String bezeichnung;
  public Double einzelpreis;

  public Artikel() {

  }

  public Artikel(Long artikelNr, String bezeichnung, Double einzelpreis) {
    this.artikelNr = artikelNr;
    this.bezeichnung = bezeichnung;
    this.einzelpreis = einzelpreis;
  }

  public String toString() {
    return bezeichnung + " für je " + einzelpreis;
  }

}
