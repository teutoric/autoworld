package be.vdab.voertuigen;

import org.apache.commons.lang3.Validate;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;

public class Vrachtwagen extends Voertuig implements Laadbaar {

	private int aantalAssen;
	private Volume laadvolume;
	private int maximaalToegelatenMassa;

	public Vrachtwagen(String merk, Datum datum, int aankoopprijs, int zitplaatsen,
			Volume volume, int maxToegelatenMassa, int assen, Mens bestuurder, Mens... rest) {
		super(merk, datum, aankoopprijs, zitplaatsen, bestuurder, rest);
		setAantalAssen(assen);
		setMaximaalToegelatenMassa(maxToegelatenMassa);
		setLaadvolume(volume);
	}

	//

	public int getAantalAssen() {return this.aantalAssen;}

	public Volume getLaadvolume() {return this.laadvolume;}

	@Override
	protected final int getMAX_ZITPLAATSEN() {return 3;}

	public int getMaximaalToegelatenMassa() {return this.maximaalToegelatenMassa;}

	@Override
	protected final Rijbewijs[] getToegestaneRijbewijzen() {return new Rijbewijs[]{Rijbewijs.B, Rijbewijs.BE, Rijbewijs.C, Rijbewijs.CE};}

	public void setAantalAssen(int i) {
		try {
			Validate.notNull(i, "Aantal assen kan niet '%s' zijn", "null");
			this.aantalAssen = i;
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void setLaadvolume(Volume v) {
		try {
			Validate.notNull(v);
			//Validate.isTrue(v.getVolume() <= getMaximaalToegelatenMassa());
			this.laadvolume = v;
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void setMaximaalToegelatenMassa(int i) {
		this.maximaalToegelatenMassa = i;
	}

	public String toString() {
		return String.format("%s assen:%d, maximaal toegelaten massa:%d, laadvolume:%s", super.toString(), aantalAssen, getMaximaalToegelatenMassa(), laadvolume);
	}

}
