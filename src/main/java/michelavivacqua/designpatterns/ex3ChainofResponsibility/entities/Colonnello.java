package michelavivacqua.designpatterns.ex3ChainofResponsibility.entities;

public class Colonnello extends Ufficiale {
    public Colonnello() {
        super(4000);
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
            System.out.println("Il Colonnello percepisce almeno l'importo di " + importo);
        }
    }
}
