package tp4;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Hashtable;


public class GrafoDirigido<T> implements Grafo<T> {
	private Hashtable<Integer, LinkedList<Arco<T>>> vertices;

	public GrafoDirigido(){
		this.vertices =new Hashtable<Integer, LinkedList<Arco<T>>>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		LinkedList<Arco<T>> arcos= new LinkedList<Arco<T>>();
		this.vertices.put(verticeId, arcos);
	}



	@Override
	public void borrarVertice(int verticeId) {
		//obtenemos la lista vinvulada del vertice para borrarla
		this.vertices.get(verticeId).clear(); //no es necesario borrarlo, pero no esta mal hacerlo
		//borramos el vertice
		this.vertices.remove(verticeId);
		//borrar tambien a los aros que señalan al vertice que quiero borrar

		// Recorrer el HashMap obteniendo los valores por clave
		for (Integer key : this.vertices.keySet()) {
			//usamos el metodo borrar para que a partir de mi vertice encuentre 
			//la conección que quiero borrar
			this.borrarArco(key, verticeId);
			/*LinkedList<Arco<T>> listaAdyacencia = this.vertices.get(key);
			//recorro la linkedlist de cada vertice
			for(Arco<T> elem: listaAdyacencia){
				if(elem.getVerticeDestino()==verticeId){
					listaAdyacencia.remove(elem);
				}
			}
			 */
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> arcoNuevo =new Arco<T>(verticeId1, verticeId2, etiqueta);
		this.vertices.get(verticeId1).add(arcoNuevo);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		LinkedList<Arco<T>> listaArcos=this.vertices.get(verticeId1);
		int contador=0;
		for(Arco<T> elemento: listaArcos){
			if(elemento.getVerticeDestino()==verticeId2){
				listaArcos.remove(contador);
			}
			contador+=1;
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		for (Integer key : this.vertices.keySet()) {
			if (key==verticeId){
				return true;
			}
		}
		return false;
	}


	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// Recorrer el HashMap obteniendo los valores por clave
		for (Integer key : this.vertices.keySet()) {
			if(key==verticeId1){
				LinkedList<Arco<T>> listaAdyacencia = this.vertices.get(key);
				//recorro la linkedlist de cada vertice
				for(Arco<T> elem: listaAdyacencia){
					if(elem.getVerticeDestino()==verticeId2){
						return elem;
					}
				}
			}
			else {
				return null;
			}
		}
		return null;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return this.obtenerArco(verticeId1, verticeId2)!=null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int suma=0;
		for (Integer key : this.vertices.keySet()) {
			//buscamos la lista de cada vertice con get(key)
			int aux=this.vertices.get(key).size();
			suma+=aux;
		}
		return suma;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {	
		return new iteratorVertices<Integer>();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if(vertices.containsKey(verticeId)){
			return  new IteratorArcos<T>(this.vertices.get(verticeId).iterator());
		}
		return null;
	}

	
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> listaArcos = new ArrayList<>();

		// Iterar sobre todas las claves (vértices) de la Hashtable
		for (Integer vertice : this.vertices.keySet()) {
			//keySet lista de vertices
			//obtenemos la lista de arcos adyacentes al vértice especificado 
			LinkedList<Arco<T>> arcos = this.vertices.get(vertice);
			listaArcos.addAll(arcos);
		}
		return listaArcos.iterator();
	}



	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		
		//obtenemos la lista de arcos adyacentes al vértice especificado 
		LinkedList<Arco<T>> arcos = this.vertices.get(verticeId);
		// Iterar sobre todos los arcos adyacentes a este vértice
		return arcos.iterator();
	}


	
	


}
