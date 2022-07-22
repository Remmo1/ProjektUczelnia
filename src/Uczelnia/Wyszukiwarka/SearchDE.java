package Uczelnia.Wyszukiwarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchDE implements Search {

    @Override
    public void SearchSTR(HashSet<Osoba> osoby, String szukana, String parametr) {

        for (Osoba o :
                osoby) {

            szukana = szukana.toLowerCase();
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
            }
        }
    }

    @Override
    public void SearchINT(ArrayList<Osoba> osoby, int szukana, String parametr) {

        for (Osoba o :
                osoby) {

            if (o.getWiek() == szukana)
                System.out.println(o.toString());
        }
    }
}
