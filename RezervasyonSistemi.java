import java.util.*;

/**
 * Sefer ve rezervasyon yönetimini yapan sınıf.
 */
public class RezervasyonSistemi {

    private final Map<Integer, Sefer> seferler = new LinkedHashMap<>();
    private final Map<String, Rezervasyon> rezervasyonlar = new HashMap<>();
    private final Random rastgele = new Random();

    public void ornekVeriEkle() {
        seferOlustur("İstanbul", "Ankara", "2025-11-01", "09:00", new Otobus("Travego", 40, 2, 2));
        seferOlustur("İzmir", "Bursa", "2025-11-01", "14:30", new Otobus("Neoplan", 34, 2, 1));
    }

    public Sefer seferOlustur(String kalkis, String varis, String tarih, String saat, Otobus otobus) {
        Sefer sefer = new Sefer(kalkis, varis, tarih, saat, otobus);
        seferler.put(sefer.getId(), sefer);
        return sefer;
    }

    public void seferleriListele() {
        if (seferler.isEmpty()) {
            System.out.println("Kayıtlı sefer yok.");
            return;
        }
        System.out.println("=== Sefer Listesi ===");
        for (Sefer s : seferler.values()) System.out.println(s);
    }

    public Rezervasyon rezervasyonYap(int seferId, String yolcuAdi, int koltukNo) {
        Sefer sefer = seferler.get(seferId);
        if (sefer == null) throw new IllegalArgumentException("Sefer bulunamadı.");
        if (!sefer.koltukGecerliMi(koltukNo)) throw new IllegalArgumentException("Geçersiz koltuk numarası.");
        if (!sefer.koltukBosMu(koltukNo)) throw new IllegalStateException("Koltuk dolu.");

        String kod = kodUret();
        Rezervasyon rezervasyon = new Rezervasyon(kod, yolcuAdi, seferId, koltukNo);

        sefer.koltukDoldur(koltukNo, kod);
        rezervasyonlar.put(kod, rezervasyon);
        return rezervasyon;
    }

    public boolean rezervasyonIptal(String kod) {
        Rezervasyon rezervasyon = rezervasyonlar.remove(kod);
        if (rezervasyon == null) return false;

        Sefer sefer = seferler.get(rezervasyon.getSeferId());
        if (sefer == null) return false;

        if (sefer.koltukGecerliMi(rezervasyon.getKoltukNo())) {
            sefer.koltukBosalt(rezervasyon.getKoltukNo());
            return true;
        }
        return false;
    }

    public void dolulukGoster(int seferId) {
        Sefer sefer = seferler.get(seferId);
        if (sefer == null) {
            System.out.println("Sefer bulunamadı.");
            return;
        }
        System.out.println(sefer);
        sefer.koltukDurumuYazdir();
    }

    private String kodUret() {
        String harfler = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder sb = new StringBuilder("RS-");
        for (int i = 0; i < 4; i++) sb.append(harfler.charAt(rastgele.nextInt(harfler.length())));
        sb.append("-");
        sb.append(100 + rastgele.nextInt(900));
        String kod = sb.toString();
        if (rezervasyonlar.containsKey(kod)) return kodUret();
        return kod;
    }
}