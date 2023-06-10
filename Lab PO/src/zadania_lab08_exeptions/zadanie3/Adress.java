package zadania_lab08_exeptions.zadanie3;

public class Adress{
    String City, Street, postCode;
    int houseNo;

    public Adress(String Street, String City, int houseNo, String postCode) throws NieprawidlowyAdresExepction{
        String exception = "";
        if(Street == null) exception += " Ulica nie może być nullem! ";
        else this.Street = Street;

        if(City == null) exception += " Miasto nie może być nullem! ";
        else this.City = City;

        if(houseNo <= 0) exception += " Numer domu nie może być mniejszy od 0! ";
        else this.houseNo = houseNo;

        if(postCode == null) exception += " Kod pocztowy nie może być nullem! ";
        else this.postCode = postCode;

        if(!exception.equals("")) throw new NieprawidlowyAdresExepction(exception);
    }
}
