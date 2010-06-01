package linkedListCollections;

import java.util.*;

import collection.POOAbstractCollection;

/**
 * 	Colecção de objectos baseda em lista ligada (conjunto de nós)
 * 
 */
public class LinkedListCollectionExtendedFromAbstract 
					extends POOAbstractCollection 
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
	public LinkedListCollectionExtendedFromAbstract()
	{
		// Adição da sentinela (para simplificar a adição/remoção)
		head = new Node(null);	// A sentinela não tem valor definido!
	}
	
	// ########################################################################
	// Manupulation
	// ########################################################################
	public boolean add(Object obj2Add)
	{
		// Criar o novo nó
		Node newNode = new Node(obj2Add);
		
		// Adicionar o novo nó "na cabeça da lista" 
		//  -> a seguir à sentinela e antes do primeiro nó
		newNode.Link = head.Link;
		head.Link = newNode;
		
		// Nota: head.Link é uma referência para o 1º nó da lista
		
		++sz;
		return true;
		
	}

	// Implementação mais eficiente :-)
	@Override
	public void clear() {
		head.Link = null;
		sz = 0;
	}

	// Implementação mais eficiente :-)
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
	
	// 	»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»» 
	// 	Implementação da classe interna que implementa o Iterator<Object>
	// 	«««««««««««««««««««««««««««««««««««««««««««««««««««««««««««««««««
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
			
			// Se houve remoção prev fica igual
			// Caso contrário prev = returnedByNext
			if(prev == null || prev.Link == returnedByNext) {
				// Não houve remoção
				// actualizar o prev antes de avançar
				prev = returnedByNext;				
			}
			
			// avançar o returnedByNext
			returnedByNext = returnedByNext.Link;

			// Retornar o valor contido em returnedByNext
			return returnedByNext.Value;
		}
		
		@Override
		public void remove() 
		{
			// Lançar excepção porque o next nunca foi chamado
			if(prev == null) throw new IllegalStateException();
			
			// Lançar excepção porque o remove já foi chamado uma vez (e next não foi chamado entretanto)
			if(prev.Link != returnedByNext) throw new IllegalStateException();
			
			prev.Link = returnedByNext.Link;
			
			sz -= 1;	// decrementar o número de elementos na lista 

		}
	}

}
