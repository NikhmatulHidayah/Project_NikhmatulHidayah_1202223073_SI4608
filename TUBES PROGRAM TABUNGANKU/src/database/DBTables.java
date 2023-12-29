package database;
import java.util.ArrayList;

import Model.Jangkapanjang;
import Model.Jangkapendek;

public class DBTables {
    public ArrayList<Jangkapanjang> dataJangkaPanjang = new ArrayList<>();
    public ArrayList<Jangkapendek> dataJangkaPendek = new ArrayList<>();
    

    public Jangkapanjang findJangkaPanjangById(int idTabungan) {
        for (Jangkapanjang jangkaPanjang : dataJangkaPanjang) {
            if (jangkaPanjang.getIdTabungan() == idTabungan) {
                return jangkaPanjang;
            }
        }
        return null;
    }

    public Jangkapendek findJangkaPendekById(int idTabungan) {
        for (Jangkapendek jangkaPendek : dataJangkaPendek) {
            if (jangkaPendek.getIdTabungan() == idTabungan) {
                return jangkaPendek;
            }
        }
        return null;
    }
    
}
