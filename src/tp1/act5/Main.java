package tp1.act5;

public class Main {

	public static void main(String[] args) {
		MySimpleList<T>l1=new MySimpleList<>();
		MySimpleList<T>l2=new MySimpleList<>();

		//carga de lista 1 y lista 2
		l1.insertFront(6);
		l1.insertFront(3);
		l1.insertFront(4);
		l1.insertFront(2);

		l2.insertFront(3);
		l2.insertFront(1);
		l2.insertFront(6);
		//l1: 6-3-4-2-1
		//l2:3-1-6

		//l3: 6-3-1


		public MySimpleList<T> listaCombinadaYOrdenada(MySimpleList<T>l1, MySimpleList<T>l2){

			MySimpleList<T>list3=new MySimpleList<>();

			MyIterator<T> iterac_1 = l1.iterator();
			/*		MyIterator<T> iterac_2 = l2.iterator();

			for(T elemento1: l1){
				for(T elemento2: l2){
					if(elemento1.equals.elemento2){
						listS3.insertarOrdenado(elemento1)    
						//opcion ordenar después de creada la lista vinculada (usamos la clase mergesort).
						//l3.insertFront(elemento1);  
						//Mergesort.sort(array);
					}
				}
			}

			 */

			//Mejorado (el segundo for, es un while y hace que no se recorra toda la lista
			//por completo):
			for(T elemento1: l1){

				MyIterator<T> itl2 = new l2.iterator();

				boolean encontrado= false;
				while(itl2.hasNext() && !encontrado ){
					T elemento2= itl2.next();

					if(elemento1.equals.elemento2){
						l3.insertarOrdenado(elemento1);
						encontrado=true;
					}
				}
			}
		}

		/*	Ejercicio 5 b
				Dos listas ordenadas. formar una lista con elementos comunes, ordenada
				En el Main creamos la función:*/

		public MySimpleList<T> listasOrdenadasOrdenada
		(MySimpleList<T> l1, MySimpleList<T> l2){

			MySimpleList<T>list3=new MySimpleList<>();

			MyIterator<T> itl1 = new l1.iterator();
			MyIterator<T> itl2 = new l2.iterator();

			// Si el valor de iter2 es menor al de iter1, avanzo el iter2 
			if (iter2.get() < iter1.get()) {
				iter2.next() ;
			}
			if (iter1.get() < iter2.get()){
				iter1.next() ;
			}
			if (iter1.get().equals(iter2.get())){
				l3.agregarUltimo(iter1.get());
				iter1.next();
				iter2.next() ;
			}
		}



		/*Ejercicio 6: Escriba una función que dadas dos listas construya otra con los elementos que están en la primera pero no en la segunda. 
				en el main:*/

		public MySimpleList<T> elementosSoloPrimerLista(MySimpleList<T>l1, MySimpleList<T>l2){
			MySimpleList<T>l3=new MySimpleList<>();

			for(T elemento1:l1) {

				Node<T> elemento2= l2.getFirst();
				
				while((!elemento1.equals(elemento2)) || elemento2.next()!=null){
					elemento2=elemento2.getNext();
				}
				if( (elemento2.next()==null)  || (!elemento1.equals(elemento2))){
					l3.insertFront(elemento1);
				}
			}
		}


	}
