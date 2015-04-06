package be.vdab.voertuigen;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;

public class Voertuig implements Comparable<Voertuig>, Comparator<Voertuig>, Serializable {

	private int aankoopprijs;
	private Mens bestuurder;
	private Datum datumEersteIngebruikname;
	//private Mens[] passagiers = new Mens[]{};
	private TreeSet<Mens> passagiers = new TreeSet<Mens>();
	private String merk;
	private final Nummerplaat nummerplaat = DIV.INSTANCE.getNummerplaat();
	private final int MAX_ZITPLAATSEN;

	//

	public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... rest) {
		if(zitplaatsen<1) throw new IllegalArgumentException("Minstens 1 zitplaats is vereist.");
		this.MAX_ZITPLAATSEN = zitplaatsen;

		setBestuurder(bestuurder);
		for(Mens m : rest) {addIngezetene(m);}

		setAankoopprijs(aankoopprijs);
		this.datumEersteIngebruikname = datumEersteIngebruikname;
		setMerk(merk);
	}

	//

	public static Comparator<Voertuig> getAankoopprijsComparator() {}
	public static Comparator<Voertuig> getMerkComparator() {}

	//

	public void addIngezetene(Mens m) {
		if(!this.bestuurder.equals(m)) this.passagiers.add(m);
		if(this.passagiers.size()==MAX_ZITPLAATSEN) throw new MensException("Er kan niemand meer bij, voertuig volzet.");
	}

	@Override
	public int compare(Voertuig v1, Voertuig v2) {
		return v1.getNummerplaat().compareTo(v2.getNummerplaat());
	}

	@Override
	public int compareTo(Voertuig v) {
		return this.toString().compareTo(v.toString());
	}

	public int getAankoopprijs() {return this.aankoopprijs;}
	public Mens getBestuurder() {return this.bestuurder;}
	public Datum getDatumEersteIngebruikname() {return this.datumEersteIngebruikname;}
	public TreeSet<Mens> getIngezeteneExclusiefBestuurder() {return this.passagiers;}
	public TreeSet<Mens> getIngezetenen() {
		TreeSet<Mens> allen = new TreeSet<Mens>(this.passagiers);
		allen.add(this.bestuurder);
		return allen;
	}
	public String getMerk() {return this.merk;}
	public Nummerplaat getNummerplaat() {return this.nummerplaat;}
	public boolean isIngezetene(Mens m) {return this.passagiers.contains(m) || this.bestuurder.equals(m);}
	public void setAankoopprijs(int i) {this.aankoopprijs = i;}

	public void setBestuurder(Mens m) {
		if(!geldigeBestuurder(m)) throw new MensException("Kandidaat-bestuurder is onvoldoende gekwalificeerd.");
		if(this.passagiers.contains(m)) this.passagiers.remove(m);
		if(this.bestuurder!=null) addIngezetene(this.bestuurder);
		this.bestuurder = m;
	}

	public void setDatumEersteIngebruikname(Datum d) {this.datumEersteIngebruikname = d;}

	public void setMerk(String s) {this.merk = s;}

	@Override
	public String toString() {
		//StringBuilder s = new StringBuilder();

		return String.format("%s %s %s %d %s %s", nummerplaat.toString(), merk, datumEersteIngebruikname.toString(), aankoopprijs, bestuurder.toString(), passagiers.toString());
	}

	//

	private boolean geldigeBestuurder(Mens m) {
		return m.getRijbewijs().length>0;
	}

}
