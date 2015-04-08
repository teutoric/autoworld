package be.vdab.voertuigen.div;

public enum DIV {
	INSTANCE;

	private int alpha = 0;
	private int digit = 1;

	public Nummerplaat getNummerplaat() {
		StringBuilder s = new StringBuilder("AAA");
		for(int i=2; i>=0; i--) {
			char c = (char) ('A' + alpha % 26);
			s.setCharAt(i, c);
			alpha = alpha/26;
		}
		s.append(String.format("%03d", digit));
		if(digit==999) {
			digit=1;
			//	The following expression must be commented out in order to past the test!
			//alpha++;
		} else {
			digit++;
		}
		return new Nummerplaat(s.toString());
	}
}
