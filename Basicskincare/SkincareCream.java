package PEWARIS2;

public class SkincareCream extends Basicskincare{
    public String Malam;
    public String Pagi;

    void CaraPengunaan() {
        System.out.println("cara penggunaan Cream pagi/malam"); 
            } 

    @Override
    void Carabayar() {
        System.out.println("diskon jika memakai bank tertentu"); 
        super.Carabayar();
    }


}
