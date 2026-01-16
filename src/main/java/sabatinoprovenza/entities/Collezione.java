package sabatinoprovenza.entities;

import sabatinoprovenza.GiocoNonTrovatoException;
import sabatinoprovenza.IdDuplicatoException;

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

    //RICERCA PER ID
    public Gioco cercaPerId(String id) {
        List<Gioco> trovati = collezione.stream().filter(gioco -> gioco.getIdGioco().equals(id))
                .toList();
        if (!trovati.isEmpty()) {
            return trovati.get(0);
        } else {
            return null;
        }
    }

    //RICERCA PER PREZZO
    public List<Gioco> cercaPerPrezzo(double prezzoMax) {
        return collezione.stream()
                .filter(gioco -> gioco.getPrezzo() < prezzoMax)
                .toList();
    }

    //RICERCA PER NUMERO GIOCATORI
    public List<GiocoDaTavolo> cercaPerNumeroGiocatori(int numero) {
        if (numero < 2 || numero > 10)
            throw new IllegalArgumentException("Numero di giocatori non valido (2-10)");

        return collezione.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(gdt -> gdt.getNumeroGiocatori() == numero)
                .toList();
    }

    //RIMOZIONE TRAMITE ID
    public void rimuoviPerId(String id) {
        boolean rimosso = collezione.removeIf(
                gioco -> gioco.getIdGioco().equals(id)
        );

        if (!rimosso)
            throw new GiocoNonTrovatoException(
                    "Nessun gioco trovato con ID: " + id
            );
    }

    //AGGIORNAMENTO DI UN ELEMENTO
    public void aggiornaGioco(String id, String nuovoTitolo, int nuovoAnno, double nuovoPrezzo) {

        Gioco[] giocoDaAggiornare = new Gioco[1];

        collezione.stream()
                .filter(g -> g.getIdGioco().equals(id))
                .forEach(g -> giocoDaAggiornare[0] = g);

        if (giocoDaAggiornare[0] == null) {
            throw new GiocoNonTrovatoException("Nessun gioco trovato con ID: " + id);
        }

        giocoDaAggiornare[0].setTitolo(nuovoTitolo);
        giocoDaAggiornare[0].setAnnoPubblicazione(nuovoAnno);
        giocoDaAggiornare[0].setPrezzo(nuovoPrezzo);
    }


    //STAMPA STATISTICHE
    public void stampaStatistiche() {

        long numeroVideogiochi = collezione.stream()
                .filter(g -> g instanceof Videogioco)
                .count();

        long numeroGiochiDaTavolo = collezione.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .count();

        Gioco giocoPiuCaro = null;
        for (Gioco g : collezione) {
            if (giocoPiuCaro == null || g.getPrezzo() > giocoPiuCaro.getPrezzo()) {
                giocoPiuCaro = g;
            }
        }

        double sommaPrezzi = collezione.stream()
                .mapToDouble(g -> g.getPrezzo())
                .sum();

        double mediaPrezzi = 0;
        if (!collezione.isEmpty()) {
            mediaPrezzi = sommaPrezzi / collezione.size();
        }

        System.out.println("---- STATISTICHE COLLEZIONE ----");
        System.out.println("Numero videogiochi: " + numeroVideogiochi);
        System.out.println("Numero giochi da tavolo: " + numeroGiochiDaTavolo);
        System.out.println("Prezzo medio: " + mediaPrezzi);

        if (giocoPiuCaro != null) {
            System.out.println("Gioco più caro: " + giocoPiuCaro);
        } else {
            System.out.println("Collezione vuota.");
        }
    }


    // AGGIUNTA GIOCO
    public void aggiungi(Gioco gioco) {
        if (idEsiste(gioco.getIdGioco())) {
            throw new IdDuplicatoException(
                    "Gioco con ID già presente: " + gioco.getIdGioco()
            );
        }
        collezione.add(gioco);
    }


    public List<Gioco> getCollezione() {
        return collezione;
    }


}
