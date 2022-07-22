package Uczelnia.PozostaleKlasy;

import Uczelnia.KlasyAbstrakcyjne.Osoba;

import java.io.Serial;
import java.util.ArrayList;

public class Student extends Osoba {

    @Serial
    private static final long serialVersionUID = -903188403594335814L;
    // składowe:
    private int NR;             // nr indeksu
    private boolean CE;         // czy erasmus
    private boolean IS;         // pierwszy stopień jeśli true, inaczej drugi
    private boolean St;         // stacjonarnie jesśli true zaocznie jeśli false

    // lista kursów:
    private final ArrayList <Kurs> Lista;

    // konstruktor
    public Student(String imie, String nazwisko, String pesel, int wiek, String plec, int nr, boolean ce, boolean is, boolean st, ArrayList<Kurs> lista) {
        super(imie, nazwisko, pesel, wiek, plec);
        this.NR = nr;
        this.CE = ce;
        this.IS = is;
        this.St = st;
        this.Lista = lista;
    }

    // get i set

    public int getNR() { return NR; }
    public boolean getCE() { return CE; }
    public boolean getIS() { return IS; }
    public boolean getSt() { return St; }
    public ArrayList<Kurs> getLista() { return Lista; }

    public void setNR(int NR) { this.NR = NR; }
    public void setCE(boolean CE) { this.CE = CE; }
    public void setIS(boolean IS) { this.IS = IS; }
    public void setSt(boolean st) { St = st; }

    // pozostałe metody:
    @Override
    public String toString() {
        return ( "Imię: " + getImie() +
                " Nazwisko: " + getNazwisko() +
                " Pesel: " + getPesel() +
                " Wiek: " + getWiek() +
                " Płeć: " + getPlec() +
                " Numer indeksu: " + getNR() +
                " Czy bierze udział w Erasmus: " + getCE() + " ");
    }

    public String DodatkoweOStudencie() {

        String s = getIS() ? "Stopień studiów: I" : "Stopień studiów: II";
        String s2 = getSt() ? " Studiuje stacjonarnie" : " Studiuje zaocznie";
        StringBuilder s3 = new StringBuilder(" ** Kursy: ");

        for (Kurs k :
                Lista) {
            s3.append(k.getNazwa()).append(" ").append(k.getECTS()).append(" ").append(k.PokazProwadzacego()).append(", ");
        }

        return s + s2 + s3;
    }
}