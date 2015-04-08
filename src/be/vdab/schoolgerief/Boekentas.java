package be.vdab.schoolgerief;

import java.io.Serializable;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

public class Boekentas implements Laadbaar, Serializable {
	private static final long serialVersionUID = 1L;

	private String kleur;
	private Volume laadvolume;

	//

	public Boekentas(String kleur, Volume laadvolume) {
		setKleur(kleur);
		if(laadvolume==null) throw new IllegalArgumentException("Boekentas zonder laadvermogen?!");
		this.laadvolume = laadvolume;
	}

	//

	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if(o instanceof Boekentas) {
			Boekentas b = (Boekentas) o;
			if(this.toString().equals(b.toString())) return true;
		}
		return false;
	}

	public String getKleur() {return this.kleur;}

	@Override
	public Volume getLaadvolume() {return this.laadvolume;}

	public void setKleur(String s) {
		if(s==null) throw new IllegalArgumentException("Kleur vereist!");
		this.kleur = s;
	}

	@Override
	public int hashCode() {return this.toString().hashCode();}

	@Override
	public void setLaadvolume(Volume v) {
		if(v==null) throw new IllegalArgumentException("Volume vereist!");
		this.laadvolume = v;
	}

	@Override
	public String toString() {return String.format("boekentas %s %s", this.kleur, this.laadvolume);}

}
