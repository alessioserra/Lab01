package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	LinkedList<String> listaStringhe = new LinkedList<String>();
		
	//COSTRUTTORE
	public Parole() {
    }
	
	//Metodi
	public void addParola(String p) {
		if (p.length()>0 && p.compareTo("                                                                 ")!=0) 
			listaStringhe.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaStringhe);
		return listaStringhe;
	}
	
	public void reset() {
		listaStringhe.clear();
	}

}
