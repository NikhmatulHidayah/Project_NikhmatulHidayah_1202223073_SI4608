public abstract class Data_Buku {
    public String Judul_Buku;
    public String Nama_Pengarang;

    public Data_Buku(String Judul_Buku, String Nama_Pengarang){
        this.Judul_Buku = Judul_Buku;
        this.Nama_Pengarang = Nama_Pengarang;
    }

    void displayInfo(){
        System.out.println("Judul Buku: "+ Judul_Buku);
        System.out.println("Nama Pengarang: "+ Nama_Pengarang);
    }

    abstract void tatacaraPeminjaman();
}
