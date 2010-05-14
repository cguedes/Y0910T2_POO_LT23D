package iterators;

import java.util.Iterator;

public class IteratorsTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//testRandomNumbersIterator();
		
		testStringArrayIterator();

	}

	private static void testRandomNumbersIterator() 
	{
		Iterator<Integer> ri = new RandomNumberIterator();
		while(ri.hasNext())
		{
			Integer i = ri.next();
			System.out.println(i.intValue());
		}
	}
	
	private static void testStringArrayIterator() {

		String[] names = new String[] {
				"Alabama",
				"Alaska",
				"Arizona",
				"Arkansas",
				"California",
				"Colorado",
				"Connecticut",
				"Delaware",
				"District of Columbia",
				"Florida",
				"Georgia",
				"Hawaii",
				"Idaho"
		};
		
		Iterator<String> si = new StringArrayIterator(names);
		while( si.hasNext() )
		{
			String name = si.next();
			System.out.println(name);
		}
		
	}



}
