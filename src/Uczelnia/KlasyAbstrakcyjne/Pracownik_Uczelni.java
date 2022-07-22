package Uczelnia.KlasyAbstrakcyjne;

import java.io.Serial;

public abstract class Pracownik_Uczelni extends Osoba {

    @Serial
    private static final long serialVersionUID = -5621464268174057236L;
    // składowe:
    private String Stanowisko;
    private int Staz;
    private double Pensja;

    // konstruktor
    public Pracownik_Uczelni(String imie, String nazwisko, String pesel, int wiek, String plec, String stanowisko, int staz, double pensja) {
        super(imie, nazwisko, pesel, wiek, plec);
        this.Stanowisko = stanowisko;
        this.Staz = staz;
        this.Pensja = pensja;
    }

    // get i set:


    public double getPensja() { return Pensja; }
    public int getStaz() { return Staz; }
    public String getStanowisko() { return Stanowisko; }

    public void setStaz(int staz) { Staz = staz; }
    public void setStanowisko(String stanowisko) { Stanowisko = stanowisko; }
    public void setPensja(double pensja) { Pensja = pensja; }
}