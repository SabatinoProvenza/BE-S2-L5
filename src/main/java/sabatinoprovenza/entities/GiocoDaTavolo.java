package sabatinoprovenza.entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;      // 2..10
    private int durataMediaMinuti;    // in minuti

    public GiocoDaTavolo(String idGioco, String titolo, int annoPubblicazione, double prezzo,
                         int numeroGiocatori, int durataMediaMinuti) {
        super(idGioco, titolo, annoPubblicazione, prezzo);

        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaMinuti = durataMediaMinuti;


        if (numeroGiocatori < 2 || numeroGiocatori > 10)
            throw new IllegalArgumentException("Il numero dei giocatori deve essere tra 2 e 10");
    }
}
