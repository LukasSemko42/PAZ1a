package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		MidtermPane pane = new MidtermPane();
		ObjectInspector oi= new ObjectInspector();

		oi.inspect(pane);
		
	}
}
