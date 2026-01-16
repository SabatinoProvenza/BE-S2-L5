package sabatinoprovenza;

import sabatinoprovenza.entities.Genere;
import sabatinoprovenza.entities.Gioco;
import sabatinoprovenza.entities.GiocoDaTavolo;
import sabatinoprovenza.entities.Videogioco;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Gioco> catalogo = new ArrayList<>();

        // VIDEOGIOCHI
        catalogo.add(new Videogioco(
                "VG01",
                "The Legend of Zelda",
                2023,
                59.99,
                "Switch",
                60,
                Genere.ADVENTURE
        ));

        catalogo.add(new Videogioco(
                "VG02",
                "Elden Ring",
                2022,
                49.99,
                "PS5",
                80,
                Genere.RPG
        ));

        catalogo.add(new Videogioco(
                "VG03",
                "FIFA 26",
                2025,
                69.99,
                "PS5",
                100,
                Genere.SPORTS
        ));

        // GIOCHI DA TAVOLO
        catalogo.add(new GiocoDaTavolo(
                "GT01",
                "Catan",
                1995,
                34.99,
                4,
                75
        ));

        catalogo.add(new GiocoDaTavolo(
                "GT02",
                "Risiko",
                1957,
                29.99,
                6,
                120
        ));

        // STAMPA DI PROVA
        for (Gioco g : catalogo) {
            System.out.println(g.getTitolo() + " - " + g.getPrezzo() + "€");
        }
    }
}
