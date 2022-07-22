package Uczelnia.AntyException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BledyUsera {

    public static int PodajNaturalna() {

        Scanner sc = new Scanner(System.in);
        int w;

        while(true) {

            try {
                w = sc.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Podaj liczbę: ");
                sc.next();
            }
        }
        return Math.abs(w);
    }

    public static double PodajLiczbeZPrzecinkiem() {

        Scanner sc = new Scanner(System.in);
        double w;

        while(true) {
            try {
                w = sc.nextDouble();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Podaj liczbę: ");
                sc.next();
            }
        }

        return Math.abs(w);
    }
}
