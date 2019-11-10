import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.InputMismatchException;

public class testPerpustakaan {

    public static void main(String[] args) {
       Scanner baca = new Scanner(System.in);
        Buku[] perpustakaan = new Buku[100];
        Random rand = new Random();
        int jumlahbuku = 3;
        double jumlahhalaman = 800;
        double jhfiksi = 0;
        double jhnonfiksi = 0;
        double standardeviasi = 0;
        double sdfiksi = 0;
        double sdnonfiksi = 0;
        
        int fiksi = 0;
        int nonfiksi = 0;

        for (int i=0; i<perpustakaan.length; i++) {
            int coinflip = rand.nextInt(2) + 1;
            if (coinflip == 1) {
                perpustakaan[i] = new fiksi();
            }
            if (coinflip == 2) {
                perpustakaan[i] = new nonfiksi();
            }
        }

        for (int i=0; i<3; i++) {
            int coinflip = rand.nextInt(2) + 1;
            if (coinflip == 1) {
                perpustakaan[i] = new Buku("Laskar Pelangi", "Andrea Hinata", "Fiksi", 600);
                fiksi += 1;
                jhfiksi += 600;
            }
            if (coinflip == 2) {
                perpustakaan[i] = new Buku("Cewek Smart", "Ria Fariana", "Non fiksi", 200);
                nonfiksi += 1;
                jhnonfiksi += 200;
            }
        }
        int pil = 1;
        do {
            System.out.print("===================================================");
            System.out.println("");
            header("perpus.txt");
            System.out.print("===================================================");
            System.out.println("\n[1]. input buku baru\n" + "[2]. modifikisi detail buku\n" + "[3]. hapus buku\n" + "[0]. EXIT");
            System.out.print("\n===================================================");

            double rata2 = jumlahhalaman/jumlahbuku;
            for (int i=0; i<jumlahbuku; i++) {
                standardeviasi = Math.pow((perpustakaan[i].getJumlahhalaman() - rata2), 2);
            }

            double ratafiksi = jhfiksi / fiksi;
            double ratanonfiksi = jhnonfiksi / nonfiksi;
            for (int i=0; i<jumlahbuku; i++) {
                if (perpustakaan[i].getJenisbuku() == "fiksi") {
                    sdfiksi = Math.pow((perpustakaan[i].getJumlahhalaman() - ratafiksi), 2);
                } else {
                    sdnonfiksi = Math.pow((perpustakaan[i].getJumlahhalaman() - ratanonfiksi), 2);
                }
           
            System.out.println("\nJumlah buku di dalam perpustakaan: " + jumlahbuku + "\nRata-rata halaman buku dalam perpustakaan: " + rata2 + "\nStandar deviasi halaman buku dalam perpustakaan: " + Math.sqrt(standardeviasi / jumlahbuku) +"\n===================================================\nJumlah Buku Fiksi dalam perpustakaan: " + fiksi + "\nRata-rata halaman Buku Fiksi dalam perpustakaan: " + ratafiksi + "\nStandar deviasi halaman Buku Fiksi dalam perpustakaan: " + Math.sqrt(sdfiksi / fiksi)+"\n===================================================\nJumlah Buku Non Fiksi dalam perpustakaan : " + nonfiksi + "\nRata-rata halaman Buku Non Fiksi dalam perpustakaan: " + ratanonfiksi + "\nStandar deviasi halaman Buku Non Fiksi dalam perpustakaan: " + Math.sqrt(sdnonfiksi / nonfiksi)+"\n===================================================");
   
            }
        int pilihan = baca.nextInt();
            if (pilihan == 1) {
                System.out.print("===================================================");
                System.out.println("");
                header("bukubaru.txt");
                System.out.println("===================================================");
                jumlahhalaman += 1;
                System.out.print("input judul buku : \n> ");
                String judul = baca.next();
                perpustakaan[jumlahbuku - 1].setJudul(judul);
                System.out.print("input pengarang buku : \n> ");
                String pengarang = baca.next();
                perpustakaan[jumlahbuku - 1].setPengarang(pengarang);
                System.out.print("input jumlah halaman buku : \n> ");
                int halaman = baca.nextInt();
                perpustakaan[jumlahbuku - 1].setJumlahhalaman(halaman);

                int coinflip = rand.nextInt(2) + 1;
                if (coinflip == 1) {
                    perpustakaan[jumlahbuku - 1] = new Buku(judul, pengarang, "Fiksi", halaman);
                    fiksi += 1;
                    jhfiksi += halaman;
                }
                if (coinflip == 2) {
                    perpustakaan[jumlahbuku - 1] = new Buku(judul, pengarang, "Non fiksi", halaman);
                    nonfiksi += 1;
                    jhnonfiksi += halaman;
                }

            } else if (pilihan == 2) {
                System.out.print("===================================================");
                System.out.println("");
                header("ubahbuku.txt");
                System.out.println("===================================================\nPilih buku yang akan diubah : ");
                for (int i= 0; i<jumlahbuku; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpustakaan[i].getJudul() + "\t| " + perpustakaan[i].getPengarang());
                }
                int ubahbuku = baca.nextInt();
                System.out.print("input judul buku : \n> ");
                String judul = baca.next();
                perpustakaan[ubahbuku - 1].setJudul(judul);
                System.out.print("input pengarang buku : \n> ");
                String pengarang = baca.next();
                perpustakaan[ubahbuku - 1].setPengarang(pengarang);

                int hal = perpustakaan[ubahbuku - 1].getJumlahhalaman();
                System.out.print("input jumlah halaman buku : \n> ");
                int halaman = baca.nextInt();
                perpustakaan[ubahbuku - 1].setJumlahhalaman(halaman);
                jumlahhalaman = jumlahhalaman - hal + halaman;
                if (perpustakaan[ubahbuku - 1].getJenisbuku() == "Fiksi") {
                    jhfiksi = jhfiksi - hal + perpustakaan[ubahbuku].getJumlahhalaman();
                } else {
                    jhnonfiksi = jhnonfiksi - hal + perpustakaan[ubahbuku].getJumlahhalaman();
                }
            } else if (pilihan == 3) {
                System.out.print("===================================================");
                System.out.println("");
                header("hapusbuku.txt");
                System.out.println("===================================================\nPilih buku yang akan dihapus : ");
                for (int i=0; i<jumlahbuku; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpustakaan[i].getJudul() + "\t| " + perpustakaan[i].getPengarang());
                }
                int hapusbuku = baca.nextInt();
                for (int i=hapusbuku; i<jumlahbuku; i++) {
                    perpustakaan[i - 1] = perpustakaan[i];
                }

                jumlahhalaman -= perpustakaan[hapusbuku].getJumlahhalaman();
                jumlahbuku -= 1;
                if (perpustakaan[hapusbuku].getJenisbuku() == "fiksi") {
                    fiksi -= 1;
                    jhfiksi -= perpustakaan[hapusbuku].getJumlahhalaman();
                } else {
                    nonfiksi -= 1;
                    jhnonfiksi -= perpustakaan[hapusbuku].getJumlahhalaman();
                }
            } else {
                pil = 0;
            }
        } while (pil != 0);
        String path = "data.txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0; i<jumlahbuku; i++) {
                int a = i + 1;
                bw.write("Buku ke : [" + Integer.toString(a) + "]");
                bw.newLine();
                bw.write("Judul : " + perpustakaan[i].getJudul());
                bw.newLine();
                bw.write("Pengarang : " + perpustakaan[i].getPengarang());
                bw.newLine();
                bw.write("Jumlah Halaman : " + Integer.toString(perpustakaan[i].getJumlahhalaman()));
                bw.newLine();
                bw.write("Jenis Buku : " + perpustakaan[i].getJenisbuku());
                bw.newLine();
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
        }
    }
public static void header(String judul) {
        File file = new File(judul);
        String encoding = "utf-8";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding)) {
            int data = isr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = isr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    private static class fiksi extends Buku {

        public fiksi() {
        }
    }

    private static class nonfiksi extends Buku {

        public nonfiksi() {
        }
    }
}