package linkedListCollections;

import java.util.*;

/**
 * 	Colec��o de objectos baseda em lista ligada (conjunto de n�s)
 * 
 */
public class LinkedListCollection implements Collection<Object> 
 {
	private class Node {
		public Node Link;		// liga��o para o pr�ximo n� da lista
								// Quando tiver NULL quer dizer que � o �ltimo
		public Object Value;	
		public Node(Object value) {
			this(value, null);
		}
		public Node(Object value, Node next) {
			this.Link = next;
			this.Value = value;
		}
	}
	
	private Node head = null;	// REFER�NCIA para o PRIMEIRO N� da lista
	
	// ########################################################################
	// Construction
	// ########################################################################

	// Colec��o din�mica (cresce � medida das necessidades)
	public LinkedListCollection()
	{
	}
	
	// ########################################################################
	// Manupulation
	// ########################################################################
	public boolean add(Object obj2Add)
	{
		Node newNode = new Node(obj2Add);
		
		if(isEmpty()) {
			head = newNode;
			return true;
		}
		
		// Se tem elementos, temos que procurar o �ltimo n� e adicionar ai!
		Node n = head;
		while(n.Link != null)
			n = n.Link;	// avan�ar para o pr�ximo n�
		
		n.Link = newNode;	// "ligar" o �ltimo n� da lista ao novo n�
		return true;

	}

	@Override
	public boolean addAll(Collection<? extends Object> sourceCollection) {
		throw new NotImplementedException();
	}

	@Override
	public void clear() {
		throw new NotImplementedException();
	}

	@Override
	public boolean remove(Object objToRemove) {
		throw new NotImplementedException();
	}

	@Override
	public boolean removeAll(Collection<?> elemsToRemove) {
		throw new NotImplementedException();
	}
	
	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new NotImplementedException();
	}

	// ########################################################################
	// Query
	// ########################################################################	
	public int size() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object objToFind) {
		throw new NotImplementedException();
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new NotImplementedException();
	}

	// ########################################################################
	// Iterator (from Iterable<Object>)
	// ########################################################################
	@Override
	public Iterator<Object> iterator() {
		throw new NotImplementedException();
	}


	// ########################################################################
	// Auxiliar
	// ########################################################################

	@Override
	public Object[] toArray() {
		throw new NotImplementedException();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}

	// ########################################################################
	// Implementa��o da classe interna que implementa o Iterator<Object>
	// ########################################################################
	/*
	public class ACIterator implements Iterator<Object>
	{
		private int iteratorPos; // indice usado, pelo next, para retornar valores
		
		@Override
		public boolean hasNext() {
			// NOTA: O acesso � vari�vel de inst�ncia [pos] � feito
			//       via liga��o IMPLICITA ao objecto que fez new deste tipo!
			//       O acesso � permitido, mesmo que a vari�vel seja private :-)
			return data != null && iteratorPos < pos;
		}
	
		@Override
		public Object next() {
			if(!hasNext()) throw new NoSuchElementException();
			
			Object strReturn = data[iteratorPos];
			++iteratorPos;
			return strReturn;
		}
	
		@Override
		public void remove() {
			// Para remover o elemento (�ltimo retornado pelo next), 
			//  movem-se todos os seguintes elementos para tr�s
			//   ex: para remover input[4] movemos para input[4] = input[5] e "por ai em diante" at� firstInvalidIndex
			
			int from = iteratorPos;
			int to = pos;
			int dst = iteratorPos - 1;
			
			while(from < to) {
				data[dst++] = data[from++];
			}
			
			pos -= 1;
			
		}
	}	// end of ACIterator...	
	*/
}
