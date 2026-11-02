package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) {
		MidtermPane sandbox = new MidtermPane();
		Midtermarka turtle = new Midtermarka();
		sandbox.add(turtle);

		ObjectInspector oi = new ObjectInspector();
		oi.inspect(sandbox);
		oi.inspect(turtle);
	}
}
