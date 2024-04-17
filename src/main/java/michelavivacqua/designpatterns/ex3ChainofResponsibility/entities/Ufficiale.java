package michelavivacqua.designpatterns.ex3ChainofResponsibility.entities;

import michelavivacqua.designpatterns.ex3ChainofResponsibility.interfaces.Handler;

public abstract class Ufficiale implements Handler {
    protected Handler responsabile;
    protected int stipendio;

    public Ufficiale(int stipendio) {
        this.stipendio = stipendio;
    }

    public void setResponsabile(Handler responsabile) {
        this.responsabile = responsabile;
    }
}
