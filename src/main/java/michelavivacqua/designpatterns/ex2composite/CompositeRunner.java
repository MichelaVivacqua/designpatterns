package michelavivacqua.designpatterns.ex2composite;

import michelavivacqua.designpatterns.ex2composite.entities.Sezione;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import michelavivacqua.designpatterns.ex2composite.entities.Libro;
import michelavivacqua.designpatterns.ex2composite.entities.Pagina;

import java.util.Arrays;

//https://refactoring.guru/design-patterns/composite/java/example

@SpringBootApplication
public class CompositeRunner implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CompositeRunner.class, args);
    }

    @Override
    public void run(String... args) {
        // Creiamo un libro
        Libro libro = creaLibro();

        // Stampiamo il libro
        System.out.println("Stampa del libro:");
        libro.stampare();

        // Otteniamo il numero totale di pagine nel libro
        int numeroPagine = libro.getNumeroPagine();
        System.out.println("Numero totale di pagine nel libro: " + numeroPagine);
    }

    private Libro creaLibro() {
        // Creiamo un'istanza di Sezione per rappresentare il libro
        Sezione libro = new Sezione();

        // Aggiungiamo pagine al libro
        libro.aggiungiComponente(new Pagina());
        libro.aggiungiComponente(new Pagina());
        libro.aggiungiComponente(new Pagina());

        // Creiamo una sezione per il capitolo 1
        Sezione capitolo1 = new Sezione();
        capitolo1.aggiungiComponente(new Pagina());
        capitolo1.aggiungiComponente(new Pagina());
        libro.aggiungiComponente(capitolo1);

        // Creiamo una sezione per il capitolo 2
        Sezione capitolo2 = new Sezione();
        capitolo2.aggiungiComponente(new Pagina());
        capitolo2.aggiungiComponente(new Pagina());
        capitolo2.aggiungiComponente(new Pagina());

        // Creiamo una sezione per il sottocapitolo 2.1
        Sezione sottocapitolo21 = new Sezione();
        sottocapitolo21.aggiungiComponente(new Pagina());
        capitolo2.aggiungiComponente(sottocapitolo21);

        libro.aggiungiComponente(capitolo2);

        // Aggiungiamo autori e prezzo
        return new Libro(Arrays.asList("Autore1", "Autore2"), 29.99, libro);
    }
}
