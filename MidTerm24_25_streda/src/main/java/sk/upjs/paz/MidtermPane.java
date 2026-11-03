package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class MidtermPane extends WinPane {
    private Turtle[] korytnacky;
    
    public MidtermPane(){
        this.korytnacky=new Turtle[12];

        for (int i = 0; i < korytnacky.length; i++) {
            korytnacky[i]=new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(Math.random()*this.getWidth(),Math.random()*((double) this.getWidth() /2));
            korytnacky[i].turn((int)(Math.random()*4)*90);
        }
    }

    public int runDown(){
        double maxY=0;
        int pocet=0;

        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getY()>maxY && korytnacky[i].getDirection()==180){
                maxY=korytnacky[i].getY();
            }
        }

        double vzdialenost=this.getHeight()-maxY;

        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getDirection()==180){
                pocet++;
                korytnacky[i].step(vzdialenost);
            }
        }

        return pocet;
    }
}
