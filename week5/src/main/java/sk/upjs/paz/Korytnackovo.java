package sk.upjs.paz;

import jdk.internal.org.jline.utils.Colors;
import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;

public class Korytnackovo extends WinPane {
    private Turtle[] korytnacky = new Turtle[10];

    public Korytnackovo(){
        for (int i = 0; i < korytnacky.length; i++) {
            korytnacky[i]= new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(Math.random()*this.getWidth(),Math.random()*this.getHeight());
        }
    }

    public void posunITu(int idx, double dlzka){
        korytnacky[idx].step(dlzka);
    }

    public void nahodneFarby(){
        for (int i = 0; i < korytnacky.length; i++) {
            Color color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
            korytnacky[i].setPenColor(color);
        }
    }

    public Color sFarbouVon(int index){
        return korytnacky[index].getPenColor();
    }
}
