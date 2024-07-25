package parcialesViejos;

import java.util.HashMap;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		
		        GrafoDirigido grafo = new GrafoDirigido();
		        grafo.agregarVertice(1, "rojo");
		        grafo.agregarVertice(2, "negro");
		        grafo.agregarVertice(3, "rojo");
		        grafo.agregarVertice(4, "rojo");
		        grafo.agregarVertice(5, "negro");

		        grafo.agregarArco(1, 2);
		        grafo.agregarArco(1, 3);
		        grafo.agregarArco(2, 4);
		        grafo.agregarArco(4, 5);
		        grafo.agregarArco(3, 4);

		        CaminoDFS camino= new CaminoDFS(grafo);
		        
		        boolean pathExists = camino.CaminoDFS(1, 5);
		        System.out.println("Existe un camino de 1 a 5 con colores alternados: " + pathExists);
		    }

	
	}


