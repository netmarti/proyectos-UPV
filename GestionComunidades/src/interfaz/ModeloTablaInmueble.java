package interfaz;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dominio.Inmueble;
import excepciones.InmuebleYaExiste;
import gestion.GestionInmuebles;

public class ModeloTablaInmueble extends DefaultTableModel {
	private GestionInmuebles gestion;
	
	private boolean flag =false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public ModeloTablaInmueble (GestionInmuebles gestion){
		super(null,new String[]{"id", "Escalera", "Piso", " Puerta"});
		this.gestion=gestion;
	}
	public void addInmueble (Inmueble i) throws InmuebleYaExiste{
		gestion.addInmueble(i);
		this.addToTabla(i);
	}
	public void borraInmueblePorPosicion(int row){
		Integer id=(Integer)getValueAt(row, 0);
		gestion.borraInmueblePorId(id);
		this.removeRow(row);
	}
	public Inmueble recuperaInmueblePorPosicion(int row){
		Integer id=(Integer)getValueAt(row, 0);
		return gestion.getInmueblePorId(id);
	}
	public void cargaInmuebles(String fichero){
		gestion.cargaListaInmuebles(fichero);
		this.getDataVector().clear();
		for(Inmueble i:gestion.getLista()) this.addToTabla(i); 
	}
	public void guardaInmuebles(String fichero){
		gestion.guardaListaInmuebles(fichero);
	}
	private void addToTabla(Inmueble i){
		Vector v=new Vector();
		v.add(i.getId());v.add(i.getEscalera());
		v.add(i.getPiso());v.add(i.getPuerta());
		this.addRow(v);
	}
}