package michelavivacqua.designpatterns.ex3ChainofResponsibility.entities;

public class Tenente extends Ufficiale {
    public Tenente() {
        super(1000);
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
            System.out.println("Il Tenente percepisce almeno l'importo di " + importo);
        }
    }
}
