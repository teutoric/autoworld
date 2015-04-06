package be.vdab.util.mens;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

public class Mens implements Comparable<Mens>, Serializable {

	private String naam;
	private Set<Rijbewijs> rijbewijs = EnumSet.noneOf(Rijbewijs.class);

	//

	public Mens(String naam) {
		this.naam = naam;
	}

	public Mens(String naam, Rijbewijs r1, Rijbewijs... rest) {
		this(naam);
		this.rijbewijs = EnumSet.of(r1, rest);
	}
/*
	public Mens(String naam, Rijbewijs r1) {}

	public Mens(String naam, Rijbewijs r1, Rijbewijs r2) {}

	public Mens(String naam, Rijbewijs r1, Rijbewijs r2, Rijbewijs r3) {}

	public Mens(String naam, Rijbewijs r1, Rijbewijs r2, Rijbewijs r3, Rijbewijs r4) {}
*/
	//

	@Override
	public int compareTo(Mens m) {
		int result = this.getNaam().compareTo(m.getNaam());
		if(result==0) result = this.getRijbewijs().length - m.getRijbewijs().length;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Mens) {
			Mens m = (Mens) o;
			if(this.toString().equals(m.toString())) return true;
		}
		return false;
	}

	public String getNaam() {return this.naam;}

	public Object[] getRijbewijs() {return this.rijbewijs.toArray();}

	public int hashCode() {return this.toString().hashCode();}

	public String toString() {
		StringBuilder s = new StringBuilder(this.naam);
		if(! this.rijbewijs.isEmpty()) {
			//s.append(this.getRijbewijs());
			s.append("(");
			int i=0;
			for(Object o : this.rijbewijs) {
				if(i==0) {
					s.append(o);
				} else {
					s.append(", ").append(o);
				}
				i++;
			}
			s.append(")");
		}
		return s.toString();
	}
}
