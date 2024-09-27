package Player;

public class Audio extends ElementoMultimediale implements Volume {
    private int durata;
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    @Override
    public void abbassaVolume() {
        volume--;
    }

    @Override
    public void alzaVolume() {
        volume++;
    }

    @Override
    public void esegui() {
        riproduciAudio();
    }

    void riproduciAudio() {

        StringBuilder vol = new StringBuilder();
        for (int i = 0; i < this.volume; i++) {
            vol.append('!');
        }

        for (int i = 0; i < durata; i++) {
            System.out.println("Traccia audio: " + getTitolo() + " - Volume: " + vol);
        }
    }
}