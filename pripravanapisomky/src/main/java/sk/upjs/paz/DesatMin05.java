package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class DesatMin05 extends WinPane {
        private Turtle[] korytnacky = null;

        public DesatMin05() {
                this.korytnacky = new Turtle[0];
        }

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

        public int inMySquare(int index, double size){
                int count=0;

                //parametre stvorca
                double xMin=0;
                double xMax=0;
                double yMin=0;
                double yMax=0;

                xMin=korytnacky[index].getX()-size/2;
                xMax=xMin+size;
                yMin=korytnacky[index].getY()-size/2;
                yMax=yMin+size;

            for (Turtle turtle : korytnacky) {
                if (turtle != korytnacky[index]) {
                    double xKor = turtle.getX();
                    double yKor = turtle.getY();
                    if ((xKor >= xMin && xKor <= xMax) && (yKor >= yMin && yKor <= yMax)) {
                        count++;
                    }
                }
            }
            return count;
        }
}