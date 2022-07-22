package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Kurs;
import Uczelnia.PozostaleKlasy.Student;

import java.util.ArrayList;

public class DCourse implements DestroyerCourse {


    @Override
    public void UsunSTR(ArrayList<Kurs> kursy, ArrayList<Osoba> osoby, String szukana, String parametr) {

        szukana = szukana.toLowerCase();

        switch (parametr) {

            case "n" -> {
                for (Kurs k :
                        kursy) {
                    if (k.getNazwa().toLowerCase().equals(szukana)){
                        kursy.remove(k);
                        break;
                    }
                }

                for (Osoba o :
                        osoby) {
                    if (o instanceof Student) {
                        ArrayList <Kurs> kursyST = ((Student) o).getLista();

                        for (Kurs k :
                                kursyST) {
                            if (k.getNazwa().toLowerCase().equals(szukana)) {
                                kursyST.remove(k);
                                break;
                            }
                        }
                    }
                }
            }

            case "pr" -> {
                for (Kurs k :
                        kursy) {
                    if (k.getProwadzacyN().toLowerCase().equals(szukana)){
                        kursy.remove(k);
                        break;
                    }
                }

                for (Osoba o :
                        osoby) {
                    if (o instanceof Student) {
                        ArrayList <Kurs> kursyST = ((Student) o).getLista();

                        for (Kurs k :
                                kursyST) {
                            if (k.getProwadzacyN().toLowerCase().equals(szukana)) {
                                kursyST.remove(k);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void UsunInt(ArrayList<Kurs> kursy, ArrayList<Osoba> osoby, int szukana, String parametr) {

        for (Kurs k :
                kursy) {
            if (k.getECTS() == szukana){
                kursy.remove(k);
                break;
            }
        }

        for (Osoba o :
                osoby) {
            if (o instanceof Student) {
                ArrayList <Kurs> kursyST = ((Student) o).getLista();

                for (Kurs k :
                        kursyST) {
                    if (k.getECTS() == szukana) {
                        kursyST.remove(k);
                        break;
                    }
                }
            }
        }

    }
}
