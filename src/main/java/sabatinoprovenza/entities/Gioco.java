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

        if (prezzo <= 0) throw new IllegalArgumentException("Il prezzo deve essere magigore di 0");
    }


    public String getIdGioco() {
        return idGioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString() {
        return "{" +
                "ID = '" + idGioco + '\'' +
                ", titolo ='" + titolo + '\'' +
                ", annoPubblicazione =" + annoPubblicazione +
                ", prezzo =" + prezzo +
                '}';
    }
}
