package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;

public class Clickpane extends WinPane {
    double[] coords;
    File file;

    public Clickpane(){
        this.file =  new File("C:\\Users\\Lukas_S\\IdeaProjects\\PAZ\\week7\\src\\main\\resources\\coords.txt");
        try (PrintWriter pw = new PrintWriter(file)){//nech sa vycisti subor
            System.out.println("*-File "+file.getName()+" cleared-*");
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
    //kreslenie bodky na mieste
    public void dot(int x, int y){
        Turtle bodka = new Turtle();
        this.add(bodka);
        bodka.setPosition(x,y);
        bodka.dot(2+Math.random()*3);
        this.remove(bodka);

    }
    //ulozenie coords kliknutia
    public void saveCurrentCoords(int x, int y){
        this.coords = new double[2];
        this.coords[0]=x;
        this.coords[1]=y;
        System.out.println("Current coords: "+ Arrays.toString(coords));
    }
    //ulozi coords do suboru
    public void saveClicksToFile(File output){
        try (PrintWriter pw = new PrintWriter(new FileWriter(output, true))) {
            pw.print("x: "+coords[0]+"\n"+"y: "+coords[1]+"\n"+"------"+"\n");
            System.out.println("*-Coords saved-*"+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        dot(x,y);
        saveCurrentCoords(x,y);
        saveClicksToFile(file);
    }
}
