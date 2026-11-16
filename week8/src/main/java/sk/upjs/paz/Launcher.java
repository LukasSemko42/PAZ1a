package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.File;

public class Launcher {

	public static void main(String[] args) {
//		SmartPane pane = new SmartPane();
		ObjectInspector oi = new ObjectInspector();
//		oi.inspect(pane);
		Matica matica = new Matica(new File("week8/src/main/resources/matica.txt"));
		oi.inspect(matica);
	}
}
