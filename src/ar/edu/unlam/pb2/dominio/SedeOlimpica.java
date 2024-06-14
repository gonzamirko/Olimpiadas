package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;

public class SedeOlimpica {
private List<Complejo>complejos;


	
	public SedeOlimpica() {
	
	this.complejos = new ArrayList<>();
}



	public Boolean crearComplejo(Complejo complejo) {
		
		return complejos.add(complejo);
	}

}
