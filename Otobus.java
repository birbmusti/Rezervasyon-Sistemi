/**
 * Otobüs bilgilerini tutan sınıf.
 */
public class Otobus {

    private final String model;
    private final int kapasite;
    private final int solKoltukSayisi;
    private final int sagKoltukSayisi;

    public Otobus(String model, int kapasite, int solKoltukSayisi, int sagKoltukSayisi) {
        if (kapasite <= 0) throw new IllegalArgumentException("Kapasite > 0 olmalı.");
        this.model = model;
        this.kapasite = kapasite;
        this.solKoltukSayisi = solKoltukSayisi;
        this.sagKoltukSayisi = sagKoltukSayisi;
    }

    public String getModel() { return model; }
    public int getKapasite() { return kapasite; }
    public int getSolKoltukSayisi() { return solKoltukSayisi; }
    public int getSagKoltukSayisi() { return sagKoltukSayisi; }

    @Override
    public String toString() {
        return "Otobüs{model='" + model + "', kapasite=" + kapasite +
                ", düzen=" + solKoltukSayisi + "+" + sagKoltukSayisi + "}";
}
}