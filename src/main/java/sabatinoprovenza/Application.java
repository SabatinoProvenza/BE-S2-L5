package sabatinoprovenza;

import sabatinoprovenza.entities.Collezione;
import sabatinoprovenza.entities.Genere;
import sabatinoprovenza.entities.GiocoDaTavolo;
import sabatinoprovenza.entities.Videogioco;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();

        // VIDEOGIOCHI
        // VIDEOGIOCHI
        collezione.aggiungi(new Videogioco(
                "VG01",
                "The Legend of Zelda",
                2023,
                59.99,
                "Switch",
                60,
                Genere.adventure
        ));

        collezione.aggiungi(new Videogioco(
                "VG02",
                "Elden Ring",
                2022,
                49.99,
                "PS5",
                80,
                Genere.rpg
        ));

        collezione.aggiungi(new Videogioco(
                "VG03",
                "FIFA 26",
                2025,
                69.99,
                "PS5",
                100,
                Genere.sports
        ));

        // GIOCHI DA TAVOLO
        collezione.aggiungi(new GiocoDaTavolo(
                "GT01",
                "Catan",
                1995,
                34.99,
                4,
                75
        ));

        collezione.aggiungi(new GiocoDaTavolo(
                "GT02",
                "Risiko",
                1957,
                29.99,
                6,
                120
        ));


        Scanner scanner = new Scanner(System.in);
        //AGGIUNTA VIDEOGIOCO UTENTE

//        String id;
//        while (true) {
//            System.out.print("ID gioco: ");
//            id = scanner.nextLine().toUpperCase();
//
//            if (collezione.idEsiste(id)) {
//                System.out.println("ID già presente. Inseriscine un altro");
//            } else {
//                break;
//            }
//        }
//
//        System.out.print("Titolo: ");
//        String titolo = scanner.nextLine();
//
//        System.out.print("Anno pubblicazione: ");
//        int anno = Integer.parseInt(scanner.nextLine());
//
//        double prezzo;
//
//        while (true) {
//            try {
//                System.out.print("Prezzo: ");
//                prezzo = Double.parseDouble(scanner.nextLine());
//                if (prezzo > 0)
//                    break;
//                else {
//                    System.out.println("Numero inserito non valido,riprova");
//
//                }
//
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        System.out.print("Piattaforma: ");
//        String piattaforma = scanner.nextLine();
//
//        System.out.print("Durata (ore): ");
//        int durata = Integer.parseInt(scanner.nextLine());
//
//        System.out.print("Genere (ACTION, RPG, STRATEGY, SPORTS, ADVENTURE, SIMULATION): ");
//        Genere genere = Genere.valueOf(scanner.nextLine());
//
//        Videogioco v = new Videogioco(
//                id, titolo, anno, prezzo, piattaforma, durata, genere
//        );
//        collezione.aggiungi(v);
//
//        System.out.println("Gioco inserito correttamente!");


        //RICERCA PER ID
//        System.out.print("\nInserisci l'ID del gioco da cercare: ");
//        String idRicerca = scanner.nextLine().toUpperCase();
//
//        Gioco trovato = collezione.cercaPerId(idRicerca);
//
//        if (trovato == null) {
//            System.out.println("Nessun gioco trovato con ID: " + idRicerca);
//        } else {
//            System.out.println("Gioco trovato!");
//            System.out.println(
//                    trovato.getTitolo() + " - " +
//                            trovato.getPrezzo() + "€"
//            );
//        }


//        System.out.print("Inserisci il prezzo massimo: ");
//        double prezzoRicerca = Double.parseDouble(scanner.nextLine());
//
//        List<Gioco> risultati = collezione.cercaPerPrezzo(prezzoRicerca);
//
//        if (risultati.isEmpty()) {
//            System.out.println("Nessun gioco trovato sotto il prezzo di " + prezzoRicerca + "€");
//        } else {
//            System.out.println("Giochi trovati:");
//            for (Gioco g : risultati) {
//                System.out.println(g.getTitolo() + " - " + g.getPrezzo() + "€");
//            }
//        }


//        // stampa di prova
//        for (Gioco g : collezione.getCollezione()) {
//            System.out.println(g.getTitolo() + " - " + g.getPrezzo() + "€");
//        }

    }
}


