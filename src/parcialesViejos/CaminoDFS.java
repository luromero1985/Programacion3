package parcialesViejos;

import java.util.HashMap;
import java.util.LinkedList;


public class CaminoDFS {
	private GrafoDirigido grafo;
	
	public CaminoDFS(GrafoDirigido grafo){
		this.grafo=grafo;
		
	}
	  public boolean CaminoDFS(int inicio, int fin) {
		  LinkedList<Integer> visitados = new LinkedList<>();
	        return dfs(grafo, inicio, fin, visitados, null);
	    }

	    private boolean dfs(GrafoDirigido grafo, int actual, int fin, LinkedList<Integer> visitados, String ultimoColor) {
	        if (actual == fin) {
	            return true;
	        }

	        visitados.add(actual);
	        Vertice verticeActual = grafo.obtenerVertice(actual);

	        if (ultimoColor != null && verticeActual.getColor().equals(ultimoColor)) {
	            return false;
	        }

	        for (Arco arco : grafo.obtenerArcos(actual)) {
	            int adyacente = arco.getDestino();
	            if (!visitados.contains(adyacente)) {
	                if (dfs(grafo, adyacente, fin, visitados, verticeActual.getColor())) {
	                    return true;
	                }
	            }
	        }

	        visitados.remove(actual);
	        return false;
	    }
	}

