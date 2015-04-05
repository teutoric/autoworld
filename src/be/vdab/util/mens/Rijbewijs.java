package be.vdab.util.mens;

public enum Rijbewijs {

	A,
	B,
	BE	{@Override public String toString() {return "B"+"+E";}},
	C,
	CE	{@Override public String toString() {return "C"+"+E";}},
	D,
	DE	{@Override public String toString() {return "D"+"+E";}};

}
