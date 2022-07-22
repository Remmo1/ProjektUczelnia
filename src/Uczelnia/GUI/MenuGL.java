package Uczelnia.GUI;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.Main.Creator;
import Uczelnia.Niszczarka.*;
import Uczelnia.PozostaleKlasy.Kurs;
import Uczelnia.PozostaleKlasy.Pracownik_Administracyjny;
import Uczelnia.PozostaleKlasy.Student;
import Uczelnia.Serializacja.Serialization;
import Uczelnia.Sortowanie.SortO;
import Uczelnia.Wyszukiwarka.Pokazywanie;
import Uczelnia.Wyszukiwarka.Search;
import Uczelnia.Wyszukiwarka.SearchDE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuGL extends JFrame {

    static Creator c1 = new Creator();

    public MenuGL() {

        JFrame jFrameGL = new JFrame("Menu główne");

        JButton pokazywanie = new JButton("Pokaż");
        JButton szukanie = new JButton("Szukaj");
        JButton dopisywanie = new JButton("Dopisz");
        JButton zapis = new JButton("Zapisz do pliku");
        JButton odczyt = new JButton("Odczytaj z pliku");
        JButton sortowanie = new JButton("Sortowanie");
        JButton usuwanie = new JButton("Usuwanie");
        JButton wyjscie = new JButton("Wyjdź");


        pokazywanie.addActionListener(new Pokaz());
        szukanie.addActionListener(new Szuakj());
        dopisywanie.addActionListener(new Dopisz());
        zapis.addActionListener(new Zapis());
        odczyt.addActionListener(new Odczytaj());
        sortowanie.addActionListener(new Sortuje());
        usuwanie.addActionListener(new Usuwam());
        wyjscie.addActionListener(new Wyjdz());

        jFrameGL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameGL.setLayout(new GridLayout(2, 3));

        jFrameGL.getContentPane().add(pokazywanie);
        jFrameGL.getContentPane().add(szukanie);
        jFrameGL.getContentPane().add(dopisywanie);
        jFrameGL.getContentPane().add(zapis);
        jFrameGL.getContentPane().add(odczyt);
        jFrameGL.getContentPane().add(sortowanie);
        jFrameGL.getContentPane().add(usuwanie);
        jFrameGL.getContentPane().add(wyjscie);

        jFrameGL.setSize(600, 400);
        jFrameGL.setLocationRelativeTo(null);
        jFrameGL.setVisible(true);
    }


    // ================================================
    //                  przyciski:
    // ================================================


    // Pokazywanie ================================================
    static class Pokaz implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame jFrame = new JFrame("Menu pokazywania");

            JButton os = new JButton("Osoby");
            JButton k = new JButton("kursy");
            JButton hasz = new JButton("HaszSet");

            os.addActionListener(f -> Pokazywanie.PokazWszystkich(c1.getOsoby()));
            k.addActionListener(f -> Pokazywanie.PokazWszystkieKursy(c1.getKursy()));
            hasz.addActionListener(f -> Pokazywanie.PokazWszystkichH(c1.getOsobyhasze()));

            GridLayout gridLayout = new GridLayout(1,3);
            jFrame.setLayout(gridLayout);

            jFrame.getContentPane().add(os);
            jFrame.getContentPane().add(k);
            jFrame.getContentPane().add(hasz);

            jFrame.setSize(300,300);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }



    // Szukanie ================================================
    static class Szuakj implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame("Menu szukania");

            JButton dow = new JButton("Dowolna osoba");
            JButton st = new JButton("Student");
            JButton pr = new JButton("Pracownik");

            // dowolna osoba
            dow.addActionListener(f -> {

                Search s1 = new SearchDE();
                JFrame jFrame2 = new JFrame("Szukanie dowolnej osoby");
                jFrame2.setLayout(new GridLayout(4,1));

                JButton naz = new JButton("Szukaj po nazwisku");
                JButton im = new JButton("Szukaj po imieniu");
                JButton pe = new JButton("Szukaj po peselu");
                JButton wiek = new JButton("Szukaj po wieku");

                // nazwisko
                naz.addActionListener(g -> {
                    JTextField jTextField = new JTextField();
                    JFrame jFrame3 = new JFrame("Szukanie po nazwisku");
                    jFrame3.setLayout(new GridLayout(2,1));

                    JButton jButton = new JButton("OK");
                    jButton.addActionListener(h -> s1.SearchSTR(c1.getOsobyhasze(), jTextField.getText(), "n"));

                    jFrame3.getContentPane().add(jTextField);
                    jFrame3.getContentPane().add(jButton);

                    jFrame3.setSize(500,100);
                    jFrame3.setLocationRelativeTo(null);
                    jFrame3.setVisible(true);
                });
                im.addActionListener(g -> {
                    JTextField jTextField = new JTextField();
                    JFrame jFrame3 = new JFrame("Szukanie po imieniu");
                    jFrame3.setLayout(new GridLayout(2,1));

                    JButton jButton = new JButton("OK");
                    jButton.addActionListener(h -> s1.SearchSTR(c1.getOsobyhasze(), jTextField.getText(), "i"));

                    jFrame3.getContentPane().add(jTextField);
                    jFrame3.getContentPane().add(jButton);

                    jFrame3.setSize(500,100);
                    jFrame3.setLocationRelativeTo(null);
                    jFrame3.setVisible(true);
                });
                pe.addActionListener(g -> {
                    JTextField jTextField = new JTextField();
                    JFrame jFrame3 = new JFrame("Szukanie po peselu");
                    jFrame3.setLayout(new GridLayout(2,1));

                    JButton jButton = new JButton("OK");
                    jButton.addActionListener(h -> s1.SearchSTR(c1.getOsobyhasze(), jTextField.getText(), "p"));

                    jFrame3.getContentPane().add(jTextField);
                    jFrame3.getContentPane().add(jButton);

                    jFrame3.setSize(500,100);
                    jFrame3.setLocationRelativeTo(null);
                    jFrame3.setVisible(true);
                });
                wiek.addActionListener(g -> {
                    JTextField jTextField = new JTextField();
                    JFrame jFrame3 = new JFrame("Szukanie po wieku");
                    jFrame3.setLayout(new GridLayout(2,1));

                    JButton jButton = new JButton("OK");
                    jButton.addActionListener(h -> s1.SearchINT(c1.getOsoby(), Integer.parseInt(jTextField.getText()), "n"));

                    jFrame3.getContentPane().add(jTextField);
                    jFrame3.getContentPane().add(jButton);

                    jFrame3.setSize(500,100);
                    jFrame3.setLocationRelativeTo(null);
                    jFrame3.setVisible(true);
                });

                jFrame2.getContentPane().add(naz);
                jFrame2.getContentPane().add(im);
                jFrame2.getContentPane().add(pe);
                jFrame2.getContentPane().add(wiek);

                jFrame2.setSize(500,200);
                jFrame2.setLocationRelativeTo(null);
                jFrame2.setVisible(true);
            });

            GridLayout gridLayout = new GridLayout(1,0);
            jFrame.setLayout(gridLayout);

            jFrame.getContentPane().add(dow);
            jFrame.getContentPane().add(st);
            jFrame.getContentPane().add(pr);

            jFrame.setSize(300,300);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);

        }
    }



    // Dopisywanie ===================================================
    static class Dopisz implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame("Menu Dopisywania");

            JButton st = new JButton("Student");
            JButton pr = new JButton("Pracownik");
            JButton ku = new JButton("Kurs");

            // Student
            st.addActionListener(f -> {

                // Menu:

                JFrame jFrame1 = new JFrame("Dopisywanie Studenta");
                jFrame1.setLayout(null);
                JButton jButton = new JButton("OK");

                JTextField jTextField1 = new JTextField();
                JTextField jTextField11 = new JTextField("Imię: ");
                jTextField11.setBounds(0, 0, 200,25);
                jTextField1.setBounds(100, 0, 200,25);
                jTextField11.setEditable(false);

                JTextField jTextField2 = new JTextField();
                JTextField jTextField22 = new JTextField("Nazwisko: ");
                jTextField22.setBounds(0, 50, 200,25);
                jTextField2.setBounds(100, 50, 200,25);
                jTextField22.setEditable(false);

                JTextField jTextField3 = new JTextField();
                JTextField jTextField33 = new JTextField("Pesel: ");
                jTextField33.setBounds(0, 100, 200,25);
                jTextField3.setBounds(100, 100, 200,25);
                jTextField22.setEditable(false);

                JTextField jTextField4 = new JTextField();
                JTextField jTextField44 = new JTextField("Wiek: ");
                jTextField44.setBounds(0, 150, 200,25);
                jTextField4.setBounds(100, 150, 200,25);
                jTextField44.setEditable(false);

                JTextField jTextField5 = new JTextField();
                JTextField jTextField55 = new JTextField("Płeć: ");
                jTextField55.setBounds(0, 200, 200,25);
                jTextField5.setBounds(100, 200, 200,25);
                jTextField55.setEditable(false);

                JTextField jTextField6 = new JTextField();
                JTextField jTextField66 = new JTextField("Numer indeksu studenta: ");
                jTextField66.setBounds(320, 0, 200,25);
                jTextField6.setBounds(520, 0, 200,25);
                jTextField66.setEditable(false);

                JTextField jTextField7 = new JTextField();
                JTextField jTextField77 = new JTextField("Czy bierze udział w Erasmus: ");
                jTextField77.setBounds(320, 50, 200,25);
                jTextField7.setBounds(520, 50, 200,25);
                jTextField77.setEditable(false);

                JTextField jTextField8 = new JTextField();
                JTextField jTextField88 = new JTextField("Czy studiuje na pierwszym stopniu: ");
                jTextField88.setBounds(320, 100, 200,25);
                jTextField8.setBounds(520, 100, 200,25);
                jTextField88.setEditable(false);

                JTextField jTextField9 = new JTextField();
                JTextField jTextField99 = new JTextField("Czy studiuje stacjonarnie: ");
                jTextField99.setBounds(320, 150, 200,25);
                jTextField9.setBounds(520, 150, 200,25);
                jTextField99.setEditable(false);

                jButton.setBounds(320,200,200,25);

                jFrame1.add(jTextField1);
                jFrame1.add(jTextField11);
                jFrame1.add(jTextField2);
                jFrame1.add(jTextField22);
                jFrame1.add(jTextField3);
                jFrame1.add(jTextField33);
                jFrame1.add(jTextField4);
                jFrame1.add(jTextField44);
                jFrame1.add(jTextField5);
                jFrame1.add(jTextField55);
                jFrame1.add(jTextField6);
                jFrame1.add(jTextField66);
                jFrame1.add(jTextField7);
                jFrame1.add(jTextField77);
                jFrame1.add(jTextField8);
                jFrame1.add(jTextField88);
                jFrame1.add(jTextField9);
                jFrame1.add(jTextField99);
                jFrame1.add(jButton);

                jButton.addActionListener(z -> {
                    ArrayList<Kurs> kursy = c1.DefaultCourses();
                    boolean b1 = false, b2 = false, b3 = false;
                    if (jTextField7.getText().equals("tak")) b1 = true;
                    if (jTextField8.getText().equals("tak")) b2 = true;
                    if (jTextField9.getText().equals("tak")) b3 = true;

                    Student s1 = new Student(jTextField1.getText(),
                            jTextField2.getText(),
                            jTextField3.getText(),
                            Integer.parseInt(jTextField4.getText()),
                            jTextField5.getText(),
                            Integer.parseInt(jTextField6.getText()),
                            b1,
                            b2,
                            b3,
                            kursy);
                    c1.DodajDoBazy(s1);
                    c1.DodajDoBazyH(s1);
                    jFrame1.dispose();
                });

                jFrame1.setSize(800,300);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });


            // Pracownik
            pr.addActionListener(f -> {
                JFrame jFrame1 = new JFrame("Dopisywanie Pracownika");
                jFrame1.setLayout(null);
                JButton jButton = new JButton("OK");

                JTextField jTextField1 = new JTextField();
                JTextField jTextField11 = new JTextField("Imię: ");
                jTextField11.setBounds(0, 0, 200,25);
                jTextField1.setBounds(100, 0, 200,25);
                jTextField11.setEditable(false);

                JTextField jTextField2 = new JTextField();
                JTextField jTextField22 = new JTextField("Nazwisko: ");
                jTextField22.setBounds(0, 50, 200,25);
                jTextField2.setBounds(100, 50, 200,25);
                jTextField22.setEditable(false);

                JTextField jTextField3 = new JTextField();
                JTextField jTextField33 = new JTextField("Pesel: ");
                jTextField33.setBounds(0, 100, 200,25);
                jTextField3.setBounds(100, 100, 200,25);
                jTextField22.setEditable(false);

                JTextField jTextField4 = new JTextField();
                JTextField jTextField44 = new JTextField("Wiek: ");
                jTextField44.setBounds(0, 150, 200,25);
                jTextField4.setBounds(100, 150, 200,25);
                jTextField44.setEditable(false);

                JTextField jTextField5 = new JTextField();
                JTextField jTextField55 = new JTextField("Płeć: ");
                jTextField55.setBounds(0, 200, 200,25);
                jTextField5.setBounds(100, 200, 200,25);
                jTextField55.setEditable(false);

                JTextField jTextField6 = new JTextField();
                JTextField jTextField66 = new JTextField("Stanowisko: ");
                jTextField66.setBounds(320, 0, 200,25);
                jTextField6.setBounds(520, 0, 200,25);
                jTextField66.setEditable(false);

                JTextField jTextField7 = new JTextField();
                JTextField jTextField77 = new JTextField("Staż: ");
                jTextField77.setBounds(320, 50, 200,25);
                jTextField7.setBounds(520, 50, 200,25);
                jTextField77.setEditable(false);

                JTextField jTextField8 = new JTextField();
                JTextField jTextField88 = new JTextField("Pensja: ");
                jTextField88.setBounds(320, 100, 200,25);
                jTextField8.setBounds(520, 100, 200,25);
                jTextField88.setEditable(false);

                JTextField jTextField9 = new JTextField();
                JTextField jTextField99 = new JTextField("Liczba nadgodzin: ");
                jTextField99.setBounds(320, 150, 200,25);
                jTextField9.setBounds(520, 150, 200,25);
                jTextField99.setEditable(false);

                jButton.setBounds(320,200,200,25);

                jFrame1.add(jTextField1);
                jFrame1.add(jTextField11);
                jFrame1.add(jTextField2);
                jFrame1.add(jTextField22);
                jFrame1.add(jTextField3);
                jFrame1.add(jTextField33);
                jFrame1.add(jTextField4);
                jFrame1.add(jTextField44);
                jFrame1.add(jTextField5);
                jFrame1.add(jTextField55);
                jFrame1.add(jTextField6);
                jFrame1.add(jTextField66);
                jFrame1.add(jTextField7);
                jFrame1.add(jTextField77);
                jFrame1.add(jTextField8);
                jFrame1.add(jTextField88);
                jFrame1.add(jTextField9);
                jFrame1.add(jTextField99);
                jFrame1.add(jButton);

                jButton.addActionListener(g -> {
                    Pracownik_Administracyjny p1 = new Pracownik_Administracyjny(
                            jTextField1.getText(),
                            jTextField2.getText(),
                            jTextField3.getText(),
                            Integer.parseInt(jTextField4.getText()),
                            jTextField5.getText(),
                            jTextField6.getText(),
                            Integer.parseInt(jTextField7.getText()),
                            Double.parseDouble(jTextField8.getText()),
                            Integer.parseInt(jTextField9.getText())
                    );

                    c1.DodajDoBazy(p1);
                    c1.DodajDoBazyH(p1);
                    jFrame1.dispose();




                });


                jFrame1.setSize(800,300);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);

            });

            GridLayout gridLayout = new GridLayout(1,0);
            jFrame.setLayout(gridLayout);

            jFrame.getContentPane().add(st);
            jFrame.getContentPane().add(pr);
            jFrame.getContentPane().add(ku);

            jFrame.setSize(300,300);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }



    // Zapis do pliku ==================================================
    static class Zapis implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                JFrame jFrame;
                JTextField jTextField;
                JButton jButton;

                // Zapis:
                Serialization.zapiszO(c1.getOsoby());

                jFrame = new JFrame("Menu Zapisu");
                jTextField = new JTextField("Osoby Zostały zapisane do pliku baza.ser");
                jButton = new JButton("OK");

                jFrame.setLayout(new GridLayout(2,1));
                jFrame.add(jTextField);
                jFrame.add(jButton);

                jFrame.setSize(300,200);
                jFrame.setLocationRelativeTo(null);
                jFrame.setVisible(true);

                jButton.addActionListener(g -> {
                    jFrame.setVisible(false);
                    jFrame.dispose();
                });
        }
    }



    // Odczyt z pliku ==================================================
    static class Odczytaj implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pokazywanie.PokazWszystkich(Serialization.odczytajO(c1.getOsoby().size()));
        }
    }



    // Sortowanie =======================================================
    static class Sortuje implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame("Menu Sortowania");
            jFrame.setLayout(new GridLayout(3,2));

            JButton jButton = new JButton("Po nazwisku");
            JButton jButton1 = new JButton("Po nazwisku i imieniu");
            JButton jButton2 = new JButton("Po nazwisku i wieku");
            JButton jButton3 = new JButton("Pracownicy po pensji");
            JButton jButton4 = new JButton("Kursy po ECTS i nazwisku");
            JButton jButton5 = new JButton("kursy wg. wyższego u studentów");

            jButton.addActionListener(f -> {
                SortO s1 = new SortO();
                s1.StworzComparatory();
                c1.getOsoby().sort(s1.getPoNaz());

                JFrame jFrame1 = new JFrame("Po nazwisku");
                JButton jButton6 = new JButton("OK");
                JTextField jTextField = new JTextField("Osoby zostały posortowane po nazwisku");
                jFrame1.setLayout(new GridLayout(2,1));

                jButton6.addActionListener(g -> jFrame1.dispose());
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton6);

                jFrame1.setSize(300,100);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });
            jButton1.addActionListener(f -> {
                SortO s1 = new SortO();
                s1.StworzComparatory();
                c1.getOsoby().sort(s1.getImInaz());

                JFrame jFrame1 = new JFrame("Po nazwisku i imieniu");
                JButton jButton6 = new JButton("OK");
                JTextField jTextField = new JTextField("Osoby zostały posortowane po nazwisku i imieniu");
                jFrame1.setLayout(new GridLayout(2,1));

                jButton6.addActionListener(g -> jFrame1.dispose());
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton6);

                jFrame1.setSize(300,100);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });
            jButton2.addActionListener(f -> {
                SortO s1 = new SortO();
                s1.StworzComparatory();
                c1.getOsoby().sort(s1.getPoNazIWi());

                JFrame jFrame1 = new JFrame("Po nazwisku i wieku");
                JButton jButton6 = new JButton("OK");
                JTextField jTextField = new JTextField("Osoby zostały posortowane po nazwisku i wieku");
                jFrame1.setLayout(new GridLayout(2,1));

                jButton6.addActionListener(g -> jFrame1.dispose());
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton6);

                jFrame1.setSize(300,100);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });
            jButton3.addActionListener(f -> {
                SortO s1 = new SortO();
                s1.StworzComparatory();
                c1.getOsoby().sort(s1.getPrPoPen());

                JFrame jFrame1 = new JFrame("Po pensji");
                JButton jButton6 = new JButton("OK");
                JTextField jTextField = new JTextField("Pracownicy zostali posegregowani po pensji");
                jFrame1.setLayout(new GridLayout(2,1));

                jButton6.addActionListener(g -> jFrame1.dispose());
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton6);

                jFrame1.setSize(300,100);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });
            jButton4.addActionListener(f -> {
                SortO s1 = new SortO();
                s1.StworzComparatory();
                c1.getKursy().sort(s1.getkPECTS());

                JFrame jFrame1 = new JFrame("Kursy po ECTS i nazwisku prowadzącego");
                JButton jButton6 = new JButton("OK");
                JTextField jTextField = new JTextField("Kursy zostały posegregowane wg. ECTS i nazwiska prowadzącego");
                jFrame1.setLayout(new GridLayout(2,1));

                jButton6.addActionListener(g -> jFrame1.dispose());
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton6);

                jFrame1.setSize(500,100);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });
            jButton5.addActionListener(f -> {
                SortO s1 = new SortO();
                s1.StworzComparatory();
                for (Osoba o :
                        c1.getOsoby()) {
                    if (o instanceof Student)
                        ((Student) o).getLista().sort(s1.getkPECTS());
                }

                JFrame jFrame1 = new JFrame("Kursy po ECTS i nazwisku prowadzącego u studentów");
                JButton jButton6 = new JButton("OK");
                JTextField jTextField = new JTextField("Kursy zostały posortowane wg. ECTS i nazwiska prowadzącego u wszystkich studentów");
                jFrame1.setLayout(new GridLayout(2,1));

                jButton6.addActionListener(g -> jFrame1.dispose());
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton6);

                jFrame1.setSize(600,100);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });

            jFrame.add(jButton);
            jFrame.add(jButton1);
            jFrame.add(jButton2);
            jFrame.add(jButton3);
            jFrame.add(jButton4);
            jFrame.add(jButton5);

            jFrame.setSize(500,300);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }


    // Usuwanie ========================================================
    static class Usuwam implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame jFrame = new JFrame("Menu Usuwania");
            JButton jButton = new JButton("Dowolna osoba");
            JButton jButton1 = new JButton("Pracownik");
            JButton jButton2 = new JButton("Student");
            JButton jButton3 = new JButton("Kurs");
            JButton jButton444 = new JButton("Duplikaty");
            jFrame.setLayout(new GridLayout(5,1));

            jFrame.add(jButton);
            jFrame.add(jButton1);
            jFrame.add(jButton2);
            jFrame.add(jButton3);
            jFrame.add(jButton444);

            // Dowolna osoba
            jButton.addActionListener(f -> {
                JFrame jFrame1 = new JFrame("Usuwanie");
                JButton jButton4 = new JButton("Nazwisko");
                JButton jButton5 = new JButton("Imię");
                JButton jButton6 = new JButton("Wiek");
                jFrame1.setLayout(new GridLayout(3,1));

                jFrame1.add(jButton4);
                jFrame1.add(jButton5);
                jFrame1.add(jButton6);

                // nazwisko
                jButton4.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po nazwisku");
                    JTextField jTextField = new JTextField("Podaj nazwisko:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DPerson();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "n");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Osoba o nazwisku " + jTextField1.getText() + " została usunięta");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // imię
                jButton5.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po imieniu");
                    JTextField jTextField = new JTextField("Podaj imię:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DPerson();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "i");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Osoba o imieniu " + jTextField1.getText() + " została usunięta");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // wiek
                jButton6.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po wieku");
                    JTextField jTextField = new JTextField("Podaj wiek:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DPerson();
                        d1.UsunInt(c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "w");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Osoba w wieku " + jTextField1.getText() + " została usunięta");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                jFrame1.setSize(300, 300);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });

            // Pracownik
            jButton1.addActionListener(f -> {
                JFrame jFrame1 = new JFrame("Usuwanie");
                JButton jButton4 = new JButton("Nazwisko");
                JButton jButton5 = new JButton("Imię");
                JButton jButton6 = new JButton("Wiek");
                JButton jButton44 = new JButton("Staż");
                JButton jButton55 = new JButton("Stanowisko");
                jFrame1.setLayout(new GridLayout(5,1));

                jFrame1.add(jButton4);
                jFrame1.add(jButton5);
                jFrame1.add(jButton6);
                jFrame1.add(jButton44);
                jFrame1.add(jButton55);

                // nazwisko
                jButton4.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po nazwisku");
                    JTextField jTextField = new JTextField("Podaj nazwisko:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DWorker();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "n");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Pracownik o nazwisku " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // imię
                jButton5.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po imieniu");
                    JTextField jTextField = new JTextField("Podaj imię:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DWorker();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "i");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Pracownik o imieniu " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // wiek
                jButton6.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po wieku");
                    JTextField jTextField = new JTextField("Podaj wiek:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DWorker();
                        d1.UsunInt(c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "w");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Pracownik w wieku " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // staż
                jButton44.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po stażu");
                    JTextField jTextField = new JTextField("Podaj staż:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DWorker();
                        d1.UsunInt(c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "st");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Pracownik o stażu " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);
                });

                // stanowisko
                jButton55.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po stanowisku");
                    JTextField jTextField = new JTextField("Podaj stanowisko:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DWorker();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "st");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Pracownik na stanowisku " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);
                });

                jFrame1.setSize(300, 300);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });

            // Student
            jButton2.addActionListener(f -> {
                JFrame jFrame1 = new JFrame("Usuwanie");
                JButton jButton4 = new JButton("Nazwisko");
                JButton jButton5 = new JButton("Imię");
                JButton jButton6 = new JButton("Wiek");
                JButton jButton44 = new JButton("Numer indeksu");
                JButton jButton55 = new JButton("Rok studiów");
                jFrame1.setLayout(new GridLayout(5,1));

                jFrame1.add(jButton4);
                jFrame1.add(jButton5);
                jFrame1.add(jButton6);
                jFrame1.add(jButton44);
                jFrame1.add(jButton55);

                // nazwisko
                jButton4.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po nazwisku");
                    JTextField jTextField = new JTextField("Podaj nazwisko:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DStudent();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "n");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Student o nazwisku " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // imię
                jButton5.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po imieniu");
                    JTextField jTextField = new JTextField("Podaj imię:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DStudent();
                        d1.UsunSTR(c1.getOsoby(), jTextField1.getText(), "i");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Student o imieniu " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // wiek
                jButton6.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po wieku");
                    JTextField jTextField = new JTextField("Podaj wiek:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DStudent();
                        d1.UsunInt(c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "w");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Student w wieku " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // numer indeksu
                jButton44.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po numerze indeksu");
                    JTextField jTextField = new JTextField("Podaj numer indeksu:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DStudent();
                        d1.UsunInt(c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "nr");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Student o numerze indeksu " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);
                });

                // rok studiów
                jButton55.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po roku studiów");
                    JTextField jTextField = new JTextField("Podaj rok studiów:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        Destroyer d1 = new DStudent();
                        d1.UsunInt(c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "rs");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Student na roku studiów " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(300,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);
                });

                jFrame1.setSize(300, 300);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });

            // Kurs
            jButton3.addActionListener(f -> {
                JFrame jFrame1 = new JFrame("Usuwanie");
                JButton jButton4 = new JButton("Nazwa kursu");
                JButton jButton5 = new JButton("Nazwisko prowadzącego");
                JButton jButton6 = new JButton("Punkty ECTS");
                jFrame1.setLayout(new GridLayout(3,1));

                jFrame1.add(jButton4);
                jFrame1.add(jButton5);
                jFrame1.add(jButton6);

                // nazwa
                jButton4.addActionListener(g -> {
                    JFrame jFrame2 = new JFrame("Usuwanie po nazwie kursu");
                    JTextField jTextField = new JTextField("Podaj nazwę kursu:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        DestroyerCourse d1 = new DCourse();
                        d1.UsunSTR(c1.getKursy(), c1.getOsoby(), jTextField1.getText(), "n");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Kurs o nazwie " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(500,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // nazwisko
                jButton5.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po nazwisku prowadzącego");
                    JTextField jTextField = new JTextField("Podaj nazwisko prowadzącego:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        DestroyerCourse d1 = new DCourse();
                        d1.UsunSTR(c1.getKursy(), c1.getOsoby(), jTextField1.getText(), "pr");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Kurs prowadzony przez prowadzącego o nazwisku " + jTextField1.getText() + " został usunięty");
                        jTextField2.setEditable(false);
                        jFrame3.add(jTextField2);

                        jFrame3.setSize(500,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                // wiek
                jButton6.addActionListener(g -> {

                    JFrame jFrame2 = new JFrame("Usuwanie po ECTS");
                    JTextField jTextField = new JTextField("Podaj ilość punktów ECTS:");
                    JTextField jTextField1 = new JTextField();
                    JButton jButton7 = new JButton("OK");
                    jFrame2.setLayout(new GridLayout(3,1));

                    jTextField.setEditable(false);
                    jButton7.addActionListener(h -> {
                        DestroyerCourse d1 = new DCourse();
                        d1.UsunInt(c1.getKursy(), c1.getOsoby(), Integer.parseInt(jTextField1.getText()), "w");

                        JFrame jFrame3 = new JFrame("Usuwanie zakończone");
                        JTextField jTextField2 = new JTextField("Kurs za którego ilość punktów ECTS była równa  " + jTextField1.getText() + " został usunięty");
                        jFrame3.add(jTextField2);
                        jTextField2.setEditable(false);

                        jFrame3.setSize(500,200);
                        jFrame3.setLocationRelativeTo(null);
                        jFrame3.setVisible(true);
                    });

                    jFrame2.add(jTextField);
                    jFrame2.add(jTextField1);
                    jFrame2.add(jButton7);

                    jFrame2.setSize(350,200);
                    jFrame2.setLocationRelativeTo(null);
                    jFrame2.setVisible(true);

                });

                jFrame1.setSize(300, 300);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
            });

            // Duplikaty Lista VII
            jButton444.addActionListener(f -> {

                DestroyHasz.UsunDuplikaty(c1.getOsobyhasze(),c1.getOsoby());

                JFrame jFrame1 = new JFrame("Duplikaty");
                JButton jButton4 = new JButton("OK");
                JTextField jTextField = new JTextField("Wszystkie duplikaty zostały usunięte");

                jFrame1.setLayout(new GridLayout(2,1));
                jTextField.setEditable(false);

                jFrame1.add(jTextField);
                jFrame1.add(jButton4);

                jButton4.addActionListener(g -> jFrame1.dispose());

                jFrame1.setSize(300,200);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);

            });

            jFrame.setSize(300, 300);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }


    // Usun Hashem =====================================================
    static class Wyjdz implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) { System.exit(0); }
    }

}
