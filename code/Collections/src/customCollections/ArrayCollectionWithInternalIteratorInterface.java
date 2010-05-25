package customCollections;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import iterators.ObjectArrayIterator;;

/**
 * Implementa��o da colec��o ArrayCollection em que � usada uma classe
 * interna para implementar o iterador (em vez de implementar a interface 
 * Iterator<Object> como em ArrayCollectionWithIteratorInterface.
 * 
 */public class ArrayCollectionWithInternalIteratorInterface 
 						implements Collection<Object> 
 {

	private final boolean autoGrow;				// indica se o array cresce automaticamente
	private static final int DEFAULT_SIZE = 4;	// n�mero de "slots" livres no modo de crescimento autom�tico
	
	private Object[] data;		// elementos da colec��o
	private int pos = 0;		// �ndice do pr�ximo "slot" livre no array
	
	// ########################################################################
	// Construction
	// ########################################################################

	// construtor auxiliar
	private ArrayCollectionWithInternalIteratorInterface(boolean isToAutoGrow, int dataSize)
	{
		autoGrow = isToAutoGrow;
		data = new Object[dataSize];
	}
	
	// Colec��o din�mica (cresce � medida das necessidades)
	public ArrayCollectionWithInternalIteratorInterface()
	{
		this(true, DEFAULT_SIZE);
	}
	
	// Colec��o com n�mero m�ximo de elementos
	public ArrayCollectionWithInternalIteratorInterface(int maxSize)
	{
		this(false, maxSize);
	}
	
	// ########################################################################
	// Manupulation
	// ########################################################################
	public boolean add(Object obj2Add)
	{
		// Se existe espa�o, basta adicionar e retornar true
		if(pos < data.length)
		{
			data[pos] = obj2Add;
			++pos;
			return true;
		}

		// Se n�o existe espa�o, 
		//    a) Se NAO TEM autoGrow retorna false 
		if(autoGrow == false) return false;

		//    b) se TEM autoGrow cresce e adiciona o elmento
		grow();
		return add(obj2Add);
	}

	private void grow()
	{
		// array data passa a ter o dobro do tamanho
		data = Arrays.copyOf(data, data.length * 2);
	}
	
	@Override
	public boolean addAll(Collection<? extends Object> sourceCollection) {
		
		Object[] sourceCollectionArray = sourceCollection.toArray();
		for(int i = 0; i < sourceCollection.size(); ++i)
		{
			Object elem = sourceCollectionArray[i];
			boolean res = add(elem);
			if(res == false) return false;
		}
		
		return true;
		
		// Vers�o que utiliza iteradores (sourceCollection implementa Iterable<Object>)
		/*
		for(Object elem: sourceCollection)
		{
			boolean res = add(elem);
			if(res == false) return false;
		}
		
		return true;
		*/
	}

	@Override
	public void clear() {
		data = new Object[DEFAULT_SIZE];
		pos = 0;
		
		// Tamb�m poderia ser feito com um iterador (hasNext / next / remove)
		//  homework!
	}

	@Override
	public boolean remove(Object objToRemove) {
		
		Iterator<Object> it = this.iterator();
		while(it.hasNext())
		{
			Object elem = it.next();
			if(elem.equals(objToRemove))
			{
				it.remove();
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> elemsToRemove) {
		
		boolean allElementsRemoved = true;
		for(Object objToRemove: elemsToRemove)
		{
			boolean res = remove(objToRemove);
			if(res == false) allElementsRemoved = false;
		}
		return allElementsRemoved;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	// ########################################################################
	// Query
	// ########################################################################	
	public int size() {
		return pos;
	}

	@Override
	public boolean isEmpty() {
		return pos == 0;
	}

	@Override
	public boolean contains(Object objToFind) {
		
		/*/ vers�o a) SEM iterador, com indexa��o
		// Desvantagem: Estamos a aceder directamente ao array [data]
		for(int i = 0; i < this.pos; ++i)
		{
			Object elem = this.data[i];
			if(elem.equals(objToFind))
				return true;
		}
		// */
		
		/*/ vers�o b) COM iterador, SEM "foreach"
		// Desvantagem: Pouco compacto!
		Iterator<Object> it = this.iterator();
		while(it.hasNext())
		{
			Object elem = it.next();
			if(elem.equals(objToFind))
				return true;
		}
		// */

		// vers�o c) COM "foreach"
		for(Object elem: this /* aqui coloca-se uma refer�ncia para algu�m que 
								 forne�a um Iterator<Object>, ou seja, 
								 Iterable<Object> */)
			if(elem.equals(objToFind)) 
				return true;
		// */
		
		
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	// ########################################################################
	// Iterator (from Iterable<Object>)
	// ########################################################################
	@Override
	public Iterator<Object> iterator() {
		return new ACIterator();
	}


	// ########################################################################
	// Auxiliar
	// ########################################################################

	@Override
	public Object[] toArray() {
		return data;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}

	// ########################################################################
	// Implementa��o da classe interna que implementa o Iterator<Object>
	// ########################################################################
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
	
}
