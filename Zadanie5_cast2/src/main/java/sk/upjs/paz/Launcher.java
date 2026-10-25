package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		KorytnaciSvet obj = new KorytnaciSvet();
		ObjectInspector objectInspector = new ObjectInspector();
		objectInspector.inspect(obj);
	}
}