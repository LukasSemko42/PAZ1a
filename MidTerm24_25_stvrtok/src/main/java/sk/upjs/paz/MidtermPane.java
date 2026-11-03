package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;

public class MidtermPane extends WinPane {
    Turtle[] korytnacky = new Turtle[12];

    public MidtermPane(){
        for (int i = 0; i < korytnacky.length; i++) {
            korytnacky[i]=new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(Math.random()*this.getWidth(),Math.random()*this.getHeight());
            korytnacky[i].turn((Math.random()>0.5 ? 90 : 270 ));
//            korytnacky[i].turn((int)(Math.random()*2)*180+90);
        }
    }

    public int bestSeeker(){
        int count=0;
        for (int i = 0; i < korytnacky.length; i++) {
            for (int j = 0; j < korytnacky.length; j++) {
                if (korytnacky[i]==korytnacky[j]){
                    continue;
                }

                if (korytnacky[i].getX()>korytnacky[j].getX() && korytnacky[j].getDirection()==90
                        && korytnacky[i].getDirection() ==270){
                    korytnacky[i].setPenColor(Color.red);
                    count++;
                }
            }
        }
        return count;
    }
}
