package michelavivacqua.designpatterns.ex3ChainofResponsibility.entities;

public class Capitano extends Ufficiale {
    public Capitano() {
        super(2000);
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
            System.out.println("Il Capitano percepisce almeno l'importo di " + importo);
        }
    }
}
