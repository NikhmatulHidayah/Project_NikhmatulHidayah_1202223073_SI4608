import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Siapa yang akan meminjam? (Mahasiswa/Dosen): ");
        String jenisPeminjam = scanner.nextLine();

        if (jenisPeminjam.equals("Mahasiswa")) {
            System.out.print("NIM Mahasiswa: ");
            String nimMahasiswa = scanner.nextLine();

            System.out.print("Nama Mahasiswa: ");
            String namaMahasiswa = scanner.nextLine();

            System.out.print("Prodi Mahasiswa: ");
            String prodiMahasiswa = scanner.nextLine();

            System.out.print("Fakultas Mahasiswa: ");
            String fakultasMahasiswa = scanner.nextLine();

            System.out.print("Judul Buku: ");
            String judulBukuMahasiswa = scanner.nextLine();
            
            System.out.print("Nama Pengarang: ");
            String namaPengarangMahasiswa = scanner.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(judulBukuMahasiswa, namaPengarangMahasiswa, nimMahasiswa, namaMahasiswa, prodiMahasiswa, fakultasMahasiswa);
            mahasiswa.displayInfo();
            mahasiswa.tatacaraPeminjaman();
        } 
        else if (jenisPeminjam.equals("Dosen")) {
            System.out.print("ID Dosen: ");
            String idDosen = scanner.nextLine();

            System.out.print("Nama Dosen: ");
            String namaDosen = scanner.nextLine();

            System.out.print("Mata Kuliah Diampu: ");
            String matkulDiampu = scanner.nextLine();

            System.out.print("Judul Buku: ");
            String judulBukuDosen = scanner.nextLine();

            System.out.print("Nama Pengarang: ");
            String namaPengarangDosen = scanner.nextLine();

            Dosen dosen = new Dosen(judulBukuDosen, namaPengarangDosen,idDosen, namaDosen, matkulDiampu);
            dosen.displayInfo();
            dosen.tatacaraPeminjaman();
        } 
        else {
            System.out.println("Jenis peminjam tidak valid.");
        }

        scanner.close();
    }
}
