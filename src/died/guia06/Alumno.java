package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno(String nom, Integer nro) {
		nombre=nom;
		nroLibreta = nro;
		cursando = new ArrayList<Curso>();
		aprobados = new ArrayList<Curso>();
	}
	
	public Integer creditosObtenidos() {
		int creditosTotales=0;
		if (aprobados != null) {
		for(int i=0;i<this.aprobados.size();i++){
			creditosTotales+= this.aprobados.get(i).getCreditos();
		}
		return creditosTotales;
	}
		else return 0;
	}

	public void aprobar(Curso c) {    
		if(this.existeCurso(c)) {
			aprobados.add(c);
			cursando.remove(c);
			c.getInscriptos().remove(this);
		}
		else {
			System.out.println("La persona no esta cursando ese curso");
		}
	}
	
	public boolean existeCurso(Curso c) {
		boolean existe = this.cursando.contains(c);
		return existe;
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}
	
	public boolean equals(Alumno a) {
		boolean iguales = false;
		if(a.nroLibreta == this.nroLibreta)
			iguales = true;
		return iguales;
	}
	
	@Override
	public int compareTo(Alumno a) {
	return this.nombre.compareTo(a.nombre);
	}
	//0 si son iguales
	//-1 si this va primero q a
	//1 si a va primero q this

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	
	
	

}
