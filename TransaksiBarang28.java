import java.util.Scanner;
public class TransaksiBarang28{
    public Barang28 [] barangs = new Barang28[50];
    public Barang28 [] pembelians = new Barang28[50];
    public int jumlBarang;
    public int jumlPembelian;

    public TransaksiBarang28(){
        barangs[jumlBarang++] = new Barang28("K01", "Sabun", 1000, 5);
        barangs[jumlBarang++] = new Barang28("K02", "Pasta Gigi", 2000, 10);
        barangs[jumlBarang++] = new Barang28("K03", "Biore", 3000, 23);
        barangs[jumlBarang++] = new Barang28("K04", "Shampoo", 4000, 55);
        barangs[jumlBarang++] = new Barang28("K05", "Sikat Gigi", 5000, 65);
    }
    public void tampilkanBarang() {
        System.out.println("=========================");
        System.out.println("     Daftar Barang       ");
        System.out.println("=========================");
        System.out.println("Daftar Barang:");
        System.out.println("==================================");
        System.out.println("| Kode  |    Nama    |   Harga   |");
        System.out.println("==================================");
        for (int i = 0; i < jumlBarang; i++) {
            Barang28 barang = barangs[i];
            System.out.printf("| %-5s | %-10s | %-9s |\n", barang.getKode(), barang.getNama(), barang.getHarga());        
        }
        System.out.println("==================================");
    }
    
    public void tampilkanBarangPembelian() {
        System.out.println("Daftar Pembelian:");
        System.out.println("==================================");
        System.out.println("| Kode  |    Nama    |   Harga   |");
        System.out.println("==================================");
        for (int i = 0; i < jumlPembelian; i++) {
            Barang28 barang = pembelians[i];
            System.out.printf("| %-5s | %-10s | %-9s |\n", barang.getKode(), barang.getNama(), barang.getHarga());
        }
        System.out.println("==================================");
    }
    public void melakukanPembelian() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Masukkan kode barang: ");
            String kodeBarang = sc.nextLine();

            Barang28 barangDibeli = null;
            for (int i = 0; i < jumlBarang; i++) {
                Barang28 barang = barangs[i];
                if (barang.getKode().equals(kodeBarang)) {
                    barangDibeli = barang;
                    break;
                }
            }

            if (barangDibeli != null && barangDibeli.getStok() > 0) {
                pembelians[jumlPembelian++] = barangDibeli;
                barangDibeli.setStok(barangDibeli.getStok() - 1);
                System.out.println("Pembelian berhasil!");

                System.out.print("Apakah ingin menambahkan barang lagi? (ya/tidak): ");
                String tambahLagi = sc.nextLine();
                if (!tambahLagi.equalsIgnoreCase("ya")) {
                    break;
                }
            } else {
                System.out.println("Barang tidak ditemukan atau stok habis.");
            }
        } while(true);
    }
    }


