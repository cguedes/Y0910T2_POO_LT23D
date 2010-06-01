package collection;

import java.util.*;

/**
 * 	Colecção abstracta de objectos
 *   
 *   
 *    -> Apenas é necessário implementar, nas classes derivadas:
 *          -> o método add
 *          -> o iterador
 *          -> eventuais construtores :-)
 * 
 */
public abstract class POOAbstractCollection implements Collection<Object>
 {
	// ########################################################################
	// Manupulation
	// ########################################################################
	@Override
	public boolean addAll(Collection<? extends Object> sourceCollection) {

		Iterator<? extends Object> i = sourceCollection.iterator();
		boolean addedAllElements = true; 
		while(i.hasNext())
			if( add( i.next() ) == false )
				addedAllElements = false;
		
		return addedAllElements;

	}

	@Override
	public void clear() {
		Iterator<? extends Object> i = this.iterator();
		while(i.hasNext())
		{
			i.next();
			i.remove();
		}
	}

	@Override
	public boolean remove(Object objToRemove) {
		Iterator<? extends Object> i = this.iterator();
		while(i.hasNext())
		{
			Object elem = i.next();
			if( objToRemove.equals(elem) )
			{
				i.remove();
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> elemsToRemove) {

		boolean removedAllElements = true;
		
		// Removem-se todos os elementos que são iguais 
		//  aos elementos de elemsToRemove
		for(Object objToRemove: elemsToRemove)
		{
			boolean objRemoved = remove(objToRemove);
			if(objRemoved == false)
				removedAllElements = false;
		}
		
		return removedAllElements;
	}
	
	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	// ########################################################################
	// Query
	// ########################################################################	
	public int size() {
		int sz = 0;
		Iterator<? extends Object> i = this.iterator();
		while(i.hasNext()) {
			i.next();
			++sz;
		}
		
		return sz;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object objToFind) {
		Iterator<? extends Object> i = this.iterator();
		while(i.hasNext())
		{
			Object elem = i.next();
			if( objToFind.equals(elem) )
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> collectionToFind) {
		Iterator<? extends Object> i = collectionToFind.iterator();
		while(i.hasNext())
		{
			Object objToFind = i.next();
			if( this.contains(objToFind) == false )
			{
				return false;
			}
		}
		return true;
	}
	
	// ########################################################################
	// Auxiliar
	// ########################################################################

	@Override
	public Object[] toArray() {
		Object[] data = new Object[ size() ];
		int dataIdx = 0;

		Iterator<? extends Object> i = this.iterator();
		while(i.hasNext())
		{
			data[dataIdx++] = i.next();
		}

		return data;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}


}
