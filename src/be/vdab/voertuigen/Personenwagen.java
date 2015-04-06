package be.vdab.voertuigen;

import java.awt.Color;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;

public class Personenwagen extends Voertuig {

	private static final int MAX_ZITPLAATSEN = 8;

	private Color kleur;

	//

/*	public Personenwagen(
			String merk, Datum datumEersteIngebruikname, int aankoopprijs,
			int zitplaatsen, Mens bestuurder, Mens[] rest) {
		super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, rest);
	}
*/
	public Personenwagen(
			String merk, Datum datumEersteIngebruikname, int aankoopprijs,
			int zitplaatsen, Color kleur, Mens bestuurder, Mens... rest) {
		super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, rest);
		this.kleur = kleur;
	}

	//

	@Override
	protected int getMAX_ZITPLAATSEN() {return Personenwagen.MAX_ZITPLAATSEN;}

	@Override
	protected Rijbewijs[] getToegestaneRijbewijzen() {
		return new Rijbewijs[]{Rijbewijs.B, Rijbewijs.BE, Rijbewijs.C, Rijbewijs.CE};
	}

	//

	public Datum getDatum() {return super.getDatumEersteIngebruikname();}

	public Color getKleur() {return this.kleur;}

	public void setKleur(Color c) {this.kleur = c;}

	@Override
	public String toString() {
		return String.format("%s %s %s %d %s %d", this.getNummerplaat(), this.getMerk(), this.getDatum(), this.getAankoopprijs(), this.getBestuurder(), this.getZitplaatsen());
	}

}
