/*
* @Autor Frank
* Dit is een oefening.
 */

package be.vdab.voertuigen.div;

import java.io.Serializable;

/**
 *
 * @author Dieter.Taillieu
 */
public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private static final long serialVersionUID = 1L;
	
    private final String plaat;

    //

    Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    //

    @Override
    public int compareTo(Nummerplaat n) {return this.getPlaat().compareTo(n.getPlaat());}

    @Override
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o == this) return true;
    	if(o instanceof Nummerplaat) {
    		Nummerplaat n = (Nummerplaat) o;
        	return this.getPlaat().equals(n.getPlaat());
    	}
    	return false;
    }

    public String getPlaat() {return this.plaat;}

    @Override
    public int hashCode() {return this.plaat.hashCode();}

    @Override
    public String toString() {return this.getPlaat();}
}
