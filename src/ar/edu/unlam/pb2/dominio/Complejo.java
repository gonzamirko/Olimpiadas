package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Complejo {
	private String nombre;
	private Double areaTotalOcupada;
	private List <Evento> eventos;
	
	public Complejo(String nombre, Double areaTotalOcupada) {
		this.nombre = nombre;
		this.areaTotalOcupada = areaTotalOcupada;
		this.eventos = new 	ArrayList<>();
	}
	
	
	public abstract Boolean agregarEvento(Evento evento);


	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}


	public Integer obtenerTotalDeParticipantesDeTodosLosEventos() {
		Integer total = 0;
		for (Evento evento : eventos) {
//			if( Complejo complejo instanceof ComplejoSimple)
			total += evento.getParticipantes().size();
		}
		return total;
	}


	
		
	
	
	
}
