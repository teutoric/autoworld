package be.vdab.util;

import java.util.Arrays;

public final class Datum {
	private final int dag;
	private final int maand;
	private final int jaar;

	//

	public Datum(int dag, int maand, int jaar) throws DatumException {
		if(jaar<1583 || jaar>4099 || maand<1 || maand>12 || dag<1 || dag>31) throw new DatumException();
		int[] m30 = {4,6,9,11};
		if(Arrays.asList(m30).contains(maand) && dag>30) throw new DatumException();
		if(maand==2) {
			if(jaar%400==0 && dag>29) throw new DatumException();
			else if(jaar%100==0 && dag>28) throw new DatumException();
			else if(jaar%4==0 && dag>29) throw new DatumException();
			else if(dag>28) throw new DatumException();
		}
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar;
	}
}
