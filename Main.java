import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RezervasyonSistemi sistem = new RezervasyonSistemi();
        sistem.ornekVeriEkle(); // örnek seferler
        Scanner girdi = new Scanner(System.in);

        while (true) {
            menuYazdir();
            System.out.print("Seçiminiz: ");
            String secim = girdi.nextLine().trim();

            switch (secim) {
                case "1":
                    seferOlustur(sistem, girdi);
                    break;
                case "2":
                    sistem.seferleriListele();
                    break;
                case "3":
                    rezervasyonYap(sistem, girdi);
                    break;
                case "4":
                    rezervasyonIptal(sistem, girdi);
                    break;
                case "5":
                    dolulukGoster(sistem, girdi);
                    break;
                case "0":
                    System.out.println("Çıkılıyor. İyi günler!");
                    return;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
            System.out.println();
        }
    }

    private static void menuYazdir() {
        System.out.println("=== Otobüs Rezervasyon Simülasyonu ===");
        System.out.println("1) Sefer Oluştur");
        System.out.println("2) Seferleri Listele");
        System.out.println("3) Koltuk Rezervasyonu Yap");
        System.out.println("4) Rezervasyon İptal Et");
        System.out.println("5) Doluluk Durumunu Görüntüle");
        System.out.println("0) Çıkış");
    }

    private static void seferOlustur(RezervasyonSistemi sistem, Scanner girdi) {
        try {
            System.out.print("Kalkış şehri: ");
            String kalkis = girdi.nextLine().trim();
            System.out.print("Varış şehri: ");
            String varis = girdi.nextLine().trim();
            System.out.print("Tarih (YYYY-MM-DD): ");
            String tarih = girdi.nextLine().trim();
            System.out.print("Saat (HH:MM): ");
            String saat = girdi.nextLine().trim();
            System.out.print("Koltuk sayısı: ");
            int kapasite = Integer.parseInt(girdi.nextLine().trim());

            Otobus otobus = new Otobus("Standart", kapasite, 2, 2);
            Sefer sefer = sistem.seferOlustur(kalkis, varis, tarih, saat, otobus);
            System.out.println("Sefer oluşturuldu: " + sefer);
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    private static void rezervasyonYap(RezervasyonSistemi sistem, Scanner girdi) {
        try {
            System.out.print("Sefer ID: ");
            int seferId = Integer.parseInt(girdi.nextLine().trim());
            System.out.print("Yolcu adı: ");
            String yolcuAdi = girdi.nextLine().trim();
            System.out.print("Koltuk No: ");
            int koltukNo = Integer.parseInt(girdi.nextLine().trim());

            Rezervasyon rezervasyon = sistem.rezervasyonYap(seferId, yolcuAdi, koltukNo);
            System.out.println("Rezervasyon tamam! Kod: " + rezervasyon.getKod());
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    private static void rezervasyonIptal(RezervasyonSistemi sistem, Scanner girdi) {
        System.out.print("Rezervasyon kodu: ");
        String kod = girdi.nextLine().trim();
        boolean sonuc = sistem.rezervasyonIptal(kod);
        System.out.println(sonuc ? "Rezervasyon iptal edildi." : "Rezervasyon bulunamadı.");
    }

    private static void dolulukGoster(RezervasyonSistemi sistem, Scanner girdi) {
        try {
            System.out.print("Sefer ID: ");
            int seferId = Integer.parseInt(girdi.nextLine().trim());
            sistem.dolulukGoster(seferId);
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}