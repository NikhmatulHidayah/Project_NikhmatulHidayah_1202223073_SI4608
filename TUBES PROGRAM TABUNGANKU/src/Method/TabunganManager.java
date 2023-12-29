package Method;
import database.DBTables;

import java.io.FileWriter;
import java.io.IOException;

import Model.Jangkapanjang;
import Model.Jangkapendek;
import Model.SavingsAccount;

public class TabunganManager {
    private DBTables db = new DBTables();

    public TabunganManager(DBTables db) {
        this.db = db;
    }

    public void tambahTabungan(SavingsAccount tabungan) {
        if (tabungan instanceof Jangkapanjang) {
            db.dataJangkaPanjang.add((Jangkapanjang) tabungan);
            new Transaksi("Menambahkan Tabungan Jangka Panjang dengan id : " + String.valueOf(tabungan.getIdTabungan()));
        } else if (tabungan instanceof Jangkapendek) {
            db.dataJangkaPendek.add((Jangkapendek) tabungan);
            new Transaksi("Menambahkan Tabungan Jangka Pendek dengan id : " + String.valueOf(tabungan.getIdTabungan()));
        }
    }
    

    public void tambahSaldo(int idTabungan, long jumlah) {
        Jangkapanjang jangkaPanjang = db.findJangkaPanjangById(idTabungan);
        if (jangkaPanjang != null) {
            jangkaPanjang.setSaldo(jangkaPanjang.getSaldo() + jumlah);
            System.out.println("Berhasil Menambahkan saldo ke Tabungan Jangka Panjang dengan id: " + idTabungan);
            new Transaksi("Menambahkan saldo ke Tabungan Jangka Panjang dengan id " + idTabungan + ": " + jumlah);
        } else {
            Jangkapendek jangkaPendek = db.findJangkaPendekById(idTabungan);
            if (jangkaPendek != null) {
                jangkaPendek.setSaldo(jangkaPendek.getSaldo() + jumlah);
                System.out.println("Berhasil Menambahkan saldo ke Tabungan Jangka Pendek dengan id: " + idTabungan);
                new Transaksi("Menambahkan saldo ke Tabungan Jangka Pendek dengan id " + idTabungan + ": " + jumlah);
            } else {
                System.out.println("Tabungan dengan ID " + idTabungan + " tidak ditemukan.");
            }
        }
    }
    
    

    public void tarikUang(int idTabungan, long jumlah) {
        Jangkapanjang jangkaPanjang = db.findJangkaPanjangById(idTabungan);
        if (jangkaPanjang != null) {
            if (jangkaPanjang.getSaldo() >= jumlah) {
                jangkaPanjang.setSaldo(jangkaPanjang.getSaldo() - jumlah);
                new Transaksi("Menarik uang dari Tabungan Jangka Panjang dengan id " + idTabungan + ": " + jumlah);
            } 
            else {
                System.out.println("Saldo tidak mencukupi untuk menarik uang dari Tabungan dengan id " + idTabungan);
            }
        } 
        else {
            Jangkapendek jangkaPendek = db.findJangkaPendekById(idTabungan);
            if (jangkaPendek != null) {
                if (jangkaPendek.getSaldo() >= jumlah) {
                    jangkaPendek.setSaldo(jangkaPendek.getSaldo() - jumlah);
                    new Transaksi("Menarik uang dari Tabungan Jangka Pendek dengan id " + idTabungan + ": " + jumlah);
                } 
                else {
                    System.out.println("Saldo tidak mencukupi untuk menarik uang dari tabungan " + idTabungan);
                }
            } 
            else {
                System.out.println("Tabungan dengan ID " + idTabungan + " tidak ditemukan.");
            }
        }
    }

    public void tampilkanTransaksi() {
        System.out.println("=== Daftar Transaksi ===");
        for (Transaksi transaksi : Transaksi.getTransaksiList()) {
            System.out.println(transaksi.formatWaktu() + " - " + transaksi.getDeskripsi());
        }
    }

    public void buatCatatanTxt() {
        try {
            FileWriter writer = new FileWriter("catatan_tabungan.txt");

            for (Jangkapanjang tabunganPanjang : db.dataJangkaPanjang) {
                writer.write(tabunganPanjang.info() + "\n");
            }

            for (Jangkapendek tabunganPendek : db.dataJangkaPendek) {
                writer.write(tabunganPendek.info() + "\n");
            }

            writer.write("\n=== Daftar Transaksi ===\n");
            for (Transaksi transaksi : Transaksi.getTransaksiList()) {
                writer.write(transaksi.formatWaktu() + " - " + transaksi.getDeskripsi() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error dalam membuat catatan_tabungan.txt: " + e.getMessage());
        }
    }
}
