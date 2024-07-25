package parcialesViejos;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashMap;


public class GrafoDirigido {
	    private HashMap<Integer, Vertice> vertices;
	    private HashMap<Integer, LinkedList<Arco>> arcos;

	    public GrafoDirigido() {
	        vertices = new HashMap<>();
	        arcos = new HashMap<>();
	    }

	    public void agregarVertice(int verticeId, String color) {
	        Vertice vertice = new Vertice(verticeId, color);
	        vertices.put(verticeId, vertice);
	        arcos.put(verticeId, new LinkedList<Arco>());
	    }

	    public void agregarArco(int verticeId1, int verticeId2) {
	        Arco arco = new Arco(verticeId1, verticeId2);
	        arcos.get(verticeId1).add(arco);
	    }

	    public Vertice obtenerVertice(int verticeId) {
	        return vertices.get(verticeId);
	    }

	    public LinkedList<Arco> obtenerArcos(int verticeId) {
	        return arcos.get(verticeId);
	    }
	}
