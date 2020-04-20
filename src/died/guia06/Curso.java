package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */



public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(Integer cup, Integer cred, Integer credReq) {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditos = cred;
		this.cupo = cup;
		this.creditosRequeridos=credReq;
	}
	public Curso(Integer id, String nom, Integer ciclo, Integer cup, Integer cred, Integer credReq) {
		super();
		this.id = id;
		this.nombre=nom;
		this.cicloLectivo = ciclo;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditos = cred;
		this.cupo = cup;
		this.creditosRequeridos=credReq;
	}
	
	public void inscribirAlumno(Alumno a) throws CursoException {
		
		if(a.getCursando().size()==3) {
			throw new CursoException("ERROR: El alumno " + a.getNombre() + " no puede cursar "+this.nombre + " porque no puede cursar mas de 3 materias a la vez");
		}
		
		if(this.creditosRequeridos > a.creditosObtenidos()) {
			throw new CursoException("ERROR: El alumno "+a.getNombre() +  " no tiene los creditos requeridos para inscribirse a " + this.nombre);
		}
		
		if(this.cupo <= this.inscriptos.size()) {
			throw new CursoException("ERROR: El alumno " +a.getNombre() +" no pudo inscribirse a "
					+ this.nombre + ". El curso ya tiene el cupo completo");
		}
		
		inscriptos.add(a);
		a.inscripcionAceptada(this);
		
		 
	 }
	
	
	
	public Boolean inscribir(Alumno a) {
		try {
			if(a.getCursando().size()<3 & this.cupo > this.inscriptos.size() & this.creditosRequeridos <= a.creditosObtenidos() & !(this.inscriptos.contains(a))) {
			inscriptos.add(a);
			a.inscripcionAceptada(this);
			log.registrar(this, "inscribir ",a.toString());
			}
			else return false;
		}
		catch(IOException ex){
			ex.getMessage();
			return false;
		}
		return true;
	}
	
	public void imprimirInscriptosAlfabeticamente() {
		try {
			Collections.sort(inscriptos, new Comparator<Alumno>() {
			public int compare(Alumno a1, Alumno a2) {
				return  a1.getNombre().compareTo(a2.getNombre());
			}
		});
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}
		catch(IOException ex) {
			ex.getMessage();
		}
		System.out.println("Alumnos inscriptos ordenados alfabeticamente al curso: " + this.nombre);
		for(int i=0;i<inscriptos.size();i++) {
		System.out.println(inscriptos.get(i).getNombre());
		}
		System.out.println("");
	}
	
	public void imprimirInscriptosNroLibreta() {
		try {
			Collections.sort(inscriptos, new Comparator<Alumno>() {
			public int compare(Alumno a1, Alumno a2) {
				return  a1.getNroLibreta().compareTo(a2.getNroLibreta());
			}
		});
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}
		catch(IOException ex) {
			ex.getMessage();
		}
		System.out.println("Alumnos inscriptos ordenados por numero de libreta al curso: " + this.nombre);
		for(int i=0;i<inscriptos.size();i++) {
			System.out.println(inscriptos.get(i).getNombre());
			}
		System.out.println("");
	}
	
	public void imprimirInscriptosCreditos() {
		try {
			Collections.sort(inscriptos, new Comparator<Alumno>() {
			public int compare(Alumno a1, Alumno a2) {
				return  a1.creditosObtenidos().compareTo(a2.creditosObtenidos());
			}
		});
		log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		}
		catch(IOException ex) {
			ex.getMessage();
		}
		System.out.println("Alumnos inscriptos ordenados por creditos obtenidos  al curso: " + this.nombre);
		for(int i=0;i<inscriptos.size();i++) {
			System.out.println(inscriptos.get(i).getNombre());
			}
		System.out.println("");
	}
	
	public List<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public boolean equals(Curso c){ 
		return (c.id == this.id);
	}
	
	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


}
