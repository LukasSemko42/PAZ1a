package sk.upjs.paz;

import sk.upjs.jpaz2.JPAZUtilities;
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

    public void kroky(int pocetKrokov){
        for (int i = 0; i < pocetKrokov; i++) {
            this.krok();
            JPAZUtilities.delay(50);
        }
    }

    public void doKruhu(double polomer){
        for (int i = 0; i < korytnacky.length; i++) {
            korytnacky[i].penUp();
            korytnacky[i].center();
            korytnacky[i].turn(((double) 360 / korytnacky.length)*i);
            korytnacky[i].step(polomer);
            korytnacky[i].setDirection(0);
            korytnacky[i].penDown();
        }
    }

    public int pocetTopKorytnaciek(double zhora){
        int count=0;
        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getY()<zhora){
                count++;
            }
        }
        return count;
    }

    public void bezpecnyKruh(int indexKorytnacky){
        double radius=Double.MAX_VALUE;

        //najblizsi radius
        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i]==korytnacky[indexKorytnacky]){
                continue;
            }
            if (radius>korytnacky[indexKorytnacky].distanceTo(korytnacky[i].getPosition())){
                radius=korytnacky[indexKorytnacky].distanceTo(korytnacky[i].getPosition());
            }
        }
        korytnacky[indexKorytnacky].circle(radius);
    }

    public int laviciarka(){
        int index=0;
        double x=this.getWidth();
        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].getX()<x){
                x=korytnacky[i].getX();
                index=i;
            }
        }
        return index;
    }

    public double najblizsie(){
        double length=Double.MAX_VALUE;
        for (int i = 0; i < korytnacky.length; i++) {
            for (int j = 0; j < korytnacky.length; j++) {
                if (j==i){
                    continue;
                }
                if (korytnacky[i].distanceTo(korytnacky[j].getPosition())<length){
                    length=korytnacky[i].distanceTo(korytnacky[j].getPosition());
                }
            }
        }
        return length;
    }

    public void drag(int x, int y){
        for (int i = 0; i < korytnacky.length; i++) {
            if (korytnacky[i].distanceTo(x,y)<=10){
                korytnacky[i].setPosition(x,y);
                break;
            }
        }
    }

    protected void onMouseDragged(int x,int y, MouseEvent detail){
        drag(x,y);
    }
}
