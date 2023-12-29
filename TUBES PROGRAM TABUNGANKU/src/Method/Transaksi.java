package Method;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaksi {
    private String deskripsi;
    private Date waktu;

    private static List<Transaksi> transaksiList = new ArrayList<>();

    public Transaksi(String deskripsi) {
        this.deskripsi = deskripsi;
        this.waktu = new Date();
        transaksiList.add(this);
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public Date getWaktu() {
        return waktu;
    }

    public String formatWaktu() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(waktu);
    }

    public static List<Transaksi> getTransaksiList() {
        return transaksiList;
    }
}
