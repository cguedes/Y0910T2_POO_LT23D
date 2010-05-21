package iterators;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import customCollections.ArrayCollection;

public class ObjectArrayIterator implements Iterator<Object> {

	private final Object[] input;
	private int pos;						// primeiro índice válido  (vai ser incrmentado em cada next)
	private final int firstInvalidIndex;	// primeiro índice inválido
	private final ArrayCollection arrayCollection;
	
	public ObjectArrayIterator(Object[] input, int from, int to, ArrayCollection ac) {
		this.input = input;
		this.pos = from;
		this.firstInvalidIndex = to;
		this.arrayCollection = ac;
		
	}

	@Override
	public boolean hasNext() {
		return input != null && pos < firstInvalidIndex;
	}

	@Override
	public Object next() {
		if(!hasNext()) throw new NoSuchElementException();
		
		Object strReturn = input[pos];
		++pos;
		return strReturn;
	}

	@Override
	public void remove() {
		// Para remover o elemento (último retornado pelo next), 
		//  movem-se todos os seguintes elementos para trás
		//   ex: para remover input[4] movemos para input[4] = input[5] e "por ai em diante" até firstInvalidIndex
		
		int from = pos;
		int to = firstInvalidIndex;
		int dst = pos - 1;
		
		while(from < to) {
			input[dst++] = input[from++];
		}
		
		arrayCollection.pos -= 1;
		
	}

}
