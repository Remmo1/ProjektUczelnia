package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.KlasyAbstrakcyjne.Pracownik_Uczelni;

import java.util.ArrayList;

public class DWorker implements Destroyer {

    @Override
    public void UsunSTR(ArrayList<Osoba> osoby, String szukana, String parametr) {
        szukana = szukana.toLowerCase();

        switch (parametr) {
            case "n" -> {
                for (Osoba o:
                        osoby) {
                    if (o instanceof Pracownik_Uczelni) {
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
                    if (o instanceof Pracownik_Uczelni) {
                        if (o.getImie().toLowerCase().equals(szukana)) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }

            case "st" -> {
                for (Osoba o :
                        osoby) {
                    if (o instanceof Pracownik_Uczelni) {
                        if (((Pracownik_Uczelni) o).getStanowisko().toLowerCase().equals(szukana)) {
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
                    if (o instanceof Pracownik_Uczelni) {
                        if(o.getWiek() == szukana) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }

            case "st" -> {
                for (Osoba o :
                        osoby) {
                    if (o instanceof Pracownik_Uczelni) {
                        if(((Pracownik_Uczelni) o).getStaz() == szukana) {
                            osoby.remove(o);
                            break;
                        }
                    }
                }
            }
        }
    }
}
