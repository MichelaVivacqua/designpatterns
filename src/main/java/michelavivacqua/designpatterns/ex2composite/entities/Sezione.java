package michelavivacqua.designpatterns.ex2composite.entities;

import michelavivacqua.designpatterns.ex2composite.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class Sezione implements Shape {
    private List<Shape> componenti = new ArrayList<>();

    public void aggiungiComponente(Shape componente) {
        componenti.add(componente);
    }

    @Override
    public void stampare() {
        System.out.println("Stampo una sezione:");
        for (Shape componente : componenti) {
            componente.stampare();
        }
    }

    @Override
    public int getNumeroPagine() {
        int numPagine = 0;
        for (Shape componente : componenti) {
            numPagine += componente.getNumeroPagine();
        }
        return numPagine;
    }
}

