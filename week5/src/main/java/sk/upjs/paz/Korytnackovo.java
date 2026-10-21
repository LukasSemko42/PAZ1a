package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;

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

    public void randomTurtleMoveOnClick(int x, int y){
        korytnacky[(int)(Math.random()*10)].moveTo(x,y);
    }

    protected void onMouseClicked(int x, int y, MouseEvent detail){
        randomTurtleMoveOnClick(x,y);
    }

    public void krok(){
        for (int i = 0; i < korytnacky.length-1; i++) {
            korytnacky[i].setDirectionTowards(korytnacky[i+1].getX(),korytnacky[i+1].getY());
            korytnacky[i].step((korytnacky[i].distanceTo(korytnacky[i+1].getX(),korytnacky[i+1].getY()))/10);
        }
        korytnacky[korytnacky.length-1].setDirectionTowards(korytnacky[0].getX(),korytnacky[0].getY());
        korytnacky[korytnacky.length-1].step((korytnacky[korytnacky.length-1].distanceTo(korytnacky[0].getX(),korytnacky[0].getY()))/10);
    }
}
