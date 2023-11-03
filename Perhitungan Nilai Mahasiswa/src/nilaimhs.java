//nama : nikhmatul hidayah
//nim : 1202223073
//kelas : si-46-08

import java.util.Scanner;
public class nilaimhs {
    public static void main (String[] args){
        //inisialisasi scanner dan fungsi hitung nilai
        Scanner masukan = new Scanner(System.in);
        hitungnilai hitungNilaibro = new hitungnilai();

        //inputan nama, nim, dan nilai
        System.out.print("Masukkan Nama: ");
        String nama = masukan.nextLine();

        System.out.print("Masukkan Nim: ");
        int nim = masukan.nextInt();

        System.out.print("Masukkan Nilai Tubes: ");
        double nilaitubes = masukan.nextDouble();

        System.out.print("Masukkan Nilai Quiz: ");
        double nilaiquiz = masukan.nextDouble();

        System.out.print("Masukkan Nilai Tugas: ");
        double nilaitugas = masukan.nextDouble();

        System.out.print("Masukkan Nilai UTS: ");
        double nilaiuts = masukan.nextDouble();

        System.out.print("Masukkan Nilai UAS: ");
        double nilaiuas = masukan.nextDouble();

        //output nama, nim, dan nilai
        System.out.println("\nNama : " + nama);
        System.out.println("Nim : " + nim);
        System.out.println("Nilai Mata Kuliah Pemrograman Berorientasi Objek : " + hitungNilaibro.hitung(nilaitubes, nilaiquiz, nilaitugas, nilaiuts, nilaiuas));
    }
}
