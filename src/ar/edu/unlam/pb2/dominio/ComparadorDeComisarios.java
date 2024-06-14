package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;

public class ComparadorDeComisarios implements Comparator<Comisario> {

	@Override
	public int compare(Comisario o1, Comisario o2) {
		return o1.getDni().compareTo(o2.getDni());
		
	}

	

}
