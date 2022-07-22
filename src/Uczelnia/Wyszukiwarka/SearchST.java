package Uczelnia.Wyszukiwarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Kurs;
import Uczelnia.PozostaleKlasy.Student;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchST implements Search {

    @Override
    public void SearchSTR(HashSet<Osoba> osoby, String szukana, String parametr) {

        for (Osoba o :
                osoby) {

            szukana = szukana.toLowerCase();
            if (o instanceof Student) {

                switch (parametr) {

                    case "n" -> {
                        if(o.getNazwisko().toLowerCase().equals(szukana))
                            System.out.println(o.toString());
                    }

                    case "i" -> {
                        if(o.getImie().toLowerCase().equals(szukana))
                            System.out.println(o.toString());
                    }

                    case "p" -> {
                        if(o.getPesel().equals(szukana))
                            System.out.println(o.toString());
                    }

                    case "k" -> {
                        ArrayList <Kurs> kursy = ((Student) o).getLista();
                        for (Kurs k :
                                kursy) {
                            if (k.getNazwa().toLowerCase().equals(szukana)) {
                                System.out.println(o.toString());
                                ((Student) o).DodatkoweOStudencie();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void SearchINT(ArrayList<Osoba> osoby, int szukana, String parametr) {

        for (Osoba o :
                osoby) {

            if (o instanceof Student) {

                switch (parametr) {
                    case "w" -> {
                        if (o.getWiek() == szukana)
                            System.out.println(o.toString());
                    }

                    case "nr" -> {
                        if (((Student) o).getNR() == szukana)
                            System.out.println(o.toString());
                    }
                }
            }
        }
    }
}
