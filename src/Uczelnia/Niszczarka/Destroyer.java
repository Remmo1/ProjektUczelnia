package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;

import java.util.ArrayList;

public interface Destroyer {
    void UsunSTR(ArrayList<Osoba> osoby, String szukana, String parametr);
    void UsunInt(ArrayList <Osoba> osoby, int szukana, String parametr);
}
