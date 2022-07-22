package Uczelnia.Serializacja;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Kurs;

import java.io.*;
import java.util.ArrayList;

public class Serialization {

    public static void zapiszO(ArrayList <Osoba> osoby) {

        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("baza.bin"))) {

            for (Osoba o :
                    osoby) {
                obj.writeObject(o);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList <Osoba> odczytajO(int iloscO) {

        ArrayList <Osoba> osoby = new ArrayList<>();

        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("baza.bin"))) {

            Object o;
            Osoba osoba;

            for (int i = 0; i < iloscO; i++) {
                o = obj.readObject();
                osoba = (Osoba) o;
                osoby.add(osoba);
            }
        }
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return osoby;
    }

    public static void zapiszK(ArrayList <Kurs> kursy) {

        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("kursy.ser"))) {

            for (Kurs k :
                    kursy) {
                obj.writeObject(k);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void odczytajK(int ilosc_kursow) {

        Object k;
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("kursy.ser"))){

            for (int i = 0; i < ilosc_kursow; i++) {
                k = obj.readObject();
                System.out.println(k);
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
