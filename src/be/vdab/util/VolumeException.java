package be.vdab.util;

public class VolumeException extends Exception {
	private static final long serialVersionUID = 1L;

	public VolumeException() {}

	public VolumeException(String s) {super(s);}

	public VolumeException(String s, Throwable e) {super(s, e);}

	public VolumeException(Throwable e) {super(e);}

}
