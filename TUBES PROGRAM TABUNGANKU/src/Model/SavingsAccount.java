package Model;

public class SavingsAccount {
    private int idTabungan;
    private String jenisTabungan;

    public SavingsAccount(int idTabungan, String jenisTabungan) {
        this.idTabungan = idTabungan;
        this.jenisTabungan = jenisTabungan;
    }

    public void setIdTabungan(int idTabungan) {
        this.idTabungan = idTabungan;
    }

    public int getIdTabungan() {
        return idTabungan;
    }

    public void setJenisTabungan(String jenisTabungan) {
        this.jenisTabungan = jenisTabungan;
    }

    public String getJenisTabungan() {
        return jenisTabungan;
    }

    public String info() {
        return "Id Tabungan: " + idTabungan + "\nJenis Tabungan: " + jenisTabungan;
    }
}
