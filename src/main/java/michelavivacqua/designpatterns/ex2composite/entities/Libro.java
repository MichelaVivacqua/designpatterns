package michelavivacqua.designpatterns.ex2composite.entities;

import michelavivacqua.designpatterns.ex2composite.interfaces.Shape;

import java.util.List;

public class Libro {
    private List<String> autori;
    private double prezzo;
    private Shape radice; // Radice dell'albero di componenti del libro

    public Libro(List<String> autori, double prezzo, Shape radice) {
        this.autori = autori;
        this.prezzo = prezzo;
        this.radice = radice;
    }

    public void stampare() {
        radice.stampare();
    }

    public int getNumeroPagine() {
        return radice.getNumeroPagine();
    }
}
