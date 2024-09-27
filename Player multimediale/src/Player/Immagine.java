package Player;

public class Immagine extends ElementoMultimediale implements Luminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    @Override
    public void aumentaLuminosita() {
        luminosita++;
    }

    @Override
    public void diminuisciLuminosita() {
        luminosita--;
    }

    @Override
    public void esegui() {
        //azione specifica immagine
        show();
    }

    void show() {
        //luminosita
        StringBuilder lum = new StringBuilder();
        for (int i = 0; i < this.luminosita; i++) {
            lum.append('*');
        }

        //mostra immagine
        System.out.println("Titolo immagine: " + getTitolo() + "; - Luminosità: " + lum);
    }
}
