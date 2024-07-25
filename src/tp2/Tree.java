package tp2;

import java.util.ArrayList;

public class Tree {


	private TreeNode root;

	public Tree() {
		this.root = null;
	}


	//INSERTAR ELEMENTO
	//agregar nodos al árbol. Complejidad BigO-> O(n)

	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}

	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}


	// DAR LA RAIZ
	//Complejidad BigO-> O(1)
	public Integer getRoot() {
		return this.root.getValue();
	}


	//DECIR SI TIENE UN ELEMENTO
	//Complejidad BigO-> O(n)
	public boolean hasElem(Integer elem) {

		//si mi arbol esta vacio no busco
		if (this.isEmpty()) {
			return false;
		}
		else{

			//creo un nodo que sera el que va cambiando a lo largo de la busqueda.
			TreeNode aux = this.root;
			boolean encontrado=false;
			//mientras no haya encontrado el elem y mi nodo no este vacio, busco
			while(!encontrado && aux!=null) {

				//analizo si la búsqueda es a la derecha o a la iz del nodo
				if(elem<aux.getValue()) {
					aux=aux.getLeft();
				}
				else {
					if(elem>aux.getValue()) {
						aux=aux.getRight();
					}
					//si no es mayor, ni menor, es el elemento.
					else {
						encontrado=true;
					}
				}
			}
			return encontrado;
		}
	}

	//ESTA VACIO
	//Complejidad BigO-> O(1)
	public boolean isEmpty() {
		return this.getRoot()==null;
	}

	//SABER LA ALTURA DEL ARBOL
	//Complejidad BigO-> O(n)
	public int getHeight () {
		if(this.isEmpty()) {
			return 0;
		}
		return this.getHeight(this.root);
	}

	private int getHeight(TreeNode nodo) {
		//cada nodo se queda con la altura mas grande entre su hijo izq y el derecho
		int HL=0;
		int HR=0;
		int H=0;

		if(nodo.getLeft()!= null) {
			HL = 1 + this.getHeight(nodo.getLeft());
		}
		else {
			HL = 0;
		}

		if(nodo.getRight()!= null) {
			HR = 1 + this.getHeight(nodo.getRight());
		}
		else {
			HR= 0;
		}

		if(HR>HL) {
			H=HR;
		}
		else {
			H=HL;
		}
		return H;
	}

	//IMPRIMIR POST ORDER
	//Complejidad BigO-> O(n)
	public String ImprimirPostOrder() {
		if(this.isEmpty()) {
			return "";
		}
		return ImprimirPostOrder(this.root);	
	}


	private String ImprimirPostOrder(TreeNode nodo) {
		String il,ir;
		if(nodo.getLeft()== null) {
			il="";
		}
		else {
			il= this.ImprimirPostOrder(nodo.getLeft());
		}

		if(nodo.getRight()== null) {
			ir="";
		}
		else {
			ir= this.ImprimirPostOrder(nodo.getRight());
		}

		return il + ir +","+ nodo.getValue();

	}

	//IMPRIMIR PRE ORDER
	//Complejidad BigO-> O(n)
	public String ImprimirPreOrder() {
		if(this.isEmpty()) {
			return "";
		}
		return ImprimirPreOrder(this.root);	

	}


	private String ImprimirPreOrder(TreeNode nodo) {
		String il,ir;
		if(nodo.getLeft()== null) {
			il="- ,";
		}
		else {
			il= this.ImprimirPreOrder(nodo.getLeft());
		}

		if(nodo.getRight()== null) {
			ir="- ,";
		}
		else {
			ir= this.ImprimirPreOrder(nodo.getRight());
		}

		return nodo.getValue()+"," + il + ir  ;

	}




	//IMPRIMIR PRE ORDER
	//Complejidad BigO-> O(n)
	public String ImprimirOrder() {
		if(this.isEmpty()) {
			return "";
		}
		return ImprimirOrder(this.root);	

	}


	private String ImprimirOrder(TreeNode nodo) {
		String il,ir;
		if(nodo.getLeft()== null) {
			il="- ,";
		}
		else {
			il= this.ImprimirOrder(nodo.getLeft());
		}

		if(nodo.getRight()== null) {
			ir="- ,";
		}
		else {
			ir= this.ImprimirOrder(nodo.getRight());
		}

		return il + nodo.getValue()+"," +  ir  ;

	}


	//RAMA MAS LARGA
	//Complejidad BigO-> O(n)
	public ArrayList<Integer> getList(){
		return this.getList(this.root);
	}

	private ArrayList<Integer> getList(TreeNode nodo) {
		ArrayList<Integer> HL = new ArrayList<>();
		ArrayList<Integer> HR = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();

		if(nodo.getLeft()!= null) {
			HL = this.getList(nodo.getLeft());
		}		

		if(nodo.getRight()!= null) {
			HR = this.getList(nodo.getRight());
		}

		list.add(nodo.getValue());

		if(HR.size()>HL.size()) {
			list.addAll(HR);
		}
		else {
			list.addAll(HL);
		}
		return list;
	}



	// HACER LOS VALORES DE FRONTERA
	//Complejidad BigO-> O(n)
	public ArrayList<Integer> getFrontera() {

		if(this.isEmpty()) {
			ArrayList<Integer> respuesta = new ArrayList<>();
			return respuesta;
		}
		else {
			return this.getFrontera(this.root);
		}
	}


	private ArrayList<Integer> getFrontera(TreeNode nodo) {
		ArrayList<Integer> frontera = new ArrayList<>();

		if(nodo.getLeft()==null && nodo.getRight()==null) {
			frontera.add(nodo.getValue());
		}
		else {
			if(nodo.getLeft()!=null) {
				frontera.addAll(this.getFrontera(nodo.getLeft()));
			}
			if(nodo.getRight()!=null) {
				frontera.addAll(this.getFrontera(nodo.getRight()));
			}
		}
		return frontera;
	}



	// RETORTNAR EL ELEMENTO MÁS GRANDE
	//Complejidad BigO-> O(n)
	public Integer getMaxElement() {
		if(this.isEmpty()) {
			return  null;
		}
		return this.getMaxElement(this.root);
	}


	private Integer getMaxElement(TreeNode nodo) {
		if(nodo.getRight()==null) {
			return nodo.getValue();
		}
		else {
			return this.getMaxElement(nodo.getRight());
		}
	}

	//DEVOLVER LOS NODOS DE UN NIVEL
	//Complejidad BigO-> O(n)
	public ArrayList<Integer> getElemAtLevel(int level) {

		if(level< 0 || this.isEmpty() || level>this.getHeight()) {
			ArrayList<Integer> lista = new ArrayList<>();
			return  lista;
		}
		return this.getElemAtLevel(level,0,this.root);
	}

	private ArrayList<Integer> getElemAtLevel(int levelFinal, int contador,TreeNode nodo){
		ArrayList<Integer> lista = new ArrayList<>();	
		if(contador<levelFinal) {
			if(nodo.getLeft()!=null) {
				lista.addAll(this.getElemAtLevel(levelFinal,contador+1,nodo.getLeft()));
			}
			if(nodo.getRight()!=null) {
				lista.addAll(this.getElemAtLevel(levelFinal,contador+1,nodo.getRight()));
			}
		}
		if(levelFinal==contador) {
			lista.add(nodo.getValue());
		}
		return lista;

	}


	//Ejercicio 2

	//Dado un árbol binario de búsquedas que almacena números 
	//enteros, implementar un algoritmo que retorne la suma de 
	//todos los nodos internos del árbol.

	public int sumaNodos() {
		if(this.isEmpty()) {
			return 0;
		}
		return sumaNodos(this.root);	
	}
	private int sumaNodos(TreeNode nodo) {
		int il;
		int ir;
		if(nodo.getLeft()== null) {
			il=0;
		}
		else {
			il= this.sumaNodos(nodo.getLeft());
		}
		if(nodo.getRight()== null) {
			ir=0;
		}
		else {
			ir= this.sumaNodos(nodo.getRight());
		}
		return nodo.getValue()+ il + ir  ;
	}

	//Ejercicio 3
	//Dado un árbol binario de búsqueda que almacena números 
	//enteros y un valor de entrada K, implementar un algoritmo 
	//que permita obtener un listado con los valores de todas las
	//hojas cuyo valor supere K. Por ejemplo, para el árbol de 
	//la derecha, con un valor K = 8, el resultado debería 
	//ser [9, 11].

	public  ArrayList<Integer>hojasMayoresA(int k){
		if(this.isEmpty()) {
			return new ArrayList<>();
		}
		return hojasMayoresA(k, this.root);
	}

	private ArrayList<Integer> hojasMayoresA(int k, TreeNode nodo){
		ArrayList<Integer> solucion = new ArrayList<Integer>();

		if(nodo.getLeft()== null && nodo.getRight()==null && nodo.getValue()>k) {
			solucion.add(nodo.getValue());
		} 
		else {
			//SI EL K ES MAS GRANDE QUE EL QUE ESTOY  PARADA ENTONCES YA NO BUSCO MAS A LA IZQUIERDA
			if(nodo.getRight()!=null) {
				solucion.addAll(this.hojasMayoresA(k,nodo.getRight()));
			}
			if(nodo.getLeft()!=null) {
				solucion.addAll(this.hojasMayoresA(k,nodo.getLeft()));
			}

		}
		return solucion;
	}


	//actividad 4

	public void completarArbol() {
		if(!this.isEmpty()) {
			this.completarArbol(this.root);
		}
	}

	private int completarArbol(TreeNode nodo) {
		if(nodo.getValue()!=null) {
			return nodo.getValue();
		}
		else {
			int vr =0;
			int vl =0;
			if(nodo.getRight()!=null) {
				vr = this.completarArbol(nodo.getRight());
			}
			if(nodo.getLeft()!=null) {
				vl = this.completarArbol(nodo.getLeft());
			}
			nodo.setValue(vr-vl);
			return vr-vl;
		}
	}

	//act 5
	/*
	public ArrayList<String> palabrasConCantVocales(int cantidad){
		if(this.isEmpty()) {
			return new ArrayList<String>();
		}
		return this.palabrasConCantVocales(cantidad,this.root);
	}

	private ArrayList<String> palabrasConCantVocales(int cant, TreeNode nodo) {
		ArrayList<String> respuesta = new ArrayList<String>();
		this.getPalabra(this.root, cant,respuesta);
		return respuesta;
	}

	private String getPalabra(TreeNode nodo, int cant,ArrayList<String> respuesta) {
		String palabra = "";
		if(cant==0 && palabra != "") {
			if((nodo.getValue()=='a'||nodo.getValue()=='e'||nodo.getValue()=='i'||nodo.getValue()=='o'||nodo.getValue()=='u' )){
				return “”;
				else{
					return nodo.getValue();
				}
			}
			if(cant>0) {
				if(nodo.getValue()=='a'||nodo.getValue()=='e'||nodo.getValue()=='i'||nodo.getValue()=='o'||nodo.getValue()=='u' ) {
					cant=cant-1;
				}
				if(nodo.getLeft()!=null) {
					palabra = nodo.getValue() + this.getPalabra(nodo.getLeft(),cant,respuesta);
				}
				if(nodo.getRight()!=null) {
					palabra = nodo.getValue() + this.getPalabra(nodo.getRight(),cant,respuesta);
				}
				respuesta.add(palabra);
			}
		}



	 */
	//borrar

	public void delete(int valor) {
		if(!this.isEmpty()) {
			this.delete(valor,this.root);
		}
	}
	private void delete(int valor, TreeNode aux) {
		//NO BORRA LA RAIZ, SI QUEREMOS BORRAR LA RAIZ TENEMOS QUE ARMAR UN METODO QUE EVALUE LAS 3 POSIBILIDADES
		// DE ELIMINAR LA RAIZ. lA PRIMERA ES QUE SOLO ESTE LA RAIZ ASIQUE ES NULL Y LISTO.
		//LA SEGUNDA SERIA QUE TENGA UNA HOJA ASIQUE REEMPLAZA A LA RAIZ
		//Y LA TERCERA ES QUE TENGA DOS HOJAS 

		TreeNode nodo;

		if(aux.getValue()<valor) {

			nodo= aux.getRight();
		}
		else {
			nodo=aux.getLeft();
		}
		if(nodo.getValue()== valor){
			//TENGO QUE ELIMINAR SEGUN LA CONDICION
			if(nodo.getLeft()==null && nodo.getRight()==null) {
				if(aux.getLeft().getValue()==nodo.getValue()) {
					aux.setLeft(null);
				}
				else {
					aux.setRight(null);
				}
			}

			else if(nodo.getLeft()==null || nodo.getRight()==null) {
				//PRIMERO PREGUNTO DE QUE LADO ESTA EL HIJO, Y DESPUES DE QUE LADO TIENE SU UNICA HOJA EL HIJO
				if(aux.getLeft().getValue()==nodo.getValue()) {
					if(nodo.getLeft()!=null){
						aux.setLeft(nodo.getLeft());
					}
					else{
						aux.setLeft(nodo.getRight());
					}
				}


				else {
					if(nodo.getLeft()!=null){
						aux.setRight(nodo.getLeft());
					}
					else{
						aux.setRight(nodo.getRight());
					}
				}
			}
			else {
				TreeNode reemplazo = this.PadreDeLaHojaMasIzquierda(nodo.getRight());
				nodo.setValue(reemplazo.getValue());
				this.delete(reemplazo.getValue(),nodo);
			}
		}
		//BUSCAR NODO
		else {
			if(nodo.getValue()<valor) {
				//BUSCO A DERECHA
				if(nodo.getRight()!=null) {
					this.delete(valor, nodo);
				}
			}
			else {
				//BUSCO A IZQUIERDA
				if(nodo.getLeft()!=null) {
					this.delete(valor,nodo);
				}
			}
		}
	}

	private TreeNode PadreDeLaHojaMasIzquierda(TreeNode nodo) {
		TreeNode padre = nodo;
		if(nodo.getLeft()!=null) {
			padre=nodo.getLeft();
			return this.PadreDeLaHojaMasIzquierda(padre);
		}
		return padre;
	}

	//no evaluar si tiene uno o dos hijos, porque es lo mismo
	/*si si es hoja
	si no es hoja tiene algun hijo...voy por iz o derecha es igual
	hago ej, todo el recorrido a la iz..buscando el mas... 
	sino tengo busco del otro lado*

	forma 2: sobreescribir y elimino la hoja. Solo piso el que tengo y hacer llamado recursivo si es menor/
	 */


	public boolean cumple(int k){
		return this.cumple(k, this.root);
	}

//actividad de parcial 29/6/22
	//En un ABB la suma de un nodo con su subsiguiente no debe superar k, exceptuando a las hojas.
	private boolean cumple(int k, TreeNode nodo){
		boolean cumpleIzq=true;
		boolean cumpleDer=true;


		//analizo la rama inzquierda
		if(nodo.getLeft()!=null){
			TreeNode hijo= nodo.getLeft();
			//si mi hijo no es hoja, analizo la diferemncia
			if(hijo.getLeft()!=null || hijo.getRight()!=null){

				if(nodo.getValue()-hijo.getValue()<k){
					cumple(k, hijo);
				}
				else{
					cumpleIzq=false;
				}
			}
		}

		//analizo la rama derecha
		if(nodo.getRight()!=null){
			TreeNode hijoD= nodo.getRight();
			//si mi hijo no es hoja, analizo la diferemncia
			if(hijoD.getLeft()!=null || hijoD.getRight()!=null){
				if(hijoD.getValue()-nodo.getValue()<k){
					cumple(k, hijoD);
				}
				else{
					cumpleDer=false;
				}
			}
		}

		return cumpleIzq&&cumpleDer;
	}
}

