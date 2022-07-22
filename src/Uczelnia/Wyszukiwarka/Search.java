package Uczelnia.Wyszukiwarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;

import java.util.ArrayList;
import java.util.HashSet;

public interface Search {
    void SearchSTR(HashSet<Osoba> osoby, String szukana, String parametr);
    void SearchINT(ArrayList <Osoba> osoby, int szukana, String parametr);
}
