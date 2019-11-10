package tugas5;

public class perpustakaan {
    
}

class buku extends perpustakaan {
    private String judul, pengarang, jenis;
    private int halaman;

    public buku() {
        judul = "kosong";
        pengarang = "kosong";
        halaman = 0;
        jenis = "kosong";
    }

    public buku(String judul, String pengarang, String jenis, int halaman) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.halaman = halaman;
        this.jenis = jenis;
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

    public int getHalaman() {
        return halaman;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }
    
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public void print() {
        System.out.println("judul = " + judul + "\npengarang = " + pengarang+ "\nhalaman = " + halaman + "\njenis = " + jenis);
    }
    
    public String printt() {
        return "judul = " + judul + "\n | pengarang = " + pengarang+ "\n | halaman = " + halaman + "\n | jenis = " + jenis;
    }
    
    public String jarak() {
        return "                                                                   "
                + "";
    }
    
}

class nonfiksi extends buku {
    private String jenisBuku;

    public nonfiksi() {
        super();
        jenisBuku = "Non Fiksi";
    }

    public nonfiksi(String jenisBuku, String judul, String pengarang, String jenis, int halaman) {
        super(judul, pengarang, jenis, halaman);
        this.jenisBuku = jenisBuku;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }
    
    
}

class fiksi extends buku {
    private String jenisBuku;
    
    public fiksi() {
        super();
        jenisBuku = "Fiksi";
    }

    public fiksi(String jenisBuku, String judul, String pengarang, String jenis, int halaman) {
        super(judul, pengarang, jenis, halaman);
        this.jenisBuku = jenisBuku;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }
    
}
