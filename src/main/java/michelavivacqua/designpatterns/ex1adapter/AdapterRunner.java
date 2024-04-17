package michelavivacqua.designpatterns.ex1adapter;

import michelavivacqua.designpatterns.ex1adapter.entities.Info;
import michelavivacqua.designpatterns.ex1adapter.entities.InfoAdapter;
import michelavivacqua.designpatterns.ex1adapter.entities.UserData;
import michelavivacqua.designpatterns.ex1adapter.interfaces.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AdapterRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AdapterRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Creiamo un'istanza di Info
        Info info = new Info();
        info.setNome("Mario");
        info.setCognome("Bros");
        info.DataDiNascita(new Date(1997, 1, 9));

        // Creiamo un'istanza di UserData
        UserData userData = new UserData();

        // Creiamo un'istanza dell'adapter e passiamo l'istanza di Info
        DataSource adapter = new InfoAdapter(info);

        // Ora possiamo passare l'adapter a UserData per ottenere i dati
        userData.getData(adapter);

        // Stampiamo i dati ottenuti da UserData
        System.out.println("Nome completo: " + userData.getNomeCompleto());
        System.out.println("Età: " + userData.getEta());
    }
}
