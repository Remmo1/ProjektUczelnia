package Uczelnia.PozostaleKlasy;

import Uczelnia.KlasyAbstrakcyjne.Pracownik_Uczelni;

import java.io.Serial;

public class Pracownik_Administracyjny extends Pracownik_Uczelni {

    @Serial
    private static final long serialVersionUID = 2473253563130946543L;
    // składowe
    private int LN;             // liczba nadgodzin

    // konstruktor
    public Pracownik_Administracyjny(String imie, String nazwisko, String pesel, int wiek, String plec, String stanowisko, int staz, double pensja, int ln) {
        super(imie, nazwisko, pesel, wiek, plec, stanowisko, staz, pensja);
        this.LN = ln;
    }

    // get i set:

    public int getLN() { return LN; }

    public void setLN(int LN) { this.LN = LN; }

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
                " nadgodzin: " + getLN() + "\n");
    }
}