
public class Perpustakaan {
    
}
class Buku extends Perpustakaan{
    private String judul, pengarang, jenisbuku;
    private int jumlahhalaman;

    public Buku(){
        judul="DEFAULT";
        pengarang="DEFAULT";
        jenisbuku="DEFAULT";
        jumlahhalaman=0;
    }
    public Buku(String jd, String p, String jb, int jh){
        judul=jd;
        pengarang=p;
        jenisbuku=jb;
        jumlahhalaman=jh;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getJenisbuku() {
        return jenisbuku;
    }

    public void setJenisbuku(String jenisbuku) {
        this.jenisbuku = jenisbuku;
    }

    public int getJumlahhalaman() {
        return jumlahhalaman;
    }

    public void setJumlahhalaman(int jumlahhalaman) {
        this.jumlahhalaman = jumlahhalaman;
    }
    public void print() {
        System.out.println("Judul = " + judul + "\nPengarang = " + pengarang+ "\nJumlah Halaman = " + jumlahhalaman + "\nJenis buku = " + jenisbuku);
    }
    public String printnew() {
        return "Judul = " + judul + "\n \t| Pengarang = " + pengarang+ "\n \t| Jumlah halaman = " + jumlahhalaman + "\n \t| Jenis = " + jenisbuku;
    }
class Fiksi extends Buku{

    private String bukufiksi;
    
    public Fiksi() {
        super();
        bukufiksi = "Fiksi";
    }

    public Fiksi(String jd, String p, String jb, int jh, String bf) {
        super(jd, p, jb, jh);
        bukufiksi = bf;
    }

    public String getBukufiksi() {
        return bukufiksi;
    }

    public void setBukufiksi(String bf) {
        bukufiksi = bf;
    }
    
}
class NonFiksi extends Buku{
    private String bukunonfiksi;

    public NonFiksi() {
        super();
        bukunonfiksi = "Non Fiksi";
    }

    public NonFiksi(String jd, String p, String jb, int jh, String bnf) {
        super(jd, p, jb, jh);
        bukunonfiksi = bnf;
    }

    public String getBukunonfiksi() {
        return bukunonfiksi;
    }

    public void setBukunonfiksi(String bnf) {
        bukunonfiksi = bnf;
    }
}
}