package parcialesViejos;
/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */

public class Arco<T>{

	 private int origen;
	    private int destino;

	    public Arco(int origen, int destino) {
	        this.origen = origen;
	        this.destino = destino;
	    }

	    public int getOrigen() {
	        return origen;
	    }

	    public int getDestino() {
	        return destino;
	    }
	}
