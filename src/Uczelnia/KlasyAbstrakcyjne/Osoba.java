package Uczelnia.KlasyAbstrakcyjne;

import java.io.Serial;
import java.io.Serializable;

public abstract class Osoba implements Serializable {

    @Serial
    private static final long serialVersionUID = 1436359584690951919L;
    // składowe:
    private String Imie;
    private String Nazwisko;
    private String Pesel;
    private int Wiek;
    private String Plec;


    // konstruktor
    public Osoba(String imie, String nazwisko, String pesel, int wiek, String plec) {
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.Pesel = pesel;
        this.Wiek = wiek;
        this.Plec = plec;
    }

    // get i set:

    public String getImie() { return Imie; }
    public String getNazwisko() { return Nazwisko; }
    public int getWiek() { return Wiek; }
    public String getPesel() { return Pesel; }
    public String getPlec() { return Plec; }

    public void setNazwisko(String nazwisko) { Nazwisko = nazwisko; }
    public void setImie(String imie) { Imie = imie; }
    public void setPlec(String plec) { Plec = plec; }
    public void setPesel(String pesel) { Pesel = pesel; }
    public void setWiek(int wiek) { Wiek = wiek; }
}