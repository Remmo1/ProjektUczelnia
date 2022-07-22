package Uczelnia.Main;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Kurs;
import Uczelnia.PozostaleKlasy.Pracownik_Administracyjny;
import Uczelnia.PozostaleKlasy.Pracownik_Badawczo_Dydaktyczny;
import Uczelnia.PozostaleKlasy.Student;

import java.util.ArrayList;
import java.util.HashSet;

public class Creator {

    // tworzenie obiektów:

    // Pracownicy administracyjni:
    Pracownik_Administracyjny pa1 = new Pracownik_Administracyjny("Mieczysław", "Nowak", "11111111111", 50, "m", "Konserwator", 10, 2500, 6);
    Pracownik_Administracyjny pa2 = new Pracownik_Administracyjny("Agata", "Nowak", "22222222222", 40, "k", "Portier", 7, 2300, 8);

    // Wykładowcy:
    Pracownik_Badawczo_Dydaktyczny pn1 = new Pracownik_Badawczo_Dydaktyczny("Marian", "Kowalski", "33333333333", 38, "m", "Wykładowca", 5, 4000, 4);
    Pracownik_Badawczo_Dydaktyczny pn2 = new Pracownik_Badawczo_Dydaktyczny("Natalia", "Skuza", "44444444444", 25, "k", "Asystent", 1, 2500, 1);
    Pracownik_Badawczo_Dydaktyczny pn3 = new Pracownik_Badawczo_Dydaktyczny("Piotr", "Lewandowski", "55555555555", 37, "m", "Wykładowca", 6, 3800, 3.8);

    // Kursy:
    Kurs k1 = new Kurs("psio", 5, pn1);
    Kurs k2 = new Kurs("logika", 4, pn1);
    Kurs k3 = new Kurs("osk", 3, pn2);
    Kurs k4 = new Kurs("analiza", 3, pn3);
    Kurs k5 = new Kurs("angielski", 2, pn2);


    ArrayList<Kurs> listaKursow = new ArrayList<>();           // kursy pierwszego studenta
    ArrayList<Kurs> listaKursow2 = new ArrayList<>();          // kursy drugiego studenta

    // studenci:
    Student s1 = new Student("Tobiasz", "Janusz", "555555555555", 20, "m", 100000, false, true, true, CreateCourseForStudent1());
    Student s2 = new Student("Zofia", "Zub", "66666666666", 22, "k", 200000, true, false, false, CreateCourseForStudent2());

    ArrayList<Osoba> osoby = new ArrayList<>();                // wszystkie osoby
    ArrayList<Kurs> kursy = new ArrayList<>();                // wszystkie kursy
    HashSet<Osoba> osobyhasze = new HashSet<>();              // lista VII

    public Creator() {
        DodajDoBazy(pa1);
        DodajDoBazy(pa2);
        DodajDoBazy(pn1);
        DodajDoBazy(pn2);
        DodajDoBazy(pn3);
        DodajDoBazy(s1);
        DodajDoBazy(s2);

        kursy.add(k1);
        kursy.add(k2);
        kursy.add(k3);
        kursy.add(k4);
        kursy.add(k5);

        osobyhasze.addAll(osoby);
        DodajDoBazyH(s1);
    }

    public ArrayList <Kurs> DefaultCourses() {

        ArrayList <Kurs> kursy = new ArrayList<>();

        kursy.add(k1);
        kursy.add(k2);
        kursy.add(k3);

        return kursy;
    }

    public ArrayList <Kurs> CreateCourseForStudent1() {

        // kursy pierwszego studenta
        listaKursow.add(k2);
        listaKursow.add(k3);

        return listaKursow;
    }

    public ArrayList <Kurs> CreateCourseForStudent2() {

        // kursy drugiego studenta
        listaKursow2.add(k1);
        listaKursow2.add(k4);

        return listaKursow2;
    }

    public void DodajDoBazy(Osoba o) { osoby.add(o); }
    public void DodajDoBazyH(Osoba o) { osobyhasze.add(o); }

    public ArrayList<Osoba> getOsoby() {
        return osoby;
    }

    public ArrayList<Kurs> getKursy() { return kursy; }

    public HashSet<Osoba> getOsobyhasze() { return osobyhasze; }
}
