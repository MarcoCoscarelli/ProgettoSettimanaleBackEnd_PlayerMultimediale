package Player;

import java.util.Scanner;

abstract public class Player {

    public static void main(String[] args) {
        // Array predefinito
        ElementoMultimediale[] predefiniti = new ElementoMultimediale[5];

        predefiniti[0] = new Audio("Easy Lover", 5, 3);
        predefiniti[1] = new Video("Full Metal Alchemist", 5, 3, 10);
        predefiniti[2] = new Immagine("Vesuvio", 5);
        predefiniti[3] = new Audio("In The Air Tonight", 7, 5);
        predefiniti[4] = new Video("Inuyasha2", 6, 4, 8);

        // Array personalizzato
        ElementoMultimediale[] personalizzati = new ElementoMultimediale[5];
        Scanner scanner = new Scanner(System.in);

        // Menu principale
        int sceltaMenu;
        boolean haContenutiPersonalizzati = false; // Flag

        do {
            System.out.println("Scegli un'opzione:");
            System.out.println("1) Visualizza e riproduci contenuti predefiniti");
            System.out.println("2) Crea contenuti multimediali personalizzati");
            if (haContenutiPersonalizzati) { // Mostra l'opzione solo se ci sono contenuti personalizzati
                System.out.println("3) Riproduci contenuti personalizzati");

            }
            System.out.println("0) Esci");

            sceltaMenu = scanner.nextInt();
            scanner.nextLine(); //

            switch (sceltaMenu) {
                case 1:
                    riproduciContenuti(predefiniti, scanner);
                    break;
                case 2:
                    haContenutiPersonalizzati = creaContenuti(personalizzati, scanner);
                    break;
                case 3:
                    if (haContenutiPersonalizzati) {
                        riproduciContenuti(personalizzati, scanner);
                    } else {
                        System.out.println("Non hai creato contenuti personalizzati.");
                    }
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        } while (sceltaMenu != 0);
    }

    // riproduci predefiniti
    private static void riproduciContenuti(ElementoMultimediale[] elementi, Scanner scanner) {
        System.out.println("Contenuti disponibili:");
        mostraElementi(elementi);

        int sceltaUtente;
        do {
            System.out.println("Scegli un elemento da riprodurre (0 per finire): ");
            sceltaUtente = scanner.nextInt();

            if (sceltaUtente != 0 && sceltaUtente <= elementi.length) {
                if (elementi[sceltaUtente - 1] != null) {
                    elementi[sceltaUtente - 1].esegui();
                } else {
                    System.out.println("Elemento non disponibile. Riprova.");
                }
            } else if (sceltaUtente != 0) {
                System.out.println("Scelta non valida. Riprova.");
            }
        } while (sceltaUtente != 0);
    }

    // riproduci personalizzati
    private static boolean creaContenuti(ElementoMultimediale[] personalizzati, Scanner scanner) {
        System.out.println("Crea fino a 5 contenuti multimediali personalizzati:");
        boolean contenutiCreati = false; // Flag

        for (int i = 0; i < 5; i++) {
            System.out.println("Scegli tra: 1) Immagine");
            System.out.println("          : 2) Audio");
            System.out.println("          : 3) Video");
            System.out.println("          : 0) Termina creazione");

            int tipoMediaScelto = scanner.nextInt();
            scanner.nextLine();

            if (tipoMediaScelto == 0) {
                break;
            }

            // Immagine
            if (tipoMediaScelto == 1) {
                System.out.println("Inserisci titolo immagine: ");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci luminosità immagine: ");
                int luminosita = scanner.nextInt();

                personalizzati[i] = new Immagine(titolo, luminosita);
                contenutiCreati = true; // Contenuto creato
                System.out.println("Immagine aggiunta a contenuti personalizzati: " + titolo);
            }

            // Audio
            if (tipoMediaScelto == 2) {
                System.out.println("Inserisci titolo audio: ");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci durata: ");
                int durata = scanner.nextInt();

                System.out.println("Inserisci volume: ");
                int volume = scanner.nextInt();

                personalizzati[i] = new Audio(titolo, durata, volume);
                contenutiCreati = true; // Contenuto creato
                System.out.println("Audio aggiunto a contenuti personalizzati: " + titolo);
            }

            // Video
            if (tipoMediaScelto == 3) {
                System.out.println("Inserisci titolo video: ");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci durata: ");
                int durata = scanner.nextInt();

                System.out.println("Inserisci volume: ");
                int volume = scanner.nextInt();

                System.out.println("Inserisci luminosità: ");
                int luminosita = scanner.nextInt();

                personalizzati[i] = new Video(titolo, luminosita, volume, durata);
                contenutiCreati = true; // Contenuto creato
                System.out.println("Video aggiunto a contenuti personalizzati: " + titolo);
            }
        }
        return contenutiCreati; // mostra contenuti se creati
    }

    // mostra la lista degli elementi
    private static void mostraElementi(ElementoMultimediale[] elementi) {
        for (int i = 0; i < elementi.length; i++) {
            if (elementi[i] != null) {
                System.out.println((i + 1) + ". " + elementi[i].getTitolo());
            }
        }
    }
}


