package linkedListCollections;

import java.util.*;

import collection.POOAbstractCollection;

/**
 * 	Colec��o de objectos baseda em lista ligada (conjunto de n�s)
 * 
 */
public class LinkedListCollectionExtendedFromAbstract 
					extends POOAbstractCollection 
 {
	// Os objectos de classes internas static N�O T�M ACESSO ao objecto que os criaram
	private static class Node {
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
	private int sz = 0;	// n�mero de elementos na colec��o
	
	// ########################################################################
	// Construction
	// ########################################################################

	// Colec��o din�mica (cresce � medida das necessidades)
	public LinkedListCollectionExtendedFromAbstract()
	{
		// Adi��o da sentinela (para simplificar a adi��o/remo��o)
		head = new Node(null);	// A sentinela n�o tem valor definido!
	}
	
	// ########################################################################
	// Manupulation
	// ########################################################################
	public boolean add(Object obj2Add)
	{
		// Criar o novo n�
		Node newNode = new Node(obj2Add);
		
		// Adicionar o novo n� "na cabe�a da lista" 
		//  -> a seguir � sentinela e antes do primeiro n�
		newNode.Link = head.Link;
		head.Link = newNode;
		
		// Nota: head.Link � uma refer�ncia para o 1� n� da lista
		
		++sz;
		return true;
		
	}

	// Implementa��o mais eficiente :-)
	@Override
	public void clear() {
		head.Link = null;
		sz = 0;
	}

	// Implementa��o mais eficiente :-)
	public int size() {
		return sz;
	}

	// ########################################################################
	// Iterator (from Iterable<Object>)
	// ########################################################################
	@Override
	public Iterator<Object> iterator() {
		return new LinkedListIterator();
	}
	
	// 	����������������������������������������������������������������� 
	// 	Implementa��o da classe interna que implementa o Iterator<Object>
	// 	�����������������������������������������������������������������
	private class LinkedListIterator implements Iterator<Object>
	{	
		private Node prev;
		private Node returnedByNext;
		
		public LinkedListIterator() {
			prev = null;
			returnedByNext = head;
		}
		
		@Override
		public boolean hasNext() {
			return returnedByNext.Link != null;
		}
		
		@Override
		public Object next() {
			
			if(!hasNext()) throw new NoSuchElementException();
			
			// Se houve remo��o prev fica igual
			// Caso contr�rio prev = returnedByNext
			if(prev == null || prev.Link == returnedByNext) {
				// N�o houve remo��o
				// actualizar o prev antes de avan�ar
				prev = returnedByNext;				
			}
			
			// avan�ar o returnedByNext
			returnedByNext = returnedByNext.Link;

			// Retornar o valor contido em returnedByNext
			return returnedByNext.Value;
		}
		
		@Override
		public void remove() 
		{
			// Lan�ar excep��o porque o next nunca foi chamado
			if(prev == null) throw new IllegalStateException();
			
			// Lan�ar excep��o porque o remove j� foi chamado uma vez (e next n�o foi chamado entretanto)
			if(prev.Link != returnedByNext) throw new IllegalStateException();
			
			prev.Link = returnedByNext.Link;
			
			sz -= 1;	// decrementar o n�mero de elementos na lista 

		}
	}

}
