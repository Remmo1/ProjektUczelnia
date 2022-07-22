package Uczelnia.PozostaleKlasy;

import java.io.Serial;
import java.io.Serializable;

public class Kurs implements Serializable {

    @Serial
    private static final long serialVersionUID = -1458609380138713057L;
    // składowe:
    private String Nazwa;
    private int ECTS;
    private Pracownik_Badawczo_Dydaktyczny Prowadzacy;

    // konstruktor:
    public Kurs(String nazwa, int ects, Pracownik_Badawczo_Dydaktyczny prowadzacy) {
        this.Nazwa = nazwa;
        this.ECTS = ects;
        this.Prowadzacy = prowadzacy;
    }

    // get i set

    public String getNazwa() { return Nazwa; }
    public int getECTS() { return ECTS; }
    public String getProwadzacyN() { return Prowadzacy.getNazwisko(); }

    public void setNazwa(String nazwa) { Nazwa = nazwa; }
    public void setECTS(int ECTS) { this.ECTS = ECTS; }
    public void setProwadzacy(Pracownik_Badawczo_Dydaktyczny prowadzacy) { Prowadzacy = prowadzacy; }

    // pokaż imię i nazwisko prowadzącego:
    public String PokazProwadzacego() {
        return Prowadzacy.getImie() + " " + Prowadzacy.getNazwisko();
    }

    // pokaż co to za kurs:
    @Override
    public String toString() {

        return "Nazwa: " + getNazwa() +
                " ECTS: " + getECTS() +
                " Prowadzący: " + PokazProwadzacego() + "\n";
    }
}