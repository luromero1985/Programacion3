package tp1.act5;
public class MySimpleList<T> implements Iterable<T> {
	private Node<T> first;
	private int size;

	public MySimpleList() {
		this.first = null;
		this.size=0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size=this.size+1;
	}

	public T extractFront() {		
		this.first=this.first.getNext();
		this.size=this.size-1;	
		return this.first.getInfo();
	}

	public boolean isEmpty() {      
		return this.first==null;
	}

	public T get(int index) {
		if(index<0 || index>=this.size()){
			return null;
		}
		int i=0;
		Node<T> auxiliar = this.first;
		while(index<this.size() && i<index){
			auxiliar=auxiliar.getNext();
			i++;
		}

		return auxiliar.getInfo();
	}


	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		Node<T> tmp =this.first;
		String info="";
		while(tmp!=null){
			info+=tmp.getInfo().toString();
			tmp=tmp.getNext();
		}
		return info;
	}


	public Node<T> getFirst(){
		return this.first;
	}


	public int indexOf(T elem){
		int i=0;
		Node<T>tmp=this.first;
		while(i<this.size()){
			if(tmp.getInfo().equals(elem)){
				return i;
			}
			tmp=tmp.getNext();
			i++;
		}
		return -1;
	}

	public void agregarUtimo(T nuevo){
		Node<T> temp= this.first;
		Node<T> nuevoNodo= new Node<T>(nuevo,null);
		while(temp.getNext()!=null){
			temp=temp.getNext();
		}
		temp.setNext(nuevoNodo);
	}


	public void insertarOrdenado(T nuevo){
		Node<T> temp= this.first;
		if(this.isEmpty()  || nuevo.compareTo(temp.getInfo()))<=0){
			this.insertFront(nuevo);
		}
		else{
			while(temp.getNext()!= null  && nuevo.compareTo(temp.getInfo())>0){
				temp=temp.getNext();
			}
			Node<T> nuevoNodo = new Node<T>(nuevo,temp.getNext());
			temp.setNext(nuevoNodo);
		}

		public MyIterator<T> iterator(){
			return new MyIterator<T>(this.first);
		}
	}
