package Uczelnia.Wyszukiwarka;

import Uczelnia.KlasyAbstrakcyjne.Osoba;
import Uczelnia.PozostaleKlasy.Kurs;
import Uczelnia.PozostaleKlasy.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Pokazywanie {

    public static void PokazWszystkich(ArrayList<Osoba> osoby) {

        JFrame jFrame = new JFrame("Baza osób");
        JPanel jPanel = new JPanel();

        jFrame.getContentPane().add(jPanel);

        for (Osoba o :
                osoby) {
            if (o instanceof Student) {
                JLabel jLabel = new JLabel(o.toString());
                JLabel jLabel1 = new JLabel(((Student) o).DodatkoweOStudencie());
                jPanel.add(jLabel);
                jPanel.add(jLabel1);
            }
            else {
                JLabel jLabel2 = new JLabel(o.toString());
                jPanel.add(jLabel2);
            }

        }

        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void PokazWszystkichH(HashSet<Osoba> osoby) {

        JFrame jFrame = new JFrame("Baza osób");
        JPanel jPanel = new JPanel();

        jFrame.getContentPane().add(jPanel);

        for (Osoba o :
                osoby) {
            if (o instanceof Student) {
                JLabel jLabel = new JLabel(o.toString());
                JLabel jLabel1 = new JLabel(((Student) o).DodatkoweOStudencie());
                jPanel.add(jLabel);
                jPanel.add(jLabel1);
            }
            else {
                JLabel jLabel2 = new JLabel(o.toString());
                jPanel.add(jLabel2);
            }

        }

        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void PokazWszystkieKursy(ArrayList <Kurs> kursy) {

        JFrame jFrame = new JFrame("Baza kursów");
        jFrame.setLayout(new GridLayout(10,0));
        ArrayList <JLabel> jLabels = new ArrayList<>();

        for (Kurs k :
                kursy) {
            JLabel jLabel = new JLabel();
            jLabel.setText(k.toString());
            jLabels.add(jLabel);
        }

        for (JLabel j :
                jLabels) {
            jFrame.getContentPane().add(j);
        }

        jFrame.setSize(1500,1000);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}
