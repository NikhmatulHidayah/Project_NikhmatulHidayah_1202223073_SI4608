import java.util.Scanner;

import Method.TabunganManager;
import Model.Jangkapanjang;
import Model.Jangkapendek;
import Model.SavingsAccount;
import Model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.DBTables;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        DBTables db = new DBTables();
        TabunganManager tabunganManager = new TabunganManager(db);
        Scanner inputdata = new Scanner(System.in);

        System.out.println("\n========== Selamat Datang di Tabunganku ==========");
        System.out.print("Masukkan Id: ");
        String idUser = inputdata.nextLine();
        System.out.print("Masukkan Nama: ");
        String namaUser = inputdata.nextLine();
        System.out.print("Masukkan Nomor HP: ");
        String noHpUser = inputdata.nextLine();

        User userobject = new User(idUser, namaUser, noHpUser);
        userobject.Register();

        while (true) {
            System.out.println("\n===================== Menu =======================");
            System.out.println("1. Menambahkan Tabungan Baru");
            System.out.println("2. Menambahkan uang kedalam Tabungan");
            System.out.println("3. Menarik Uang di Tabungan");
            System.out.println("4. Tampil semua tabungan");
            System.out.println("5. Tampil semua transaksi");
            System.out.println("6. Membuat file txt");
            System.out.println("7. Keluar");
            System.out.print("Masukkan pilihan anda: ");
            int pilihan = inputdata.nextInt();
            inputdata.nextLine();

            switch (pilihan) {

                case 1:
                    System.out.println("=========================================");
                    try{
                        System.out.print("Masukkan ID Tabungan: ");
                        int id_tabungan = inputdata.nextInt();
                        inputdata.nextLine();

                        while (true) {
                            System.out.print("Masukkan Jenis Tabungan(Jangka Panjang/Jangka Pendek): ");
                            String jenis_tabungan = inputdata.nextLine();

                            if (jenis_tabungan.equals("Jangka Panjang") || jenis_tabungan.equals("Jangka Pendek")) {
                                System.out.print("Masukkan Nama Tabungan: ");
                                String nama_tabungan = inputdata.nextLine();

                                System.out.print("Masukkan Waktu Pemasukan (dd-mm-yyyy): ");
                                String waktu_pemasukan = inputdata.nextLine();
                                System.out.print("Masukkan Waktu Penarikan (dd-mm-yyyy): ");
                                String waktu_penarikan = inputdata.nextLine();

                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                Date tanggalMulai = dateFormat.parse(waktu_pemasukan);
                                Date tanggalSelesai = dateFormat.parse(waktu_penarikan);
                                long lamaHari = Math.abs(tanggalSelesai.getTime() - tanggalMulai.getTime()) / (24 * 60 * 60 * 1000);

                                if (jenis_tabungan.equalsIgnoreCase("Jangka Panjang")) {
                                    if (lamaHari < 365) {
                                        System.out.println("Tabungan Jangka Panjang harus memiliki minimal 365 hari untuk dapat ditarik.");
                                        break;
                                    }
                                }

                                System.out.print("Masukkan Saldo: ");
                                long saldo_tabungan = inputdata.nextLong();

                                SavingsAccount tabungan;
                                if (jenis_tabungan.equalsIgnoreCase("Jangka Panjang")) {
                                    tabungan = new Jangkapanjang(id_tabungan, jenis_tabungan, nama_tabungan, waktu_pemasukan, waktu_penarikan, saldo_tabungan);
                                } 
                                else if (jenis_tabungan.equalsIgnoreCase("Jangka Pendek")) {
                                    tabungan = new Jangkapendek(id_tabungan, jenis_tabungan, nama_tabungan, waktu_pemasukan, waktu_penarikan, saldo_tabungan);
                                } 
                                else {
                                    System.out.println("Jenis tabungan tidak valid!");
                                    break;
                                }

                                tabunganManager.tambahTabungan(tabungan);
                                System.out.println("===========================================");
                                System.out.println("Berhasil membuat Tabungan " + jenis_tabungan);
                                break;
                                
                            } 
                            else {
                                System.out.println("Pilihan tidak valid!");
                                continue;
                            }
                        }
                        break;
                    }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Masukkan ID dengan format angka.");
                        inputdata.nextLine(); 
                    }
                    

                case 2:
                    System.out.print("Masukkan ID Tabungan: ");
                    int id_tabungan_deposit = inputdata.nextInt();
                    inputdata.nextLine();
                    System.out.print("Masukkan Jumlah Uang yang Akan Dimasukkan: ");
                    long jumlah_deposit = inputdata.nextLong();
                    tabunganManager.tambahSaldo(id_tabungan_deposit, jumlah_deposit);
                    break;

                case 3:
                    System.out.print("Masukkan ID Tabungan: ");
                    int id_tabungan_withdraw = inputdata.nextInt();
                    inputdata.nextLine();
                    System.out.print("Masukkan Jumlah Uang yang Akan Ditarik: ");
                    long jumlah_withdraw = inputdata.nextLong();
                
                    Jangkapanjang jangkaPanjangWithdraw = db.findJangkaPanjangById(id_tabungan_withdraw);
                    if (jangkaPanjangWithdraw != null) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date waktuPenarikan = dateFormat.parse(jangkaPanjangWithdraw.getWaktuPenarikan());
                        
                        long lamaHariWithdraw = Math.abs(new Date().getTime() - waktuPenarikan.getTime()) / (24 * 60 * 60 * 1000);
                
                        if (lamaHariWithdraw < 365) {
                            System.out.println("Tabungan Jangka Panjang yang waktu penarikannya kurang dari 365 hari tidak dapat ditarik.");
                            break;
                        }
                    }
            
                    tabunganManager.tarikUang(id_tabungan_withdraw, jumlah_withdraw);
                    break;

                case 4:
                    System.out.println("\n========= Daftar Tabungan Jangka Panjang =========");
                    if (!db.dataJangkaPanjang.isEmpty()) {
                        for (Jangkapanjang tabungan_1 : db.dataJangkaPanjang) {
                            System.out.println(tabungan_1.info());
                        }
                    } 
                    else {
                        System.out.println("Data Tabungan Jangka Panjang Kosong");
                    }
                    
                    System.out.println("\n========= Daftar Tabungan Jangka Pendek =========");
                    if (!db.dataJangkaPendek.isEmpty()) {
                         for (Jangkapendek tabungan_2 : db.dataJangkaPendek) {
                            System.out.println(tabungan_2.info());
                        }
                    } 
                    else {
                        System.out.println("Data Tabungan Jangka Pendek Kosong");
                    }
                    break;
                
                
                case 5:
                    tabunganManager.tampilkanTransaksi();
                    break;

                case 6:
                    tabunganManager.buatCatatanTxt();
                    System.out.println("Catatan telah berhasil dibuat.");
                    break;

                case 7:
                    inputdata.close();
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid!");
            }  
        }
    }
}
