package michelavivacqua.designpatterns.ex3ChainofResponsibility;

import michelavivacqua.designpatterns.ex3ChainofResponsibility.entities.*;
import michelavivacqua.designpatterns.ex3ChainofResponsibility.interfaces.Handler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChainRunner implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(michelavivacqua.designpatterns.ex3ChainofResponsibility.ChainRunner.class, args);
    }

    @Override
    public void run(String... args) {
        // Creiamo gli ufficiali nella gerarchia
        Tenente tenente = new Tenente();
        Capitano capitano = new Capitano();
        Maggiore maggiore = new Maggiore();
        Colonnello colonnello = new Colonnello();
        Generale generale = new Generale();

        // Configuriamo i responsabili nella catena gerarchica
        tenente.setResponsabile(capitano);
        capitano.setResponsabile(maggiore);
        maggiore.setResponsabile(colonnello);
        colonnello.setResponsabile(generale);

        // Testiamo l'applicazione passando importi diversi
        testaImporto(1500, tenente); // Dovrebbe essere gestito dal Capitano
        testaImporto(3500, tenente); // Dovrebbe essere gestito dal Colonnello
        testaImporto(6000, tenente); // Nessuno può gestirlo
    }

    private static void testaImporto(int importo, Handler handler) {
        System.out.println("Chi percepisce poco più di " + importo + " ?");
        handler.gestisciRichiesta(importo);
        System.out.println();
    }
}




