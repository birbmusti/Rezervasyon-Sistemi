import java.util.*;

/**
 * Sefer bilgilerini tutar (kalkış, varış, tarih, saat, otobüs, koltuk durumu).
 */
public class Sefer {

    private static int SONRAKI_ID = 1;

    private final int id;
    private final String kalkis;
    private final String varis;
    private final String tarih;
    private final String saat;
    private final Otobus otobus;

    private final Map<Integer, String> koltukDurumu = new HashMap<>();

    public Sefer(String kalkis, String varis, String tarih, String saat, Otobus otobus) {
        this.id = SONRAKI_ID++;
        this.kalkis = kalkis;
        this.varis = varis;
        this.tarih = tarih;
        this.saat = saat;
        this.otobus = otobus;

        for (int i = 1; i <= otobus.getKapasite(); i++) {
            koltukDurumu.put(i, null);
        }
    }

    public int getId() { return id; }
    public int getKapasite() { return otobus.getKapasite(); }
    public boolean koltukGecerliMi(int koltukNo) { return koltukNo >= 1 && koltukNo <= otobus.getKapasite(); }
    public boolean koltukBosMu(int koltukNo) { return koltukDurumu.get(koltukNo) == null; }

    public void koltukDoldur(int koltukNo, String kod) { koltukDurumu.put(koltukNo, kod); }
    public void koltukBosalt(int koltukNo) { koltukDurumu.put(koltukNo, null); }

    public void koltukDurumuYazdir() {
        int kapasite = otobus.getKapasite();
        int sol = otobus.getSolKoltukSayisi();
        int sag = otobus.getSagKoltukSayisi();
        int satir = sol + sag;

        System.out.println("Koltuk Planı (X=Dolu, .=Boş)");
        for (int i = 1; i <= kapasite; i += satir) {
            for (int s = 0; s < sol && (i + s) <= kapasite; s++) {
                System.out.printf("%2d[%s] ", i + s, koltukDurumu.get(i + s) == null ? "." : "X");
            }
            System.out.print(" | ");
            for (int s = 0; s < sag && (i + sol + s) <= kapasite; s++) {
                int koltuk = i + sol + s;
                System.out.printf("%2d[%s] ", koltuk, koltukDurumu.get(koltuk) == null ? "." : "X");
            }
            System.out.println();
        }
        long dolu = koltukDurumu.values().stream().filter(Objects::nonNull).count();
        System.out.printf("Dolu: %d / %d, Boş: %d%n", dolu, kapasite, kapasite - dolu);
    }

    @Override
    public String toString() {
        return "Sefer{id=" + id + ", " + kalkis + " -> " + varis +
                ", " + tarih + " " + saat + ", " + otobus + "}";
    }
}