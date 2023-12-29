package Model;

public class User {
    private String idUser;

    public String getIdUser(){
        return idUser;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    private String namaUser;

    public String getNamaUser(){
        return namaUser;
    }

    public void setNamaUser(String namaUser){
        this.namaUser = namaUser;
    }

    private String noHpUser;

    public String getNoHpUser(){
        return noHpUser;
    } 

    public void setNoHpUser(String noHpUser){
        this.noHpUser = noHpUser;
    }

    public User(String idUser, String namaUser, String noHpUser){
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.noHpUser = noHpUser;
    }

    public void Register(){
        System.out.println("==================================================");
        System.out.println("Halo " + namaUser + "!");
        System.out.println("Id: " + idUser);
        System.out.println("Nomor HP: " + noHpUser);
    }

}
