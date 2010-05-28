package linkedListCollections;

import java.util.*;

import javax.naming.OperationNotSupportedException;

/**
 * 	Colecção de objectos baseda em lista ligada (conjunto de nós)
 * 
 */
public class LinkedListCollection implements Collection<Object> 
 {
	// Os objectos de classes internas static NÃO TÊM ACESSO ao objecto que os criaram
	private static class Node {
		public Node Link;		// ligação para o próximo nó da lista
								// Quando tiver NULL quer dizer que é o último
		public Object Value;	
		public Node(Object value) {
			this(value, null);
		}
		public Node(Object value, Node next) {
			this.Link = next;
			this.Value = value;
		}
	}
	
	private Node head = null;	// REFERÊNCIA para o PRIMEIRO NÓ da lista
	
	private int sz = 0;	// número de elementos na colecção
	
	// ########################################################################
	// Construction
	// ########################################################################

	// Colecção dinâmica (cresce à medida das necessidades)
	public LinkedListCollection()
	{
	}
	
	// ########################################################################
	// Manupulation
	// ########################################################################
	public boolean add(Object obj2Add)
	{
		Node newNode = new Node(obj2Add);
		
		if(isEmpty()) 
		{
			head = newNode;
			++sz;
			return true;
		}
		
		// Adicionar o nó no início
		newNode.Link = head;
		head = newNode;
		++sz;
		return true;
		
	}

	@Override
	public boolean addAll(Collection<? extends Object> sourceCollection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object objToRemove) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> elemsToRemove) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	// ########################################################################
	// Query
	// ########################################################################	
	public int size() {
		return sz;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(Object objToFind) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	// ########################################################################
	// Iterator (from Iterable<Object>)
	// ########################################################################
	@Override
	public Iterator<Object> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Object> {
		
		private Node node;
		
		public LinkedListIterator() {
			node = head;
		}
		
		@Override
		public boolean hasNext() {
			return node != null;
		}
		
		@Override
		public Object next() {
			
			if(node == null) throw new NoSuchElementException();
			
			Object elem = node.Value;
			node = node.Link;
			return elem;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	// ########################################################################
	// Auxiliar
	// ########################################################################

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}

	// ########################################################################
	// Implementação da classe interna que implementa o Iterator<Object>
	// ########################################################################
	/*
	public class ACIterator implements Iterator<Object>
	{
		private int iteratorPos; // indice usado, pelo next, para retornar valores
		
		@Override
		public boolean hasNext() {
			// NOTA: O acesso à variável de instância [pos] é feito
			//       via ligação IMPLICITA ao objecto que fez new deste tipo!
			//       O acesso é permitido, mesmo que a variável seja private :-)
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
			// Para remover o elemento (último retornado pelo next), 
			//  movem-se todos os seguintes elementos para trás
			//   ex: para remover input[4] movemos para input[4] = input[5] e "por ai em diante" até firstInvalidIndex
			
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
