/**
 * Rezervasyon bilgilerini tutan sınıf.
 */
public class Rezervasyon {

    private final String kod;
    private final String yolcuAdi;
    private final int seferId;
    private final int koltukNo;

    public Rezervasyon(String kod, String yolcuAdi, int seferId, int koltukNo) {
        this.kod = kod;
        this.yolcuAdi = yolcuAdi;
        this.seferId = seferId;
        this.koltukNo = koltukNo;
    }

    public String getKod() { return kod; }
    public String getYolcuAdi() { return yolcuAdi; }
    public int getSeferId() { return seferId; }
    public int getKoltukNo() { return koltukNo; }

    @Override
    public String toString() {
        return "Rezervasyon{kod='" + kod + "', yolcu='" + yolcuAdi +
                "', seferId=" + seferId + ", koltukNo=" + koltukNo + "}";
    }
}