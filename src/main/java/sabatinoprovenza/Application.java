package sabatinoprovenza;

import sabatinoprovenza.entities.*;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();

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

        int scelta;

        do {
            System.out.println("=== MENU COLLEZIONE ===");
            System.out.println("1) Aggiungi videogioco (utente)");
            System.out.println("2) Ricerca per ID");
            System.out.println("3) Ricerca per prezzo massimo");
            System.out.println("4) Ricerca giochi da tavolo per numero giocatori");
            System.out.println("5) Rimuovi gioco per ID");
            System.out.println("6) Aggiorna gioco");
            System.out.println("7) Stampa statistiche collezione");
            System.out.println("8) Stampa tutti i giochi");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");


            scelta = Integer.parseInt(scanner.nextLine());
            switch (scelta) {

                case 1:
                    // AGGIUNTA VIDEOGIOCO UTENTE
                    String id;
                    while (true) {
                        System.out.print("ID gioco: ");
                        id = scanner.nextLine().toUpperCase();

                        if (collezione.idEsiste(id)) {
                            System.out.println("ID già presente. Inseriscine un altro");
                        } else {
                            break;
                        }
                    }

                    System.out.print("Titolo: ");
                    String titolo = scanner.nextLine();

                    System.out.print("Anno pubblicazione: ");
                    int anno = Integer.parseInt(scanner.nextLine());

                    double prezzo;

                    while (true) {
                        try {
                            System.out.print("Prezzo: ");
                            prezzo = Double.parseDouble(scanner.nextLine());
                            if (prezzo > 0)
                                break;
                            else {
                                System.out.println("Numero inserito non valido,riprova");

                            }

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    System.out.print("Piattaforma: ");
                    String piattaforma = scanner.nextLine();

                    System.out.print("Durata (ore): ");
                    int durata = Integer.parseInt(scanner.nextLine());

                    System.out.print("Genere (ACTION, RPG, STRATEGY, SPORTS, ADVENTURE, SIMULATION): ");
                    Genere genere = Genere.valueOf(scanner.nextLine());

                    Videogioco v = new Videogioco(
                            id, titolo, anno, prezzo, piattaforma, durata, genere
                    );
                    collezione.aggiungi(v);

                    System.out.println("Gioco inserito correttamente!");
                    break;

                case 2:
                    // RICERCA PER ID
                    System.out.print("Inserisci l'ID del gioco da cercare: ");
                    String idRicerca = scanner.nextLine().toUpperCase();

                    Gioco trovato = collezione.cercaPerId(idRicerca);

                    if (trovato == null) {
                        System.out.println("Nessun gioco trovato con ID: " + idRicerca);
                    } else {
                        System.out.println("Gioco trovato!");
                        System.out.println(
                                trovato.getTitolo() + " - " +
                                        trovato.getPrezzo() + "€"
                        );
                    }
                    break;

                case 3:
                    // RICERCA PER PREZZO
                    System.out.print("Inserisci il prezzo massimo: ");
                    double prezzoRicerca = Double.parseDouble(scanner.nextLine());

                    List<Gioco> risultati = collezione.cercaPerPrezzo(prezzoRicerca);

                    if (risultati.isEmpty()) {
                        System.out.println("Nessun gioco trovato sotto il prezzo di " + prezzoRicerca + "€");
                    } else {
                        System.out.println("Giochi trovati:");
                        for (Gioco g : risultati) {
                            System.out.println(g.getTitolo() + " - " + g.getPrezzo() + "€");
                        }
                    }
                    break;

                case 4:
                    // RICERCA PER NUMERO GIOCATORI
                    try {
                        System.out.print("Inserisci numero di giocatori (2-10): ");
                        int numero = Integer.parseInt(scanner.nextLine());

                        List<GiocoDaTavolo> risultatiTavolo =
                                collezione.cercaPerNumeroGiocatori(numero);

                        if (risultatiTavolo.isEmpty()) {
                            System.out.println("Nessun gioco da tavolo trovato.");
                        } else {
                            risultatiTavolo.forEach(System.out::println);
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;

                case 5:
                    // RIMOZIONE TRAMITE ID
                    try {
                        System.out.print("Inserisci ID del gioco da rimuovere: ");
                        String idDaRimuovere = scanner.nextLine().toUpperCase();

                        collezione.rimuoviPerId(idDaRimuovere);

                        System.out.println("Gioco rimosso correttamente.");

                    } catch (GiocoNonTrovatoException e) {
                        System.out.println("Errore: " + e.getMessage());

                    }
                    break;

                case 6:
                    // AGGIORNAMENTO DI UN ELEMENTO
                    String idAgg;
                    while (true) {
                        System.out.print("Inserisci ID del gioco da aggiornare: ");
                        idAgg = scanner.nextLine().toUpperCase();

                        if (collezione.idEsiste(idAgg)) {
                            break;
                        } else {
                            System.out.println("ID non trovato. Riprova.");
                        }
                    }

                    System.out.print("Nuovo titolo: ");
                    String nuovoTitolo = scanner.nextLine();

                    System.out.print("Nuovo anno di pubblicazione: ");
                    int nuovoAnno = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nuovo prezzo: ");
                    double nuovoPrezzo = Double.parseDouble(scanner.nextLine());

                    collezione.aggiornaGioco(idAgg, nuovoTitolo, nuovoAnno, nuovoPrezzo);
                    System.out.println("Gioco aggiornato correttamente!");
                    break;

                case 7:
                    // STATISTICHE COLLEZIONE
                    collezione.stampaStatistiche();
                    break;

                case 8:
                    // stampa di prova (tutti i giochi)
                    for (Gioco g : collezione.getCollezione()) {
                        System.out.println(g.getTitolo() + " - " + g.getPrezzo() + "€");
                    }
                    break;

                case 0:
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("SCELTA NON VALIDA, riprova!");

            }

        } while (scelta != 0);

    }
}



