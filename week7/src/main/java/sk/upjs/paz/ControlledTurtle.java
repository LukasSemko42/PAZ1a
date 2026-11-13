package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControlledTurtle extends Turtle {
    public void executeFile(File file){
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String currentCommand = scanner.next();
                switch (currentCommand) {
                    case "setPosition": {
                        int val1 = scanner.nextInt();
                        int val2 = scanner.nextInt();
                        this.setPosition(val1, val2);
                        break;
                    }
                    case "step": {
                        int val1 = scanner.nextInt();
                        this.step(val1);
                        break;
                    }
                    case "turn": {
                        int val1 = scanner.nextInt();
                        this.turn(val1);
                        break;
                    }
                    case "dot": {
                        int val1 = scanner.nextInt();
                        this.dot(val1);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}