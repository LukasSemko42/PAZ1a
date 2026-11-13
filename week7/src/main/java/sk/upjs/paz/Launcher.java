package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.File;

public class Launcher {

	public static void main(String[] args) {
		TurtleCommander komandant = new TurtleCommander();

		System.out.println("1:");
		komandant.listDirectory(new File("C:\\Users\\Lukas_S\\IdeaProjects" +
				"\\PAZ\\week7\\src\\main\\resources\\dir01"));

		System.out.println("2:");
		System.out.println(komandant.countFiles(new File("C:\\Users\\" +
				"Lukas_S\\IdeaProjects\\PAZ\\week7\\src\\main\\resources\\dir01")));

		System.out.println("3:");
		System.out.println(komandant.totalSizeOfFilesInDirectory(new File("C:\\Users\\" +
				"Lukas_S\\IdeaProjects\\PAZ\\week7\\src\\main\\resources\\dir01")));

		System.out.println("4:");
		komandant.punishment(new File("C:\\Users\\Lukas_S\\IdeaProjects\\PAZ\\week7\\src\\main" +
				"\\resources\\dir01\\tresty.txt"),"zlobil",5);
		System.out.println("Done"+"\n");

		Clickpane pane = new Clickpane();
		TextTurtle text = new TextTurtle();

		System.out.println(text.average(new File("C:\\Users\\Lukas_S\\IdeaProjects\\PAZ" +
				"\\week7\\src\\main\\resources\\average.txt")));

		ControlledTurtle control = new ControlledTurtle();
		pane.add(control);
		control.executeFile(new File("C:\\Users\\Lukas_S\\IdeaProjects\\PAZ\\week7\\src\\main\\resources\\input.txt"));
	}
}
