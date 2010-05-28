package linkedListCollections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

	
		Collection<Object> ll = new LinkedListCollection();
		
		ll.add("Um");
		ll.add("Dois");
		ll.add("Três");
		ll.add("Quatro");
				
		System.out.println(ll.size());
		
		// uso do iterador
		System.out.println("ITERATOR ----------------------------------------");
		Iterator<Object> lli = ll.iterator();
		while(lli.hasNext())
		{
			Object elem = lli.next();
			System.out.println("Elem: " + elem);
		}
		//Object elem = lli.next();	// lança excepção NoSuchElementException
		System.out.println("--------------------------------------------------");
		
		
		
	}

}

