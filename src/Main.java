import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;

/*
 * VDAB autoworld Main
 */
public class Main {

	public static void main(String[] args) throws DatumException, VolumeException {
		Mens m1 = new Mens("Bartholomee", Rijbewijs.B);
		Mens m2 = new Mens("Isidoor", Rijbewijs.BE);
		Mens m3 = new Mens("Firmin", Rijbewijs.A, Rijbewijs.B, Rijbewijs.D);
		Mens m4 = new Mens("Amarylis", Rijbewijs.A, Rijbewijs.BE, Rijbewijs.CE);
		Mens m5 = new Mens("Pollux", Rijbewijs.C);
		Mens m6 = new Mens("Castor", Rijbewijs.CE);

		TreeSet<Voertuig> setA = new TreeSet<Voertuig>();
		setA.add(new Personenwagen("Lada", new Datum(1,1,2015), 8300, 5, Color.gray, m1) );
		setA.add(new Personenwagen("Triumph", new Datum(13,2,1954), 5300, 3, Color.red, m3) );
		setA.add(new Pickup("Dodge", new Datum(13,9,1983), 18700, 3, Color.black, new Volume(4,3,1,Maat.meter), m2) );
		setA.add(new Pickup("Volvo", new Datum(18,4,1965), 9200, 5, Color.white, new Volume(3,3,2,Maat.meter), m5) );
		setA.add(new Vrachtwagen("Daf", new Datum(3,12,1978), 25300, 3, new Volume(18,4,6,Maat.meter), 5000, 4, m4) );
		setA.add(new Vrachtwagen("Lada", new Datum(15,6,1972), 27600, 2, new Volume(25,4,6,Maat.meter), 15000, 6, m6) );

		System.out.println("De originele set:");
		for(Voertuig v : setA) {
			System.out.println(v.toString());
		}

		TreeSet<Voertuig> setB = (TreeSet<Voertuig>) setA.clone();
		Comparator<Voertuig> cmpB = Voertuig.getAankoopprijsComparator();
		List<Voertuig> lstB = new ArrayList<Voertuig>(setB);
		Collections.sort(lstB, Collections.reverseOrder(cmpB));

		System.out.println("\nDe geclonede en volgens aankoopprijs geordende tweede:");
		for(Voertuig v : lstB) {
			System.out.println(v.toString());
		}

	}

}
