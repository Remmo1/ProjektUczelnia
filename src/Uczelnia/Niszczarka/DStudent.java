package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Student;

import java.util.ArrayList;

public class DStudent implements Destroyer {
    @Override
    public void UsunSTR(ArrayList<Osoba> osoby, String szukana, String parametr) {
        szukana = szukana.toLowerCase();

        switch (parametr) {
            case "n" -> {
                for (Osoba o:
                        osoby) {
                    if (o instanceof Student) {
                        if (o.getNazwisko().toLowerCase().equals(szukana)) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }

            case "i" -> {
                for (Osoba o :
                        osoby) {
                    if (o instanceof Student) {
                        if (o.getImie().toLowerCase().equals(szukana)) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void UsunInt(ArrayList<Osoba> osoby, int szukana, String parametr) {

        switch (parametr) {

            case "w" -> {
                for (Osoba o :
                        osoby) {
                    if (o instanceof Student) {
                        if (o.getWiek() == szukana) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }

            case "nr" -> {
                for (Osoba o :
                        osoby) {
                    if (o instanceof Student) {
                        if (((Student) o).getNR() == szukana) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }

            case "rs" -> {
                for (Osoba o :
                        osoby) {
                    if (o instanceof Student) {

                        if (szukana == 1 && ((Student) o).getIS()) {
                            osoby.remove(o);
                            break;
                        }

                        else if (szukana == 2 && !((Student) o).getIS()) {
                            osoby.remove(o);
                            break;
                        }

                    }
                }
            }
        }
    }
}
