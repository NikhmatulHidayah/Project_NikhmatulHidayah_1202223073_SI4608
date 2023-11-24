public class Mahasiswa extends Data_Buku {
    public String NIM;
    public String Nama;
    public String Prodi;
    public String Fakultas;

    public Mahasiswa(String Judul_Buku, String Nama_Pengarang, String nim, String nama, String prodi, String fakultas) {
        super(Judul_Buku, Nama_Pengarang);
        this.NIM = nim;
        this.Nama = nama;
        this.Prodi = prodi;
        this.Fakultas = fakultas;
    }

    @Override
    void displayInfo() {
        System.out.println("\nMahasiswa");
        System.out.println("NIM: " + NIM);
        System.out.println("Nama: " + Nama);
        System.out.println("Prodi: " + Prodi);
        System.out.println("Fakultas: " + Fakultas);
        System.out.println("Judul Buku: " + Judul_Buku);
        System.out.println("Nama Pengarang: " + Nama_Pengarang);
    }

    @Override
	void tatacaraPeminjaman() {
		System.out.println("\nTata cara peminjaman buku untuk mahasiswa");
        System.out.println("1. Buku Harus dikembalikan sebelum hari ke-7 peminjaman");
        System.out.println("2. Buku dikembalikan dalam kondisi seperti awal peminjaman");
        System.out.println("3. Tunjukkan kartu mahasiswa kepada pengawas perpustakaan");

	}

    

	




}
