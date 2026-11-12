package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextTurtle extends Turtle {
    public double average(File file){
        int count = 0,numCount=0;
        try (Scanner reader = new Scanner(file)){
            while (reader.hasNextInt()){
                int cislo=reader.nextInt();
                numCount++;
                count+=cislo;
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        if (numCount==0){
            throw new ArithmeticException();
        }
        return (double)count/numCount;
    }
}
