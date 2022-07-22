package Uczelnia.Sortowanie;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.KlasyAbstrakcyjne.Pracownik_Uczelni;
import Uczelnia.PozostaleKlasy.Kurs;
import Uczelnia.PozostaleKlasy.Student;

import java.util.Comparator;

public class SortO {


    // klasy wewnętrzne:
    static class PoNazwisku implements Comparator <Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
    }

    static class PoImieniuINazwisku implements Comparator <Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return (o1.getNazwisko()+o1.getImie()).compareTo(o2.getNazwisko()+o2.getImie());
        }
    }

    static class PoNazwiskuIWieku implements Comparator <Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {

            if(o1.getNazwisko().equals(o2.getNazwisko())) {
                return Integer.compare(o2.getWiek(),o1.getWiek());
            }
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
    }

    // pracownik:
    static class PrPoPen implements Comparator <Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            if (o1 instanceof Pracownik_Uczelni && o2 instanceof Pracownik_Uczelni)
                return Double.compare(((Pracownik_Uczelni) o1).getPensja(), ((Pracownik_Uczelni) o2).getPensja());
            return 0;
        }
    }


    // kursy
    static class KursPoECTS implements Comparator <Kurs> {

        @Override
        public int compare(Kurs o1, Kurs o2) {

            if(o1.getECTS() == o2.getECTS())
                return o1.getProwadzacyN().compareTo(o2.getProwadzacyN());
            return Integer.compare(o1.getECTS(), o2.getECTS());
        }
    }


    // =============== do listy VII
    static class StPoIndeks implements Comparator <Osoba> {
        @Override
        public int compare(Osoba o1, Osoba o2) {
            if (o1 instanceof Student && o2 instanceof Student)
                return Integer.compare(((Student) o1).getNR(),((Student) o2).getNR());
            return 0;
        }
    }

    static class PoPeselu implements Comparator <Osoba> {

        @Override
        public int compare(Osoba o1, Osoba o2) {
            return o1.getPesel().compareTo(o2.getPesel());
        }
    }

    // tworzymy comparatory:

    private PoNazwisku naz;
    private PoImieniuINazwisku imInaz;
    private PoNazwiskuIWieku poNazIWi;

    private PrPoPen prPoPen;

    private KursPoECTS kPECTS;

    private StPoIndeks stPoIndeks;
    private PoPeselu poPeselu;

    public void StworzComparatory() {

        naz = new PoNazwisku();
        imInaz = new PoImieniuINazwisku();
        poNazIWi = new PoNazwiskuIWieku();
        prPoPen = new PrPoPen();
        kPECTS = new KursPoECTS();
        stPoIndeks = new StPoIndeks();
        poPeselu = new PoPeselu();
    }

    public PoNazwisku getPoNaz() { return naz; }
    public PoImieniuINazwisku getImInaz() { return imInaz; }
    public PoNazwiskuIWieku getPoNazIWi() { return poNazIWi; }
    public PrPoPen getPrPoPen() { return prPoPen; }
    public KursPoECTS getkPECTS() { return kPECTS; }
    public StPoIndeks getStPoIndeks() { return stPoIndeks; }
    public PoPeselu getPoPeselu() { return poPeselu; }
}
