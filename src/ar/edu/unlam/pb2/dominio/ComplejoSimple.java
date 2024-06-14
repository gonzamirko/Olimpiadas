package ar.edu.unlam.pb2.dominio;

public class ComplejoSimple extends Complejo {
 
	public ComplejoSimple(String nombre, Double areaTotalOcupada) {
		super(nombre, areaTotalOcupada);
		
	}

	@Override
	public Boolean agregarEvento(Evento evento) {
		return super.getEventos().add(evento);

	}

}
