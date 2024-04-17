package michelavivacqua.designpatterns.ex2composite.entities;


import michelavivacqua.designpatterns.ex2composite.interfaces.Shape;

public class Pagina implements Shape {
    @Override
    public void stampare() {
        System.out.println("Stampo una pagina");
    }

    @Override
    public int getNumeroPagine() {
        return 1;
    }
}

