package sabatinoprovenza.entities;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataOre;
    private Genere genere;

    public Videogioco(String idGioco, String titolo, int annoPubblicazione, double prezzo,
                      String piattaforma, int durataOre, Genere genere) {
        super(idGioco, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public void setDurataOre(int durataOre) {
        this.durataOre = durataOre;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
