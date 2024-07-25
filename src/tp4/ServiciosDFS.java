package tp4;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiciosDFS {
	private Hashtable<Integer, String> colores;
	private Grafo<?> grafo; 
	//variable para saber si hay ciclos
	private boolean cicloEncontrado;

	public ServiciosDFS(Grafo<?> grafo){
		this.colores= new Hashtable<Integer, String>();
		this.grafo=grafo;
		this.cicloEncontrado=false;
	}

	public LinkedList<Integer> DFS(){
		
		//lista de visitados
		LinkedList<Integer> resultado=new LinkedList<Integer>();
	
		//genero un iterados para recorrer los vertices
		Iterator<Integer>it = grafo.obtenerVertices();
		
			//a todos le vamos a asignar el color blanco
			while(it.hasNext()){
				colores.put(it.next(), "Blanco");
			}


			//vuelvo a iterar los vertices desde el principio
			it= grafo.obtenerVertices();
			while(it.hasNext()){
				Integer vertice = it.next();
				if(colores.get(vertice)=="Blanco"){
					resultado.add(vertice);
					DFS_visit(vertice, resultado);
				}
			}
		
		return resultado;
	}

	private void DFS_visit(Integer vertice,LinkedList<Integer> resultado){
		this.colores.replace(vertice,"Amarillo");
		//iteardor de los adyacentes al vertice que agarro.
		Iterator<Integer>it=grafo.obtenerAdyacentes(vertice);

		while(it.hasNext()){
			int aux = it.next();

			if(this.colores.get(aux).equals("Blanco")){
				resultado.add(aux);
				DFS_visit(aux,resultado);
			}
			else{
				//si el siguiente es amarillo es porque ya fue visitado
				if(this.colores.get(aux).equals("Amarillo")){
					this.cicloEncontrado=true;

				}
			}
		}

		//Dejar en negro el vertice actual indica que éste ha sido completamente procesado, 
		//lo que significa que todos sus adyacentes han sido visitados y no hay más caminos
		//por explorar desde ese vértice
		this.colores.replace(vertice, "Negro");
	}

	
	//Tiene sentido recorrer todo el dfs? o repetimos la función dfs y hacemos que corte si encuentra un ciclo

	public boolean getCicloEncontrado(){
		//llamo a la función dfs para actualizar el cicloEncontrado
		this.DFS();
		return this.cicloEncontrado;
	}




	public LinkedList<Integer>caminoMayor(int destino, int origen){
		LinkedList<Integer> rtaCaminoMayor= new LinkedList<>();

		//me aseguro que mis vertices esten inicializados en blanco
		Iterator<Integer>it = grafo.obtenerVertices();
		while(it.hasNext()){
			this.colores.put(it.next(), "Blanco");
		}

		//señalo por el que pase
		this.colores.replace(origen,"Amarillo");
		if(origen==destino){
			//si encontr el destino me agrego
			rtaCaminoMayor.add(origen);
		}
		else{
			Iterator<Integer>it_ady=this.grafo.obtenerAdyacentes(origen);
			while(it_ady.hasNext()){
				Integer ady=it_ady.next();
				if(!this.colores.contains(ady)){
					//llamo a  recursion
					LinkedList<Integer> camino=this.caminoMayor(ady, destino);
					if(!camino.isEmpty()&&camino.size()>=rtaCaminoMayor.size()){
						//limpio la lista
						rtaCaminoMayor.clear();
						//agrego mi origen
						rtaCaminoMayor.add(origen);
						//agrego todo el camino
						rtaCaminoMayor.addAll(camino);
					}
				}
			}
		}
		//lo desmarco para que otros puedan volver a señalarlo
		this.colores.remove(origen);
		return rtaCaminoMayor;
	}



	}
