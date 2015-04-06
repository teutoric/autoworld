package be.vdab.util;

public enum Maat {

	centimeter,
	decimeter,
	meter;

	public int toInt() {
		switch(this){
		case centimeter: return 1;
		case decimeter: return 10;
		case meter: default: return 100;
		}
	}

}
