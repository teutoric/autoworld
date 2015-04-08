package be.vdab.util;

import java.io.Serializable;

//import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

//@SuppressWarnings("rawtypes")
public class Volume implements Comparable<Volume>, Serializable {
	private static final long serialVersionUID = 1L;

	private final int breedte;
	private final int diepte;
	private final int hoogte;
	private final Maat maat;

	//

	public Volume(int hoogte, int breedte, int diepte, Maat maat) throws VolumeException {
		if(breedte < 0 || diepte < 0 || hoogte < 0) throw new VolumeException("Negative dimension(s)/volume?!");
		this.breedte = breedte;
		this.diepte = diepte;
		this.hoogte = hoogte;
		this.maat = maat;
	}

	//

	@Override
	public int compareTo(Volume v) {
		long diff = this.getVolume() - v.getVolume();
		if(diff==0) return 0;
		if(diff<0) return -1;
		return 1;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		Volume v = (Volume) o;
		return new EqualsBuilder().
				append(breedte, v.breedte).
				append(diepte, v.diepte).
				append(hoogte, v.hoogte).
				append(maat, v.maat).
				isEquals();
	}

	public int getBreedte() {return this.breedte;}

	public int getDiepte() {return this.diepte;}

	public int getHoogte() {return this.hoogte;}

	public Maat getMaat() {return this.maat;}

	public long getVolume() {//throws VolumeException {
		long result = (long) (breedte * diepte * hoogte * Math.pow(maat.toInt(), 3));
		//if(result<0) throw new VolumeException("Negative volume?!");
		return result;// /maat.toInt();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(13,41).
				append(breedte).
				append(diepte).
				append(hoogte).
				append(maat).
				toHashCode();
	}

	@Override
	public String toString() {
		return String.format("%d(h)x%d(b)x%d(d) %s", hoogte, breedte, diepte, maat.toString());
	}
}
