package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestOlimpiadas {

	private  SedeOlimpica sede;
	private Complejo complejoSimple;
	private Complejo complejoPolideportivo;
	private Evento evento;
	private Comisario comisarioJuez;
	private Comisario comisarioObservador;
	private Participante participante;
	@Before
	public void setUp() {
	 this.sede = new SedeOlimpica();
	 this.complejoSimple = new ComplejoSimple("complejo", 12.0);
	 this.complejoPolideportivo = new ComplejoPolideportivo("complejito",12.0,AreaDesignada.CENTRO);
	 this.evento = new Evento(LocalDate.of(2024, 06, 13),20.0,30,2);
	 this.comisarioJuez = new Comisario(1,"luquita",40,TipoDeComisario.JUEZ);
	 this.comisarioObservador = new Comisario(1,"luquita",40,TipoDeComisario.OBSERVADOR);
	 this.participante = new Participante(1,"luquita",40);
	}
	
	@Test
	public void queSePuedaCrearUnComplejoSimpleEnUnaSedeOlimpica(){
		Boolean seCreo = this.sede.crearComplejo(this.complejoSimple);
		assertTrue(seCreo);
	}
	
	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaEnUnaSedeOlimpica() {
		Boolean seCreo = this.sede.crearComplejo(this.complejoPolideportivo);
		assertTrue(seCreo);
	}
	
	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaYUnEventoEnUnaSedeOlimpica() {
		this.sede.crearComplejo(this.complejoPolideportivo);
		Boolean seAgrego = this.complejoPolideportivo.agregarEvento(this.evento);
		assertTrue(seAgrego);
	}
	
	@Test (expected = IndicadorAreaException.class)
	public void queAlAgregarUnAreaAUnPolideportivoConIndicadorYaExistenteLanceUnaExcepcionIndicadorAreaException() throws IndicadorAreaException {
		this.sede.crearComplejo(this.complejoPolideportivo);
		((ComplejoPolideportivo) this.complejoPolideportivo).agregarAreaDesignada(AreaDesignada.CENTRO);
		
	}
	
	@Test
	public void queSePuedaAgregarUnComisarioJuezAUnEvento() {
		this.sede.crearComplejo(this.complejoSimple);
		this.complejoSimple.agregarEvento(this.evento);
		Boolean seAgrego = this.evento.agregarComisario(this.comisarioJuez);
		assertTrue(seAgrego);
	}


 @Test
 public void queSePuedaCalcularElTotalDeParticipantesDeLosEventosDeUnComplejoSimple() {
		this.sede.crearComplejo(this.complejoSimple);
		this.complejoSimple.agregarEvento(this.evento);
		Evento evento2 = new Evento(LocalDate.of(2024, 07, 13),30.0,50,3);
		this.complejoSimple.agregarEvento(evento2);
		this.evento.agregarParticipantes(this.participante);
		evento2.agregarParticipantes(participante);
		Integer totalDeParticipantesObtenido = this.complejoSimple.obtenerTotalDeParticipantesDeTodosLosEventos();
		Integer totalDeParticipantesEsperado = 2;
		assertEquals(totalDeParticipantesObtenido,totalDeParticipantesEsperado);
 }
 
 @Test 
 public void queSePuedaCalcularElPromedioDeEdadDeLosComisariosObservadoresDeUnEventoEspecifico() {
	 this.sede.crearComplejo(complejoPolideportivo);
	 this.complejoSimple.agregarEvento(this.evento);
	Comisario comisario2 = new Comisario(2,"luquita",40,TipoDeComisario.OBSERVADOR);
	 this.evento.agregarComisario(comisarioObservador);
	 this.evento.agregarComisario(comisario2);
	 this.evento.agregarComisario(comisarioJuez);
	Double edadPromedioDeComisarioObservadorObtenida = this.evento.calcularPromedioEdadDeLosComisariosObservadores();
	Double edadPromedioDeComisarioObservadorEsperada = 40.0;
	
	assertEquals(edadPromedioDeComisarioObservadorObtenida, edadPromedioDeComisarioObservadorEsperada);
 }
 
 @Test
 public void queSePuedaObtenerUnaListaDeComisariosJuecesDeUnEventoEspecificoSinRepeticiones() {
	 this.sede.crearComplejo(complejoPolideportivo);
	 this.complejoSimple.agregarEvento(this.evento);
	 this.evento.agregarComisario(comisarioJuez);
	Comisario comisario =  new Comisario(1,"luquita",40,TipoDeComisario.JUEZ);
	 this.evento.agregarComisario(comisario);
	 this.evento.obtenerListaDeComisarioJueces();
//	 Integer i = 0;
//	for (Comisario comisario2 : evento.getComisarios()) {
//		if(i==0) {
//			assertTrue(comisario2.equals(comisarioJuez));
//		}
//		if(i==1) {
//			assertTrue(comisario2.equals(comisario));
//		}
//		i++;
//	}
	 
	Integer valorObtenido= this.evento.obtenerListaDeComisarioJueces().size();
	Integer valorEsperado = 1;
	assertEquals(valorObtenido, valorEsperado);
 }
 
 @Test
 public void queSePuedaObtenerUnMapaDeUnComplejoPolideportivoConNombreDeComplejoYUbicacion() {
	 this.sede.crearComplejo(complejoPolideportivo);
	 ((ComplejoPolideportivo) this.complejoPolideportivo).agregarComplejoPolideportivoAlMapa("nombre", AreaDesignada.CENTRO);
	 
	 Map<String, AreaDesignada> mapa = ((ComplejoPolideportivo) complejoPolideportivo).getMapa();
	 
	 AreaDesignada valorObtenido= mapa.get("nombre");
	 
	 AreaDesignada valorEsperado = AreaDesignada.CENTRO;
	 
	 assertEquals(valorObtenido,valorEsperado);
	 
	 
	 
	 
 }



	
	

}
