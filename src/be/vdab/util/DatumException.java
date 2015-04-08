package be.vdab.util;

public class DatumException extends Exception {
	private static final long serialVersionUID = 1L;

	public DatumException() {}

	public DatumException(Throwable e) {super(e);}

	public DatumException(String s) {super(s);}

	public DatumException(String s, Throwable e) {super(s, e);}

}
