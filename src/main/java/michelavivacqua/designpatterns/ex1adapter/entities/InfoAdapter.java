package michelavivacqua.designpatterns.ex1adapter.entities;

import michelavivacqua.designpatterns.ex1adapter.interfaces.DataSource;

import java.time.LocalDate;
import java.util.Date;

public class InfoAdapter implements DataSource {
    private final Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }

    @Override
    public int getEta() {
        // Calcolo età in base alla data di nascita
        if (info.getDataDiNascita() != null) {

            Date dataDiNascita = info.getDataDiNascita();
            int annoDiNascita = dataDiNascita.getYear() ;
            System.out.println(annoDiNascita);

            LocalDate dataCorrente = LocalDate.now();
            int annoCorrente = dataCorrente.getYear();
            System.out.println(annoCorrente);

            int eta = annoCorrente - annoDiNascita;

            return eta;
        } else {
            // Nel caso in cui la data di nascita non sia disponibile, ritorniamo 0 come valore predefinito
            return 0;
        }
    }
}
