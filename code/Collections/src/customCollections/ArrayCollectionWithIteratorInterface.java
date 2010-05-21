package customCollections;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import iterators.ObjectArrayIterator;;

public class ArrayCollectionWithIteratorInterface implements Collection<Object>, Iterator<Object> {

	private final boolean autoGrow;				// indica se o array cresce automaticamente
	private static final int DEFAULT_SIZE = 4;	// número de "slots" livres no modo de crescimento automático
	
	private Object[] data;		// elementos da colecção
	private int pos = 0;		// índice do próximo "slot" livre no array
	
	// ########################################################################
	// Construction
	// ########################################################################

	// construtor auxiliar
	private ArrayCollectionWithIteratorInterface(boolean isToAutoGrow, int dataSize)
	{
		autoGrow = isToAutoGrow;
		data = new Object[dataSize];
	}
	
	// Colecção dinâmica (cresce à medida das necessidades)
	public ArrayCollectionWithIteratorInterface()
	{
		this(true, DEFAULT_SIZE);
	}
	
	// Colecção com número máximo de elementos
	public ArrayCollectionWithIteratorInterface(int maxSize)
	{
		this(false, maxSize);
	}
	
	// ########################################################################
	// Manupulation
	// ########################################################################
	public boolean add(Object obj2Add)
	{
		// Se existe espaço, basta adicionar e retornar true
		if(pos < data.length)
		{
			data[pos] = obj2Add;
			++pos;
			return true;
		}

		// Se não existe espaço, 
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
		
		// Versão que utiliza iteradores (sourceCollection implementa Iterable<Object>)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
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
		// Não esquecer do "reset" ao índice do iterador
		iteratorPos = 0;
		return this;
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
	// Implementação da interface de Iterator<Object>
	// ########################################################################
	private int iteratorPos; // indice usado, pelo next, para retornar valores
	
	@Override
	public boolean hasNext() {
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
	
	
}
