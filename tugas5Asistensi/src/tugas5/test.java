package tugas5;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner baca = new Scanner(System.in);
        buku[] perpus = new buku[10000];
        int n = 3;
        double jumlahHal = 600;
        double halfiksi = 0;
        double halnonfiksi = 0;
        double sd = 0;
        double sdf = 0;
        double sdnf = 0;
        Random rand = new Random();
        int fiksi = 0;
        int nonfiksi = 0;

        for (int i = 0; i < perpus.length; i++) {
            int coinflip = rand.nextInt(2) + 1;
            if (coinflip == 1) {
                perpus[i] = new fiksi();
            }
            if (coinflip == 2) {
                perpus[i] = new nonfiksi();
            }
        }

        for (int i = 0; i < 3; i++) {
            int coinflip = rand.nextInt(2) + 1;
            if (coinflip == 1) {
                perpus[i] = new buku("Buku awal", "april dong", "fiksi", 200);
                fiksi += 1;
                halfiksi += 200;
            }
            if (coinflip == 2) {
                perpus[i] = new buku("Buku awal", "april dong", "nonfiksi", 200);
                nonfiksi += 1;
                halnonfiksi += 200;
            }
        }

        int pil = 1;
        do {
            pembatas();
            header("PERPUSTAKAAN.txt");
            System.out.println("");
            pembatas();
            System.out.println("[1]. input buku baru\n" + "[2]. modifikisi detail buku\n" + "[3]. hapus buku\n" + "[0]. EXIT");
            pembatas();

            double rata = jumlahHal / n;
            for (int i = 0; i < n; i++) {
                sd = Math.pow((perpus[i].getHalaman() - rata), 2);
            }

            double rataf = halfiksi / fiksi;
            double ratanf = halnonfiksi / nonfiksi;
            for (int i = 0; i < n; i++) {
                if (perpus[i].getJenis() == "fiksi") {
                    sdf = Math.pow((perpus[i].getHalaman() - rataf), 2);
                } else {
                    sdnf = Math.pow((perpus[i].getHalaman() - ratanf), 2);
                }
            }

            System.out.println("Jumlah buku di dalam perpustakaan: " + n + "\nRata-rata halaman buku dalam perpustakaan: " + rata + "\nStandar deviasi halaman buku dalam perpustakaan: " + Math.sqrt(sd / n));
            pembatas();
            System.out.println("Jumlah Buku Fiksi dalam perpustakaan: " + fiksi + "\nRata-rata halaman Buku Fiksi dalam perpustakaan: " + rataf + "\nStandar deviasi halaman Buku Fiksi dalam perpustakaan: " + Math.sqrt(sdf / fiksi));
            pembatas();
            System.out.println("Jumlah Buku Non Fiksi dalam perpustakaan : " + nonfiksi + "\nRata-rata halaman Buku Non Fiksi dalam perpustakaan: " + ratanf + "\nStandar deviasi halaman Buku Non Fiksi dalam perpustakaan: " + Math.sqrt(sdnf / nonfiksi));
            pembatas();

            int pilihan = baca.nextInt();
            if (pilihan == 1) {
                pembatas();
                header("bukubaru.txt");
                System.out.println("");
                pembatas();
                n += 1;

                System.out.print("input judul buku : \n> ");
                String judul = baca.next();
                perpus[n - 1].setJudul(judul);
                System.out.print("input pengarang buku : \n> ");
                String pengarang = baca.next();
                perpus[n - 1].setPengarang(pengarang);
                System.out.print("input jumlah halaman buku : \n> ");
                int halaman = baca.nextInt();
                perpus[n - 1].setHalaman(halaman);

                int coinflip = rand.nextInt(2) + 1;
                if (coinflip == 1) {
                    perpus[n - 1] = new buku(judul, pengarang, "fiksi", halaman);
                    fiksi += 1;
                    halfiksi += halaman;
                }
                if (coinflip == 2) {
                    perpus[n - 1] = new buku(judul, pengarang, "nonfiksi", halaman);
                    nonfiksi += 1;
                    halnonfiksi += halaman;
                }

            } else if (pilihan == 2) {
                pembatas();
                header("ubahbuku.txt");
                System.out.println("");
                pembatas();
                System.out.println("Pilih buku yang akan diubah : ");
                for (int i = 0; i < n; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpus[i].getJudul() + "\t| " + perpus[i].getPengarang());
                }
                int ubahbuku = baca.nextInt();
                System.out.print("input judul buku : \n> ");
                String judul = baca.next();
                perpus[ubahbuku - 1].setJudul(judul);
                System.out.print("input pengarang buku : \n> ");
                String pengarang = baca.next();
                perpus[ubahbuku - 1].setPengarang(pengarang);

                int hallama = perpus[ubahbuku - 1].getHalaman();
                System.out.print("input jumlah halaman buku : \n> ");
                int halaman = baca.nextInt();
                perpus[ubahbuku - 1].setHalaman(halaman);
                jumlahHal = jumlahHal - hallama + halaman;
                if (perpus[ubahbuku - 1].getJenis() == "fiksi") {
                    halfiksi = halfiksi - hallama + perpus[ubahbuku].getHalaman();
                } else {
                    halnonfiksi = halnonfiksi - hallama + perpus[ubahbuku].getHalaman();
                }
            } else if (pilihan == 3) {
                pembatas();
                header("hapusbuku.txt");
                System.out.println("");
                pembatas();
                System.out.println("Pilih buku yang akan dihapus : ");
                for (int i = 0; i < n; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpus[i].getJudul() + "\t| " + perpus[i].getPengarang());
                }
                int hapusbuku = baca.nextInt();
                for (int i = hapusbuku; i < n; i++) {
                    perpus[i - 1] = perpus[i];
                }

                jumlahHal -= perpus[hapusbuku].getHalaman();
                n -= 1;
                if (perpus[hapusbuku].getJenis() == "fiksi") {
                    fiksi -= 1;
                    halfiksi -= perpus[hapusbuku].getHalaman();
                } else {
                    nonfiksi -= 1;
                    halnonfiksi -= perpus[hapusbuku].getHalaman();
                }
            } else {
                pil = 0;
            }
        } while (pil != 0);

        String path = "data.txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < n; i++) {
                int a = i + 1;
                bw.write("Buku ke : [" + Integer.toString(a) + "]");
                bw.newLine();
                bw.write("Judul : " + perpus[i].getJudul());
                bw.newLine();
                bw.write("Pengarang : " + perpus[i].getPengarang());
                bw.newLine();
                bw.write("Jumlah Halaman : " + Integer.toString(perpus[i].getHalaman()));
                bw.newLine();
                bw.write("Jenis Buku : " + perpus[i].getJenis());
                bw.newLine();
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
        }
    }

    public static void header(String PERPUSTAKAAN) {
        File file = new File(PERPUSTAKAAN);
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

    public static void pembatas() {
        System.out.println("====================================================================================");
    }
}
