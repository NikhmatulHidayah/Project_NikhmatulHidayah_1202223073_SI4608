public class Dosen extends Data_Buku {
    public String ID_Dosen;
    public String Nama_Dosen;
    public String Matkul_Diampu;

    public Dosen(String Judul_Buku, String Nama_Pengarang, String idDosen, String namaDosen, String matkulDiampu) {
        super(Judul_Buku, Nama_Pengarang);
        this.ID_Dosen = idDosen;
        this.Nama_Dosen = namaDosen;
        this.Matkul_Diampu = matkulDiampu;
    }

    @Override
    void displayInfo() {
        System.out.println("\nDosen");
        System.out.println("ID Dosen: " + ID_Dosen);
        System.out.println("Nama Dosen: " + Nama_Dosen);
        System.out.println("Mata Kuliah Diampu: " + Matkul_Diampu);
        System.out.println("Judul Buku: " + Judul_Buku);
        System.out.println("Nama Pengarang: " + Nama_Pengarang);
    }

    @Override
    void tatacaraPeminjaman() {
        System.out.println("\nTata cara peminjaman buku untuk dosen");
        System.out.println("1. Buku Harus dikembalikan sebelum hari ke-7 peminjaman");
        System.out.println("2. Buku dikembalikan dalam kondisi seperti awal peminjaman");
        System.out.println("3. Tunjukkan kartu dosen kepada pengawas perpustakaan");
    }
}
