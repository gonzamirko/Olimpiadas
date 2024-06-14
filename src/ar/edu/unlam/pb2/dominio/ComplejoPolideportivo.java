package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplejoPolideportivo extends Complejo {
private List <AreaDesignada> areasDesignadas;
private Map< String , AreaDesignada > mapa;

	public ComplejoPolideportivo(String nombre, Double areaTotalOcupada,AreaDesignada areasDesignadas) {
		super(nombre, areaTotalOcupada);
		this.areasDesignadas = new ArrayList<>();
		this.areasDesignadas.add(areasDesignadas);
		this.mapa = new HashMap<String, AreaDesignada>();
		
	}
	@Override
	public Boolean agregarEvento(Evento evento) {
		return super.getEventos().add(evento);
	}
	
	public Boolean agregarAreaDesignada(AreaDesignada areaDesignada) throws IndicadorAreaException {
		for (AreaDesignada areaDesignadaEncontrada : areasDesignadas) {
			if(areaDesignadaEncontrada.equals(areaDesignada)) {
				throw new IndicadorAreaException("indicador repetido");
			}
		}
		
		return areasDesignadas.add(areaDesignada);
	}
	
	public void agregarComplejoPolideportivoAlMapa(String nombre, AreaDesignada areaDesignada){ //Map< String , AreaDesignada> 
		mapa.put(nombre, areaDesignada);
	}
	public Map<String, AreaDesignada> getMapa() {
		return mapa;
	}
	public void setMapa(Map<String, AreaDesignada> mapa) {
		this.mapa = mapa;
	}
	public List<AreaDesignada> getAreasDesignadas() {
		return areasDesignadas;
	}
	public void setAreasDesignadas(List<AreaDesignada> areasDesignadas) {
		this.areasDesignadas = areasDesignadas;
	}
	
	
	
	
	
	

}
