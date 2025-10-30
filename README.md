# Otobüs Rezervasyon Simülasyonu

Bu proje, Java kullanılarak geliştirilmiş basit bir konsol tabanlı otobüs rezervasyon sistemi örneğidir.  
Kullanıcılar sefer oluşturabilir, koltuk rezervasyonu yapabilir, iptal edebilir ve sefer doluluk durumlarını görüntüleyebilir.

---

## Sınıflar

| Sınıf Adı | Açıklama |
|------------|-----------|
| Main.java | Uygulamanın giriş noktasıdır. Konsol menüsünü yönetir. |
| RezervasyonSistemi.java | Sefer ve rezervasyon işlemlerini kontrol eder. |
| Sefer.java | Kalkış, varış, tarih, saat ve koltuk durumlarını tutar. |
| Otobus.java | Otobüs modeli, kapasite ve koltuk düzenini tanımlar. |
| Rezervasyon.java | Yolcuya ait rezervasyon bilgilerini tutar (kod, koltuk, sefer). |

---

## Özellikler

- Yeni sefer oluşturma  
- Sefer listesini görüntüleme  
- Koltuk rezervasyonu yapma  
- Rezervasyon iptali  
- Sefer doluluk durumunu gösterme  

---

## Kullanım
1- Tüm ```.java``` dosyalarını aynı klasöre kaydedin.

`
Main.java  
RezervasyonSistemi.java  
Sefer.java  
Otobus.java  
Rezervasyon.java
`

2- Terminal veya komut satırında derleyin:

`javac *.java
`

3- Programı çalıştırın:

`java Main`

---

## Örnek Menü

=== Otobüs Rezervasyon Simülasyonu ===
1) Sefer Oluştur
2) Seferleri Listele
3) Koltuk Rezervasyonu Yap
4) Rezervasyon İptal Et
5) Doluluk Durumunu Görüntüle
0) Çıkış
