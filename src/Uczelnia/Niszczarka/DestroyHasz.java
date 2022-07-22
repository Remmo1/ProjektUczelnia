package Uczelnia.Niszczarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.KlasyAbstrakcyjne.Pracownik_Uczelni;
import Uczelnia.PozostaleKlasy.Student;
import Uczelnia.Sortowanie.SortO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DestroyHasz {
    
    public static int KtoryNumerSt(ArrayList <Osoba> osoby) {

        int w = 0;
        int p = w;
        SortO s1 = new SortO();
        s1.StworzComparatory();
        osoby.sort(s1.getStPoIndeks());

        for (Osoba o :
                osoby) {
            if (o instanceof Student) {
                int a = ((Student) o).getNR();
                if (a != w) {
                    w = a;
                }
                else
                    p = w;
            }
        }
        
        return p;
    }

    public static String KtoryNumerPr(ArrayList <Osoba> osoby) {

        String w = "0";
        String p = w;
        SortO s1 = new SortO();
        s1.StworzComparatory();
        osoby.sort(s1.getPoPeselu());

        for (Osoba o :
                osoby) {
            String a = o.getPesel();

            if (a.equals(w))
                p = w;
            else
                w = a;

        }

        return p;
    }

    public static void UsunDuplikaty(HashSet <Osoba> osoby, ArrayList <Osoba> osobyl) {

        int nr = KtoryNumerSt(osobyl);
        String pe = KtoryNumerPr(osobyl);

        for (Iterator<Osoba> it = osoby.iterator(); it.hasNext();) {
            Osoba next = it.next();
            if (next instanceof Student) {
                if (((Student) next).getNR() == nr)
                    it.remove();
            }
        }

        for (Iterator<Osoba> it = osoby.iterator(); it.hasNext();) {
            Osoba next = it.next();
            if (next instanceof Pracownik_Uczelni) {
                if (next.getPesel().equals(pe))
                    it.remove();
            }
        }

    }
}
