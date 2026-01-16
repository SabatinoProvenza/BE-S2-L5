package sabatinoprovenza.entities;

public class Gioco {
    private String idGioco;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(String idGioco, String titolo, int annoPubblicazione, double prezzo) {
        this.idGioco = idGioco;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;

        if (prezzo <= 0) {
            throw new IllegalArgumentException("Il Prezzo deve essere positivo");
        }
    }


    public String getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
