package model;

public class Mahasiswa {
    private String nim;
    private String nama;
    private Prodi prodi;

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public Prodi getProdi() {
        return prodi;
    }

    public void setProdi(Prodi prodi) {
        this.prodi = prodi;
    }

    public Mahasiswa(String nim, String nama, Prodi prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }
}
