package Uczelnia.PozostaleKlasy;

import Uczelnia.KlasyAbstrakcyjne.Pracownik_Uczelni;

import java.io.Serial;

public class Pracownik_Badawczo_Dydaktyczny extends Pracownik_Uczelni {

    @Serial
    private static final long serialVersionUID = 5909007863216731102L;
    // składowe:
    double DN;         // dorobek naukowy

    // konstruktor:
    public Pracownik_Badawczo_Dydaktyczny(String imie, String nazwisko, String pesel, int wiek, String plec, String stanowisko, int staz, double pensja, double dn) {
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, staz, pensja);
        this.DN = dn;
    }

    // get i set

    public double getDN() { return DN; }

    public void setDN(double DN) { this.DN = DN; }

    // pozostałe metody:
    @Override
    public String toString() {
        return ( "Imię: " + getImie() +
                " Nazwisko: " + getNazwisko() +
                " Pesel: " + getPesel() +
                " Wiek: " + getWiek() +
                " Płeć: " + getPlec() +
                " Stanowisko: " + getStanowisko() +
                " Staż w latach: " + getStaz() +
                " Pensja: " + getPensja() +
                " Dorobek naukowy: " + getDN() + "\n" );
    }
}