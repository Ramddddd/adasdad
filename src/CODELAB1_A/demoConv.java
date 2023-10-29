package CODELAB1_A;

import java.util.Scanner;

public class demoConv {
     double meter;
    private double cm;
    private double mm;

    public void convCM() {
        cm = meter * 100;
    }

    public void convMM() {
        mm = meter * 1000;
    }

    public void dispConv() {
        System.out.println("Nilai " + meter + " meter sama dengan:");
        System.out.printf("%.0f sentimeter\n", cm);
        System.out.println(mm + " milimeter");
    }

    public static void main(String[] args) {
        demoConv conv = new demoConv();
        Scanner inputUser = new Scanner(System.in);
        System.out.print("Masukkan nilai meter: ");
        conv.meter = inputUser.nextDouble();
        conv.convCM();
        conv.convMM();
        conv.dispConv();
    }
}

