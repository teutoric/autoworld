package be.vdab.voertuigen;

import java.awt.Color;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;

public class Pickup extends Personenwagen implements Laadbaar {

	private Volume volume;

	public Pickup(String merk,
			Datum datumEersteIngebruikname,
			int aankoopprijs,
			int zitplaatsen,
			Color kleur,
			Mens bestuurder,
			Mens... rest) {
		super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, kleur,
				bestuurder, rest);
	}

	public Pickup(String merk,
			Datum datumEersteIngebruikname,
			int aankoopprijs,
			int zitplaatsen,
			Color kleur,
			Volume volume,
			Mens bestuurder,
			Mens... rest) {
		super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, kleur,
				bestuurder, rest);
		this.volume = volume;
	}

	//

	@Override
	public Volume getLaadvolume() {return this.volume;}

	@Override
	public void setLaadvolume(Volume v) {this.volume = v;}

	@Override
	public String toString() {
		return super.toString()+" "+this.getLaadvolume().toString();
	}

}
