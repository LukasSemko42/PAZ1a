package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		SmartPane pane = new SmartPane();
		ObjectInspector oi = new ObjectInspector();
		oi.inspect(pane);
	}
}
