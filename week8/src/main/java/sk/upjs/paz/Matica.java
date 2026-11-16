package sk.upjs.paz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Matica {
    private double[][] pole;
    private int pocetRiadkov;
    private int pocetStlpcov;

    /**
     * Vytvori maticu zo samych 0 so zadanymi rozmermi
     */
    public Matica(int pocetRiadkov, int pocetStlpcov) {
        this.pocetRiadkov=pocetRiadkov;
        this.pocetStlpcov=pocetStlpcov;
        this.pole= new double[pocetRiadkov][pocetStlpcov];
        for (int i = 0; i < pocetRiadkov; i++) {
            for (int j = 0; j < pocetStlpcov; j++) {
                this.pole[i][j]=0;
            }
        }
    }

    /**
     * Vytvori maticu na zaklade obsahu matice v textovom subore
     * @param subor cesta k suboru s obsahom matice
     */
    public Matica(File subor) {
        int pocetRiadkov=0;
        int pocetStlpcov=0;
        try (Scanner sc = new Scanner(subor)){
            sc.useLocale(java.util.Locale.US);
            if (sc.hasNextLine()){
                String riadok = sc.nextLine();
                pocetRiadkov++;
                String[] obsahRiadku=riadok.split(" ");
                pocetStlpcov=obsahRiadku.length;
            }
            while(sc.hasNextLine()){
                pocetRiadkov++;
                sc.nextLine();
            }
            this.pocetRiadkov=pocetRiadkov;
            this.pocetStlpcov=pocetStlpcov;
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }

        try (Scanner sc = new Scanner(subor)) {
            this.pole=new double[pocetRiadkov][pocetStlpcov];
            sc.useLocale(java.util.Locale.US);
            for (int i = 0; i < pocetRiadkov; i++) {
                for (int j = 0; j < pocetStlpcov; j++) {
                    double cislo = sc.nextDouble();
                    this.pole[i][j]=cislo;
                }
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Vrati pocet riadkov matice
     */
    public int getPocetRiadkov() {
        return this.pocetRiadkov;
    }

    /**
     * Vrati pocet stlpcov matice
     * @return
     */
    public int getPocetStlpcov() {
        return this.pocetStlpcov;
    }

    /**
     * Nastavi hodnotu v policku (elemente) v definovanom riadku a stlpci na
     * zadanu hodnotu.
     */
    public void nastav(int riadok, int stlpec, double hodnota) {
        if (riadok<=pocetRiadkov-1 && stlpec<=pocetStlpcov-1){
            this.pole[riadok][stlpec]=hodnota;
        } else System.err.println("Taky riadok/stlpec neexistuje");
    }

    /**
     * Vrati hodnotu policka (elementu) v definovanom riadku
     * a stlpci.
     */
    public double vrat(int riadok, int stlpec) {
        if (riadok<=pocetRiadkov-1 && stlpec<=pocetStlpcov-1){
            return this.pole[riadok][stlpec];
        } else {
            System.err.println("Taky riadok/stlpec neexistuje");
            return 0;
        }
    }

    /**
     * Ulozi maticu do suboru
     */
    public void ulozDoSuboru(File subor) {
        try (PrintWriter pw = new PrintWriter(subor)){
            for (int i = 0; i < pocetRiadkov; i++) {
                for (int j = 0; j < pocetStlpcov; j++) {
                    pw.print(pole[i][j]+" ");
                }
                pw.print("\n");
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Vrati referenciu na novovytvorenu maticu, ktore je
     * suctom tejto matice a matice referencovanej z parametra
     * m. V pripade, ze scitane matice su nekompatibilne, metoda
     * nech vrati null.
     */
    public Matica scitajS(Matica m) {
        if (this.pocetRiadkov!=m.getPocetRiadkov() || this.pocetStlpcov!=m.getPocetStlpcov()){
            System.err.println("Nekompatibilne matice");
            return null;
        }
        Matica novaMatica = new Matica(pocetRiadkov,pocetStlpcov);
        for (int i = 0; i < pocetRiadkov; i++) {
            for (int j = 0; j < pocetStlpcov; j++) {
                novaMatica.nastav(i,j,this.vrat(i,j)+m.vrat(i,j));
            }
        }
        return novaMatica;
    }

    /**
     * Pre mierne pokrocilych:
     * Transformuje maticu do tvaru diagolnálnej matice
     * aplikovaním gaussovej eliminačnej metódy.
     */
    public void gem() {
        // ???
    }
}