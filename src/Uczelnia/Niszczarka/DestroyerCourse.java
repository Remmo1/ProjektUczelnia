package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Kurs;

import java.util.ArrayList;

public interface DestroyerCourse {
    void UsunSTR(ArrayList<Kurs> kursy, ArrayList <Osoba> osoby, String szukana, String parametr);
    void UsunInt(ArrayList <Kurs> kursy, ArrayList <Osoba> osoby, int szukana, String parametr);
}
