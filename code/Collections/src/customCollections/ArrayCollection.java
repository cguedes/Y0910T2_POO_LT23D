package customCollections;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection implements Collection<Object> {

	private final boolean autoGrow;				// indica se o array cresce automaticamente
	private static final int DEFAULT_SIZE = 4;	// n�mero de "slots" livres no modo de crescimento autom�tico
	
	private Object[] data;		// elementos da colec��o
	private int pos = 0;		// �ndice do pr�ximo "slot" livre no array
	
	// ########################################################################
	// Construction
	// ########################################################################

	// construtor auxiliar
	private ArrayCollection(boolean isToAutoGrow, int dataSize)
	{
		autoGrow = isToAutoGrow;
		data = new Object[dataSize];
	}
	
	// Colec��o din�mica (cresce � medida das necessidades)
	public ArrayCollection()
	{
		this(true, DEFAULT_SIZE);
	}
	
	// Colec��o com n�mero m�ximo de elementos
	public ArrayCollection(int maxSize)
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
		Object[] iterableData = Arrays.copyOf(data, pos);
		return new iterators.ObjectArrayIterator(iterableData);
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
	
}
