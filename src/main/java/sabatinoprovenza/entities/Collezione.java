package sabatinoprovenza.entities;

import java.util.ArrayList;
import java.util.List;

public class Collezione {
    private List<Gioco> collezione;

    public Collezione() {
        this.collezione = new ArrayList<>();
    }

    //CONTROLLO ID
    public boolean idEsiste(String id) {
        return collezione.stream()
                .anyMatch(g -> g.getIdGioco().equals(id));
    }

    // AGGIUNTA GIOCO
    public void aggiungi(Gioco gioco) {
        collezione.add(gioco);
    }


    public List<Gioco> getCollezione() {
        return collezione;
    }
}
