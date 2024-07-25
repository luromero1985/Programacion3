package parcialesViejos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;



public class iteratorVertices<T> implements Iterator<Integer> {
	private Iterator<Map.Entry<Integer, LinkedList<Arco<T>>>> iterador;
	//porque no me deja poner Hashtable en lugar de Map? Pero si funciona con hashmap
	@Override
	public boolean hasNext() {
		return iterador.hasNext();
	}

	@Override
	public Integer next() {
		return iterador.next().getKey();
	}

}