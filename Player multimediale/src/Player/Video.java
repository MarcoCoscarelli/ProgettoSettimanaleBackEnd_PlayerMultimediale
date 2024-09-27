package Player;

public class Video extends ElementoMultimediale implements Luminosita, Volume {
    private int luminosita;
    private int volume;
    private int durata;

    public Video(String titolo, int luminosita, int volume, int durata) {
        super(titolo);
        this.luminosita = luminosita;
        this.volume = volume;
        this.durata = durata;
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
    public void alzaVolume() {
        volume++;
    }

    @Override
    public void abbassaVolume() {
        volume--;
    }

    @Override
    void esegui() {
        mostraVideo();
    }

    void mostraVideo(){

        //volume
        StringBuilder vol = new StringBuilder();
        for (int i = 0; i < this.volume; i++) {
            vol.append('!');
        }

        //luminosita
        StringBuilder lum = new StringBuilder();
        for (int i = 0; i < this.luminosita; i++) {
            lum.append('*');
        }

        //durata
        for (int i = 0; i < durata; i++) {
            System.out.println("Riproduci video: " + getTitolo() + " - Volume: " + vol + " - Luminosità: "+ lum);
        }
    }
}