package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;
import java.util.Objects;

public class Comisario {

	private Integer dni;
	private String nombre;
	private Integer edad;
	private TipoDeComisario tipoDeComisario;

	public Comisario(Integer dni, String nombre, Integer edad, TipoDeComisario tipoDeComisario) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.tipoDeComisario = tipoDeComisario;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public TipoDeComisario getTipoDeComisario() {
		return tipoDeComisario;
	}

	public void setTipoDeComisario(TipoDeComisario tipoDeComisario) {
		this.tipoDeComisario = tipoDeComisario;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comisario other = (Comisario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	

	
	
	

}
