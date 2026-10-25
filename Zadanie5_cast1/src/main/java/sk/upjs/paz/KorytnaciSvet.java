package sk.upjs.paz;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

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
                System.arraycopy(this.korytnacky,0,noveKorytnacky,0,this.korytnacky.length);
                noveKorytnacky[noveKorytnacky.length-1] = novaKorytnacka;

                this.korytnacky = noveKorytnacky;
        }

        @Override
        protected void onMouseClicked(int x, int y, MouseEvent detail) {
                if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
                        this.pridajKorytnacku(x, y);
                }
        }
        
        public void vystrelNaTazisko() {
                Double[] tazisko = new Double[2];
                double x=0, y=0;

                //vytvorim suradnice taziska

                for (int i = 0; i < korytnacky.length; i++) {
                        x+=korytnacky[i].getX();
                        y+=korytnacky[i].getY();
                }
                tazisko[0] = x/korytnacky.length;
                tazisko[1] = y/korytnacky.length;

                //nakreslim ciaru do taziska pre kazdu korytnacku

                for (int i = 0; i < korytnacky.length; i++) {
                        double startX=korytnacky[i].getX();
                        double startY=korytnacky[i].getY();
                        korytnacky[i].moveTo(tazisko[0], tazisko[1]);
                        korytnacky[i].setPosition(startX, startY);
                }
        }
        
        
        public double explozia(double x, double y, double sila) {
                double dlzka=0;

                //odstrelime korytnacky
                for (int i = 0; i < korytnacky.length; i++) {
                        double d=korytnacky[i].distanceTo(x,y);

                        Point2D startPos=korytnacky[i].getPosition();

                        korytnacky[i].setDirectionTowards(x,y);
                        korytnacky[i].turn(180);
                        korytnacky[i].penUp();
                        korytnacky[i].step(Math.pow(sila,2)/Math.pow(d,4));

                        //najdeme max vzdialenost
                        if (korytnacky[i].distanceTo(startPos) > dlzka) {
                                dlzka=korytnacky[i].distanceTo(startPos);
                        }
                }
                return dlzka;
        }
        
        public double casDoPrichodu(double x, double y) {
            double cas=Double.MAX_VALUE;
            double uhol=0;
            double vzdialenost=0;

            for (int i = 0; i < korytnacky.length; i++) {
                    //zistime uhol
                    double natocenieKorytnackyPred=korytnacky[i].getDirection();
                    korytnacky[i].setDirectionTowards(x,y);
                    double natocenieKorytnackyPo=korytnacky[i].getDirection();
                    double rozdiel = Math.abs(natocenieKorytnackyPo - natocenieKorytnackyPred);
                    uhol = Math.min(rozdiel, 360 - rozdiel);


                    //vratime naspat uhol otocenia
                    korytnacky[i].setDirection(natocenieKorytnackyPred);

                    //zistime vzdialenost
                    vzdialenost=korytnacky[i].distanceTo(x,y);

                    //nastavime novy cas ak je mensi nez predosly
                    double novyCas=vzdialenost+uhol;
                    if (novyCas<cas){
                            cas=novyCas;
                    }
            }
            return cas;
        }
}