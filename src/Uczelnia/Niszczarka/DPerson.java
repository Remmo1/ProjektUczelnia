package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import java.util.ArrayList;

public class DPerson implements Destroyer {

    @Override
    public void UsunSTR(ArrayList<Osoba> osoby, String szukana, String parametr) {

        szukana = szukana.toLowerCase();

        switch (parametr) {
            case "n" -> {
                for (Osoba o:
                    osoby) {
                    if (o.getNazwisko().toLowerCase().equals(szukana)) {
                        osoby.remove(o);
                        break;
                    }
                }
            }

            case "i" -> {
                for (Osoba o :
                        osoby) {
                    if (o.getImie().toLowerCase().equals(szukana)) {
                        osoby.remove(o);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void UsunInt(ArrayList<Osoba> osoby, int szukana, String parametr) {
        for (Osoba o :
                osoby) {
            if (o.getWiek() == szukana) {
                osoby.remove(o);
                break;
            }
        }
    }
}
