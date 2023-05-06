import java.util.LinkedList;
import java.util.Scanner;

class Mobil {
    private String merek;
    private String warna;
    private String nomorPlat;
    private int harga;
    private boolean tersedia;

    public Mobil(String merek, String warna, String nomorPlat, int harga, boolean tersedia) {
        this.merek = merek;
        this.warna = warna;
        this.nomorPlat = nomorPlat;
        this.harga = harga;
        this.tersedia = tersedia;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public void setNomorPlat(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String toString() {
        return merek + " " + warna + " " + nomorPlat + " " + harga;
    }
}

public class Main{
    private LinkedList<Mobil> mobilTersedia = new LinkedList<>();
    private LinkedList<Mobil> mobilTersewa = new LinkedList<>();

    public Main() {
        mobilTersedia.add(new Mobil("Sedan", "Merah", "B 1234 ABC", 300000, true));
        mobilTersedia.add(new Mobil("Sport", "Hitam", "B 5678 DEF", 500000, true));
        mobilTersedia.add(new Mobil("SUV", "Biru", "B 9012 GHI", 800000, true));
    }

    public void lihatMobilTersedia() {
        System.out.println("Mobil Tersedia:");
        for (Mobil mobil : mobilTersedia) {
            System.out.println(mobil);
        }
    }

    public void lihatMobilTersewa() {
        System.out.println("Mobil Tersewa:");
        for (Mobil mobil : mobilTersewa) {
            System.out.println(mobil);
        }
    }

    public void inputMobilTersedia() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Merek: ");
            String merek = scanner.nextLine();
            System.out.print("Warna: ");
            String warna = scanner.nextLine();
            System.out.print("Nomor Plat: ");
            String nomorPlat = scanner.nextLine();
            System.out.print("Harga: ");
            int harga = scanner.nextInt();
            scanner.nextLine();
            mobilTersedia.add(new Mobil(merek, warna, nomorPlat, harga, true));
        }
    }

    public void inputMobilTersewa() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nomor Plat: ");
            String nomorPlat = scanner.nextLine();
            for (Mobil mobil : mobilTersedia) {
                if (mobil.getNomorPlat().equalsIgnoreCase(nomorPlat) && mobil.isTersedia()) {
                    mobilTersewa.add(mobil);
                    mobil.setTersedia(false);
                    System.out.println("Mobil dengan nomor plat " + nomorPlat + " telah disewa.");
                    return;
                }
            }
            System.out.println("Mobil dengan nomor plat " + nomorPlat + " tidak ditemukan atau sudah disewa.");
        }
    }

    public void hapusDepanMobilTersedia() {
        if (!mobilTersedia.isEmpty()) {
            mobilTersedia.removeFirst();
            System.out.println("Mobil tersedia di depan telah dihapus.");
        } else {
            System.out.println("Tidak ada mobil tersedia.");
        }
    }

    public void hapusTengahMobilTersedia() {
        if (!mobilTersedia.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Indeks mobil yang akan dihapus: ");
            int indeks = scanner.nextInt();
            if (indeks >= 0 && indeks < mobilTersedia.size()) {
                mobilTersedia.remove(indeks);
                System.out.println("Mobil tersedia di indeks " + indeks + " telah dihapus.");
            } else {
                System.out.println("Indeks tidak valid.");
            }
        } else {
            System.out.println("Tidak ada mobil tersedia.");
        }
    }

    public void hapusBelakangMobilTersedia() {
        if (!mobilTersedia.isEmpty()) {
            mobilTersedia.removeLast();
            System.out.println("Mobil tersedia di belakang telah dihapus.");
        } else {
            System.out.println("Tidak ada mobil tersedia.");
        }
    }

    public void hapusDepanMobilTersewa() {
        if (!mobilTersewa.isEmpty()) {
            Mobil mobil = mobilTersewa.removeFirst();
            mobil.setTersedia(true);
            System.out.println("Mobil tersewa di depan telah dihapus.");
        } else {
            System.out.println("Tidak ada mobil tersewa.");
        }
    }

    public void hapusTengahMobilTersewa() {
        if (!mobilTersewa.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Indeks mobil yang akan dihapus: ");
            int indeks = scanner.nextInt();
            if (indeks >= 0 && indeks < mobilTersewa.size()) {
                Mobil mobil = mobilTersewa.remove(indeks);
                mobil.setTersedia(true);
                System.out.println("Mobil tersewa di indeks " + indeks + " telah dihapus.");
            } else {
                System.out.println("Indeks tidak valid.");
            }
        } else {
            System.out.println("Tidak ada mobil tersewa.");
        }
    }

    public void hapusBelakangMobilTersewa() {
        if (!mobilTersewa.isEmpty()) {
            Mobil mobil = mobilTersewa.removeLast();
            mobil.setTersedia(true);
            System.out.println("Mobil tersewa di belakang telah dihapus.");
        } else {
            System.out.println("Tidak ada mobil tersewa.");
        };
    }
    
        public void cariMobilBerdasarkanPlat() {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Nomor Plat: ");
                String nomorPlat = scanner.nextLine();
                for (Mobil mobil : mobilTersedia) {
                    if (mobil.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                        System.out.println("Mobil tersedia dengan nomor plat " + nomorPlat + " ditemukan.");
                        return;
                    }
                }
                for (Mobil mobil : mobilTersewa) {
                    if (mobil.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                        System.out.println("Mobil tersewa dengan nomor plat " + nomorPlat + " ditemukan.");
                        return;
                    }
                }
                System.out.println("Mobil dengan nomor plat " + nomorPlat + " tidak ditemukan.");
            }
        }
    
        public void hitungJumlahMobilTersedia() {
            System.out.println("Jumlah mobil tersedia: " + mobilTersedia.size());
        }
    
        public void hitungJumlahMobilTersewa() {
            System.out.println("Jumlah mobil tersewa: " + mobilTersewa.size());
        }
    
        public void hitungPendapatan() {
            int totalPendapatan = 0;
            for (Mobil mobil : mobilTersewa) {
                totalPendapatan += mobil.getHarga();
            }
            System.out.println("Total pendapatan: Rp" + totalPendapatan);
        }

        public void tampilkanMenu() {
            System.out.println("Selamat datang di aplikasi penyewaan mobil!");
            Scanner scanner = new Scanner(System.in);
            int pilihan = -1;
            while (pilihan != 0) {
                System.out.println("Menu:");
                System.out.println("1. Lihat mobil tersedia");
                System.out.println("2. Lihat mobil tersewa");
                System.out.println("3. Input mobil ke tersedia");
                System.out.println("4. Input mobil ke tersewa");
                System.out.println("5. Hapus depan mobil tersedia");
                System.out.println("6. Hapus tengah mobil tersedia");
                System.out.println("7. Hapus belakang mobil tersedia");
                System.out.println("8. Hapus depan mobil tersewa");
                System.out.println("9. Hapus tengah mobil tersewa");
                System.out.println("10. Hapus belakang mobil tersewa");
                System.out.println("11. Cari mobil berdasarkan nomor plat");
                System.out.println("12. Hitung jumlah mobil tersedia");
                System.out.println("13. Hitung jumlah mobil tersewa");
                System.out.println("14. Hitung pendapatan");
                System.out.println("0. Keluar");
                System.out.print("Pilihan: ");
                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 1:
                        lihatMobilTersedia();
                        break;
                    case 2:
                        lihatMobilTersewa();
                        break;
                    case 3:
                        inputMobilTersedia();
                        break;
                    case 4:
                        inputMobilTersewa();
                        break;
                    case 5:
                        hapusDepanMobilTersedia();
                        break;
                    case 6:
                        hapusTengahMobilTersedia();
                        break;
                    case 7:
                        hapusBelakangMobilTersedia();
                        break;
                    case 8:
                        hapusDepanMobilTersewa();
                        break;
                    case 9:
                        hapusTengahMobilTersewa();
                        break;
                    case 10:
                        hapusBelakangMobilTersewa();
                        break;
                    case 11:
                        cariMobilBerdasarkanPlat();
                        break;
                    case 12:
                        hitungJumlahMobilTersedia();
                        break;
                    case 13:
                        hitungJumlahMobilTersewa();
                        break;
                    case 14:
                        hitungPendapatan();
                        break;
                        case 0:
                        System.out.println("Terima kasih telah menggunakan aplikasi kami.");
                        break;
                        default:
                        System.out.println("Pilihan tidak valid.");
                    }
                }
            }
    
    
public static void main(String[] args) {
    Main penyewaanMobil = new Main();
    penyewaanMobil.tampilkanMenu();
}
}
