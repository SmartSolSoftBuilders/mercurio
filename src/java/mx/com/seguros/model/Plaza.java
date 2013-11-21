package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.CertificadoIndividual;
import java.util.ArrayList;
import mx.com.seguros.model.Empleado;

public class Plaza {
	private int idPlaza;
	private String cvePlaza;
	private String nombrePlaza;
	private List<CertificadoIndividual> certificadoindividual = new ArrayList<CertificadoIndividual>();
	private List<Empleado> empleado = new ArrayList<Empleado>();

	public Plaza(){}
	
	public Plaza(String cvePlaza, String nombrePlaza) {
		this.setCvePlaza(cvePlaza);
		this.setNombrePlaza(nombrePlaza);
	}

	public void setIdPlaza(int idPlaza) {
		this.idPlaza = idPlaza;
	}

	public int getIdPlaza() {
		return this.idPlaza;
	}

	public void setCvePlaza(String cvePlaza) {
		this.cvePlaza = cvePlaza;
	}

	public String getCvePlaza() {
		return this.cvePlaza;
	}

	public void setNombrePlaza(String nombrePlaza) {
		this.nombrePlaza = nombrePlaza;
	}

	public String getNombrePlaza() {
		return this.nombrePlaza;
	}
}