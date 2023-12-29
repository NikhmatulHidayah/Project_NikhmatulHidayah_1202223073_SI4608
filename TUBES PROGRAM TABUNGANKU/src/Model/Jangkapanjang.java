package Model;

public class Jangkapanjang extends SavingsAccount{
    private String namaTabungan;
    private String waktuPemasukan;
    private String waktuPenarikan;
    private long saldo;

    
    public Jangkapanjang(int idTabungan, String jenisTabungan, String namaTabungan, String waktuPemasukan, String waktuPenarikan, long saldo) {
            super(idTabungan, jenisTabungan);
            this.namaTabungan = namaTabungan;
            this.waktuPemasukan = waktuPemasukan;
            this.waktuPenarikan = waktuPenarikan;
            this.saldo = saldo;
    }
    
    
    public void setNamaTabungan(String namaTabungan){
        this.namaTabungan = namaTabungan;
    }
    public String getNamaTabungan(){
        return namaTabungan;
    }

    
    public void setWaktuPemasukan(String waktuPemasukan){
        this.waktuPemasukan = waktuPemasukan;
    }
    public String getWaktuPemasukan(){
        return waktuPemasukan;
    }

    
    public void setWaktuPenarikan(String waktuPenarikan){
        this.waktuPenarikan = waktuPenarikan;
    }
    public String getWaktuPenarikan(){
        return waktuPenarikan;
    }


    public void setSaldo(long saldo){
        this.saldo = saldo;
    }
    public long getSaldo(){
        return saldo;
    }
    
    
    public void updateSaldo(long amount) {
        this.saldo += amount;
    }
    

    @Override
    public String info() {
        return super.info() + "\nNama Tabungan: " + getNamaTabungan() +
                "\nWaktu Pemasukan: " + getWaktuPemasukan() +
                "\nWaktu Penarikan: " + getWaktuPenarikan() +
                "\nSaldo: " + getSaldo();
    }
    
}
