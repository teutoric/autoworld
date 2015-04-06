package be.vdab.util;

public interface Laadbaar {

	// Eclipse complains about the keyword 'default' marking method definitions:

	//default Volume getLaadvolume() {return this.volume;}
	//default void setLaadvolume(Volume v) {this.volume = v;}


	// Alternatively (but the instructions are 'define' not 'declare'),
	// these methods could be left 'abstract', 'declared' to be implemented:

	Volume getLaadvolume();
	void setLaadvolume(Volume v);

}
