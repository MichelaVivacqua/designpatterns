package michelavivacqua.designpatterns.ex3ChainofResponsibility.entities;

public class Generale extends Ufficiale {
    public Generale() {
        super(5000);
    }

    @Override
    public void gestisciRichiesta(int importo) {
        if (importo >= stipendio) {
            if (responsabile != null) {
                responsabile.gestisciRichiesta(importo);
            } else {
                System.out.println("Nessuno percepisce l'importo di " + importo);
            }
        } else {
            System.out.println("Il Generale percepisce almeno l'importo di " + importo);
        }
    }
}

