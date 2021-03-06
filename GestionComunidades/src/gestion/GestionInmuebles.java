package gestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dominio.Inmueble;

import excepciones.InmuebleYaExiste;

public class GestionInmuebles extends Exception{

	private ArrayList<Inmueble> lista = new ArrayList<Inmueble>();

	public ArrayList<Inmueble> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Inmueble> lista) {
		this.lista = lista;
	}

	public void addInmueble(Inmueble i) throws InmuebleYaExiste { 
		if(lista.contains(i)) {
			throw new InmuebleYaExiste();
		} else {
			lista.add(i);
		}
	}

	public boolean contains(Object o) {
		Inmueble aux = (Inmueble) o;
		for(Inmueble i : lista) {
			if(i.getId()==aux.getId())
				return true;
		}
		return false;
	}
	
	public boolean contains(int id) {
		for(Inmueble i : lista) {
			if(i.getId()==id)
				return true;
		}
		return false;
	}

	public Inmueble getInmueblePorId(int id) {
		Inmueble aux = null;
		for(Inmueble i : lista) {
			if(id==i.getId())
				aux=i;
		}
		return aux;
	}

	public void borraInmueblePorId(int id) {
		lista.remove(this.getInmueblePorId(id));
	}
	
	public void guardaListaInmuebles(String fichero) {
		try { 
			ObjectOutputStream objout =  new ObjectOutputStream ( new FileOutputStream(fichero)); 
			objout.writeObject(lista); 
			objout.close(); 
			System.out.println("Archivo guardado."); 
		} catch (IOException e) { 
   			System.out.println("Error guardando archivo: "); 
		} 
	}

	public void cargaListaInmuebles(String fichero) {
		try { 
			ObjectInputStream objin =  new ObjectInputStream (new FileInputStream(fichero)); 
			lista= (ArrayList<Inmueble>) objin.readObject(); 
			objin.close();
			System.out.println("Archivo leido."); 
		} catch (ClassNotFoundException e) { 
			System.out.println("Error!"); 
		} catch (IOException ex) { 
			System.out.println("Error abriendo archivo: "); 
		} 

	}
}