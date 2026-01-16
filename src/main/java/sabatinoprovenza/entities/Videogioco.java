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
}
