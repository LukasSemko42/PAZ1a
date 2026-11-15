package sk.upjs.paz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ZoznamBodov {
    private Bod[] body;
    private int pocetBodov;

    public ZoznamBodov() {
        this.body = new Bod[20];
        this.pocetBodov = 0;
    }

    public ZoznamBodov(File file){
        this();
        this.nacitajZoSuboru(file);
    }

    public void pridajBod(Bod bod){
        if (this.pocetBodov==this.body.length){
            Bod[] temp=body;
            this.body=new Bod[this.pocetBodov+20];
            System.arraycopy(temp,0,this.body,0,temp.length);
        }
        this.body[this.pocetBodov]=bod;
        this.pocetBodov++;
    }

    public int dlzka(){
        return this.pocetBodov;
    }

    public Bod dajBod(int index){
        if (index>=0 && index<this.pocetBodov){
            return this.body[index];
        }
        else return null;
    }

    public void vymaz(){
        this.pocetBodov=0;
        this.body=new Bod[20];
    }

    public double dlzkaSpojnic(){
        double dlzka=0;
        for (int i = 1; i < pocetBodov; i++) {
            dlzka+=(body[i].vzdialenostK(body[i-1]));
        }
        return dlzka;
    }

    public String toString(){
        StringBuilder s=new StringBuilder();
        s.append("[");
        for (int i = 0; i < pocetBodov; i++) {
            if (i==pocetBodov-1){
                s.append(body[i].toString());
            } else {
                s.append(body[i].toString());
                s.append(",");
            }
        }
        s.append("]");
        return s.toString();
    }

    public void odoberBod(int index){
        if (index>=0 && index<this.pocetBodov){
            for (int i = index; i < pocetBodov-1; i++) {
                this.body[i]=this.body[i+1];
            }
            this.body[this.pocetBodov-1]=null;
            this.pocetBodov--;
        }
    }

    public boolean pridajBodAkSaTamNenachadza(Bod bod){
        for (int i = 0; i < this.pocetBodov; i++) {
            if (this.body[i].rovnakeSuradnice(bod)){
                return false;
            }
        }
        this.pridajBod(bod);
        return true;
    }

    public void ulozDoSuboru(File subor){
        try (PrintWriter pw = new PrintWriter(subor)){
            for (int i = 0; i < pocetBodov; i++) {
                pw.println(this.body[i].getX()+" "+this.body[i].getY());
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    public void nacitajZoSuboru(File subor){
        try (Scanner sc = new Scanner(subor)){
            sc.useLocale(java.util.Locale.US);
            while (sc.hasNextDouble()){
                double x=sc.nextDouble();
                double y=sc.nextDouble();
                this.pridajBod(new Bod(x,y));
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}
