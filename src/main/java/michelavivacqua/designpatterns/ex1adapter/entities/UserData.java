package michelavivacqua.designpatterns.ex1adapter.entities;

import lombok.Getter;
import michelavivacqua.designpatterns.ex1adapter.interfaces.DataSource;

@Getter
public class UserData {
    private String nomeCompleto;
    private int eta;
    public void getData(DataSource ds) {
        nomeCompleto= ds.getNomeCompleto ();
        eta= ds.getEta();
    }
}
