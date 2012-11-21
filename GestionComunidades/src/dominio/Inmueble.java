package dominio;

import java.io.Serializable;

public class Inmueble  implements Serializable {

	private int id;
	private String escalera, piso, puerta;
	private float percent;
	
	public Inmueble(int id, String escalera, String piso, String puerta, float percent) {
		super();
		this.id = id;
		this.escalera = escalera;
		this.piso = piso;
		this.puerta = puerta;
		this.percent = percent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		Inmueble i=(Inmueble) arg0;
		return i.id==this.id;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Poner la salida de todos los datos.";
	}
	

}
