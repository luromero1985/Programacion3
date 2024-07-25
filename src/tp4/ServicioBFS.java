package tp4;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ServicioBFS {
	private Hashtable<Integer, String> colores;
	private Grafo<?> grafo; 

	public ServicioBFS(Grafo<?> grafo){
		this.colores= new Hashtable<Integer, String>();
		this.grafo=grafo;
	}

	public LinkedList<Integer> BFS(){
		//resultado es una lista en la que se almacenarán los vértices
		//en el orden en que son visitados
		LinkedList<Integer> resultado=new LinkedList<Integer>();
		
		Iterator<Integer> it = grafo.obtenerVertices();
		
		while(it.hasNext()){
			this.colores.put(it.next(), "No visitado");
		}
		
		it = grafo.obtenerVertices();
		while(it.hasNext()){
			Integer vertice=it.next();
			if(this.colores.get(vertice).equals("No visitado")){
				resultado.add(vertice);
				BFS_visit(vertice, resultado);

			}
		}
		return resultado;
	}

	private void BFS_visit(int vertice, LinkedList<Integer>resultado){
		//Inicialización de la cola:
		Queue<Integer> queue= new LinkedList<>();
		this.colores.replace(vertice, "visitado");
		//Agregamos el vértice a la cola:
		queue.offer(vertice);
		while(!queue.isEmpty()){
			Integer v =queue.poll();
			Iterator<Integer> it = grafo.obtenerAdyacentes(v);
			while(it.hasNext()){
				int i =it.next();
				if(this.colores.get(i).equals("No visitado")){
					this.colores.replace(i, "visitado");
					resultado.add(i);
					queue.offer(i);
				}
			}
		}
	}
}
