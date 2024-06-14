package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Evento {

	private LocalDate fecha;
	private Double duracion;
	private Integer numeroDeParticipante;
	private Integer numeroDeJueces;
	private Set <Comisario> comisarios;
	private Set <Participante> participantes;
    
	public Evento(LocalDate fecha, Double duracion, Integer numeroDeParticipante, Integer numeroDeJueces) {
		this.fecha = fecha;
		this.duracion = duracion;
		this.numeroDeParticipante = numeroDeParticipante;
		this.numeroDeJueces = numeroDeJueces;
		this.comisarios = new TreeSet<>(new ComparadorDeComisarios());
		this.participantes = new HashSet<>();
	}

	public Boolean agregarComisario(Comisario comisario) {
	if(comisarios.size()>= getNumeroDeJueces()) {
		return false;
	}
		return comisarios.add(comisario);
	}

	public Integer getNumeroDeJueces() {
		return numeroDeJueces;
	}

	public void setNumeroDeJueces(Integer numeroDeJueces) {
		this.numeroDeJueces = numeroDeJueces;
	}

	public void agregarParticipantes(Participante participante) {
		participantes.add(participante);
		
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}
	
	

	public Set<Comisario> getComisarios() {
		return comisarios;
	}

	public void setComisarios(Set<Comisario> comisarios) {
		this.comisarios = comisarios;
	}

	public Double calcularPromedioEdadDeLosComisariosObservadores() {
		Double promedio = 0.0;
		Double promedioTotal = 0.0;
		for (Comisario comisario : comisarios) {
			if(comisario.getTipoDeComisario().equals(TipoDeComisario.OBSERVADOR)) {
				promedio += comisario.getEdad();
				promedioTotal = promedio / getComisarios().size();
			}
		}
		return promedioTotal;
	}

	public Set<Comisario> obtenerListaDeComisarioJueces() {
		TreeSet<Comisario> listaDeComisarioJuez = new TreeSet<>(new ComparadorDeComisarios());
		for (Comisario comisario : comisarios) {
			if(comisario.getTipoDeComisario().equals(TipoDeComisario.JUEZ)) {
				listaDeComisarioJuez.add(comisario);
			}
		}
		return listaDeComisarioJuez;
	}
	
	
	
	

	
}
