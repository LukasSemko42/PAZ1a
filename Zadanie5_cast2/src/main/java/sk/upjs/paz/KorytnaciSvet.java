package sk.upjs.paz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends WinPane {
        /**
         * Referencia na pole korytnaciek
         */
        private Turtle[] korytnacky = null;

        /**
         * Inicializacna metoda (konstruktor)
         */
        public KorytnaciSvet() {
                this.korytnacky = new Turtle[0];
        }

        /**
         * Metoda na pridanie korytnacky na zadanych suradniciach
         */
        public void pridajKorytnacku(int x, int y) {
                Turtle novaKorytnacka = new Turtle();
                this.add(novaKorytnacka);
                novaKorytnacka.setPosition(x, y);

                Turtle[] noveKorytnacky = new Turtle[this.korytnacky.length + 1];
                System.arraycopy(this.korytnacky, 0, noveKorytnacky, 0, this.korytnacky.length);
                noveKorytnacky[noveKorytnacky.length-1] = novaKorytnacka;

                this.korytnacky = noveKorytnacky;
        }

        @Override
        protected void onMouseClicked(int x, int y, MouseEvent detail) {
                if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
                        this.pridajKorytnacku(x, y);
                }
        }
        
        public int[] histogram(double x, double y, double d) {
            return null;
        }

        public void testHistogram(double x, double y, double d) {
                int[] p = this.histogram(x, y, d);
                System.out.print("histogram(" + x + ", " + y + ", " + d + "): ");
                System.out.println(Arrays.toString(p));
        }
        
        public void doStvorca(double dlzkaStrany) {

        }

        public void prestrelka(int idxPrvehoStrelca, Color farbaStriel) {
                boolean[] isZasiahnuta = new boolean[this.korytnacky.length];
                int aktualnyStrelec = idxPrvehoStrelca;

                for (int i = 0; i < korytnacky.length; i++) {
                        double minDistance = Double.MAX_VALUE;
                        int indexCiela = -1;

                        // Nájdi najbližšiu NEZASIAHNUTÚ korytnačku k aktuálnemu strelcovi
                        for (int j = 0; j < korytnacky.length; j++) {
                                if (j != aktualnyStrelec && !isZasiahnuta[j]) {
                                        double distance = korytnacky[aktualnyStrelec].distanceTo(korytnacky[j].getPosition());
                                        if (distance < minDistance) {
                                                minDistance = distance;
                                                indexCiela = j;
                                        }
                                }
                        }

                        //Ak ma ciel tak striela
                        if (indexCiela != -1) {
                                Point2D cielPos = korytnacky[indexCiela].getPosition();

                                korytnacky[aktualnyStrelec].turnTowards(cielPos);
                                korytnacky[aktualnyStrelec].setPenColor(farbaStriel);

                                korytnacky[aktualnyStrelec].step(minDistance);
                                korytnacky[aktualnyStrelec].step(-minDistance);

                                isZasiahnuta[indexCiela] = true;
                                aktualnyStrelec = indexCiela;
                        }
                }
        }
}