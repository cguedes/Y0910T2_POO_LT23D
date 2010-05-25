package customCollections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		testAdd();
		testAddElementsToLimitedSizeCollection();
		testAddElementsToUnlimitedSizeCollection();
		testAddAll();
		testIteratorHasNextAndNext();
		
		testIteratorRemove();
		testIteratorRemoveInArrayCollectionWithIteratorInterface();
		
	}
	
	private static void testAdd()
	{
		System.out.println("Inicio do teste [testAdd]");

		// ArrayCollection é uma colecção de Objectos.
		Collection<Object> ac = new ArrayCollection();
		
		int sz = ac.size();
		if(sz != 0) System.err.println("Erro, o size tem que ser zero");
		
		Object objToAdd = "Programação";
		boolean addSuccedded = ac.add( objToAdd );
		if(!addSuccedded) System.err.println("Erro ao adicionar o elemento na colecção");
		
		sz = ac.size();
		if(sz != 1) System.err.println("Erro, o size tem que ser um");
		
		// Verificar se o valor adicionado está contido na colecção
		Object[] collectionObjects = ac.toArray();
		if(collectionObjects[0] != objToAdd)
			System.err.println("Erro, o elemento adicionado não se encontra na colecção");
		
		System.out.println("Fim do teste [testAdd]");
	}

	private static void testAddElementsToLimitedSizeCollection() {
		
		System.out.println("Inicio do teste [testAddElementsToLimitedSizeCollection]");

		// Nota: O construtor com inteiro define uma colecção com tamanho máximo
		Collection<Object> ac = new ArrayCollection(4);
		
		boolean addSuccess = 
			ac.add("Um")   && 
			ac.add("Dois") && 
			ac.add("Três") &&
			ac.add("Quatro");
		
		if(addSuccess == false) 
			System.err.println("Erro ao adicionar um dos quatro primeiros elementos");
		
		if( ac.add("Cinco") != false )
			System.err.println("Erro, o add do 5º elemento deve retornar false.");
		
		int sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 4) System.err.println("Erro, o size tem que ser quatro");

		System.out.println("Fim do teste [testAddElementsToLimitedSizeCollection]");
	}

	private static void testAddElementsToUnlimitedSizeCollection() {
		
		System.out.println("Inicio do teste [testAddElementsToUnlimitedSizeCollection]");

		// Nota: O construtor SEM PARAMETROS define uma colecção SEM tamanho máximo
		// Nota: Sabemos que o tamanho por omissão é 4
		Collection<Object> ac = new ArrayCollection();
		
		ac.add("Um"); 
		ac.add("Dois"); 
		ac.add("Três");
		ac.add("Quatro");
		
		int sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 4) System.err.println("Erro, o size tem que ser quatro");

		ac.add("Cinco");
		ac.add("Seis");
		ac.add("Sete");
		
		sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 7) System.err.println("Erro, o size tem que ser sete");

		System.out.println("Fim do teste [testAddElementsToUnlimitedSizeCollection]");
	}
	
	private static void testAddAll() {

		System.out.println("Inicio do teste [testAddAdd]");

		Collection<Object> source = new ArrayCollection(3);
		source.add("Um");
		source.add("Dois");
		source.add("Três");
		
		Collection<Object> ac = new ArrayCollection();
		ac.add("Zero");
		ac.addAll( source );		// Método em TESTE
		ac.add("Quatro");
		int sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 5) System.err.println("Erro, o size tem que ser cinco");
		
		System.out.println("Fim do teste [testAddAdd]");
		
	}
	
	private static void testIteratorHasNextAndNext() {

		System.out.println("Inicio do teste [testIteratorHasNextAndNext]");

		Collection<Object> ac = new ArrayCollection();
		ac.add("Zero");
		ac.add("Um");
		ac.add("Dois");
		ac.add("Três");
		ac.add("Quatro");
		int sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 5) System.err.println("Erro, o size tem que ser cinco");
		
		Iterator<Object> it = ac.iterator();
		while(it.hasNext())
		{
			Object elem = it.next();
			System.out.println("Elem = " + elem);
		}
		
		try {
			Object dummy = it.next();
			// Nunca chegamos aqui!
			System.err.println("Erro, devia ter sido lançada excepção NoSuchElementException!");
		}
		catch(NoSuchElementException exp)
		{
			System.out.print("Tudo Ok :-). Foi lançada excepção por não ser possível ");
			System.out.println("usar o next depois de o hasNext ter retornado false.");
		}
		
		System.out.println("Fim do teste [testIteratorHasNextAndNext]");
		
	}

	
	private static void testIteratorRemove() {

		System.out.println("Inicio do teste [testIteratorRemove]");

		Collection<Object> ac = new ArrayCollection();
		ac.add("Zero");
		ac.add("Um");
		ac.add("Dois");
		ac.add("Três");
		ac.add("Quatro");
		int sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 5) System.err.println("Erro, o size tem que ser cinco");
		
		// Iterar até "Dois" e removê-lo
		Iterator<Object> it = ac.iterator();
		while(it.hasNext())
		{
			Object elem = it.next();
			if("Dois".equals(elem))
			{
				it.remove();
			}
		}
		
		// Mostrar os elementos da colecção, e respectivo size
		for(Object elem: ac)
		{
			System.out.println(elem);
		}
		
		sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 4) System.err.println("Erro, o size tem que ser quatro");
		
		
		System.out.println("Fim do teste [testIteratorRemove]");
		
	}


	private static void testIteratorRemoveInArrayCollectionWithIteratorInterface() {

		System.out.println("Inicio do teste [testIteratorRemoveInArrayCollectionWithIteratorInterface]");

		Collection<Object> ac = new ArrayCollectionWithInternalIteratorInterface();
		ac.add("Zero");
		ac.add("Um");
		ac.add("Dois");
		ac.add("Três");
		ac.add("Quatro");
		int sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 5) System.err.println("Erro, o size tem que ser cinco");
		
		// Iterar até "Dois" e removê-lo
		Iterator<Object> it = ac.iterator();
		while(it.hasNext())
		{
			Object elem = it.next();
			if("Dois".equals(elem))
			{
				it.remove();
			}
		}
		
		// Mostrar os elementos da colecção, e respectivo size
		for(Object elem: ac)
		{
			System.out.println(elem);
		}
		
		sz = ac.size();
		System.out.println("Size: " + sz);
		if(sz != 4) System.err.println("Erro, o size tem que ser quatro");
		
		
		System.out.println("Fim do teste [testIteratorRemoveInArrayCollectionWithIteratorInterface]");
		
	}
}









