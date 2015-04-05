package be.vdab.util;

@SuppressWarnings("serial")
public class DatumException extends Exception {

	public DatumException() {}

	public DatumException(Throwable e) {super(e);}

	public DatumException(String s) {super(s);}

	public DatumException(String s, Throwable e) {super(s, e);}

}
