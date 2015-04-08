package be.vdab.util;

import java.io.Serializable;
import java.util.Arrays;

public final class Datum implements Comparable<Datum>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private final int dag;
	private final int maand;
	private final int jaar;

	//

	public Datum(int dag, int maand, int jaar) throws DatumException {
		if(jaar<1583 || jaar>4099 || maand<1 || maand>12 || dag<1 || dag>31) throw new DatumException();
		int[] m30 = {4,6,9,11};
		if(Arrays.asList(m30).contains(maand) && dag>30) throw new DatumException();
		if(maand==2) {
			if(jaar%400==0) {
				if(dag>29) throw new DatumException();
			} else if(jaar%100==0) {
				if(dag>28) throw new DatumException();
			} else if(jaar%4==0) {
				if(dag>29) throw new DatumException();
			} else
				if(dag>28) throw new DatumException();
		}
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar;
	}

	//

	@Override
	public int compareTo(Datum d) {
		int result = this.getJaar() - d.getJaar();
		if(result==0) result = this.getMaand() - d.getMaand();
		if(result==0) result = this.getDag() - d.getDag();
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof Datum) {
			Datum d = (Datum) o;
			if(this.getDag()==d.getDag() && this.getMaand()==d.getMaand() && this.getJaar()==d.getJaar()) return true;
		}
		return false;
	}

	public int getDag() {return this.dag;}
	
	public int getJaar() {return this.jaar;}
	
	public int getMaand() {return this.maand;}

	@Override
	public int hashCode() {return String.format("%4d%02d%02d", this.jaar, this.maand, this.dag).hashCode();}

	@Override
	public String toString() {return String.format("%02d/%02d/%04d", this.dag, this.maand, this.jaar);}

}
