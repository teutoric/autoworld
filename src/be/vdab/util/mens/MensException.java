package be.vdab.util.mens;

public class MensException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MensException() {super();}

	public MensException(String s) {super(s);}

	public MensException(String s, Throwable e) {super(s, e);}

	public MensException(Throwable e) {super(e);}

}
