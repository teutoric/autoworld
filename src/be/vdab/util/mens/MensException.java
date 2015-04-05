package be.vdab.util.mens;

@SuppressWarnings("serial")
public class MensException extends RuntimeException {

	public MensException() {super();}

	public MensException(String s) {super(s);}

	public MensException(String s, Throwable e) {super(s, e);}

	public MensException(Throwable e) {super(e);}

}
