package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;

public class MidtermPane extends WinPane {
    Turtle[] korytnacky = new Turtle[20];

    public MidtermPane() {
        for (int i = 0; i < 20; i++) {
            korytnacky[i] = new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setDirection(Math.random()*360);
            korytnacky[i].setPosition((int)(Math.random()*6)*50,(int)(Math.random()*6)*50);
        }
    }

    public void overlap(){
        for (int i = 0; i < korytnacky.length; i++) {
            for (int j = 0; j < korytnacky.length; j++) {
                if (korytnacky[i]==korytnacky[j]){
                    continue;
                }
                if (korytnacky[i].distanceTo(korytnacky[j].getPosition())==0){
                    korytnacky[i].setFillColor(Color.yellow);
                    korytnacky[i].dot(10);
                }
            }
        }
    }
}