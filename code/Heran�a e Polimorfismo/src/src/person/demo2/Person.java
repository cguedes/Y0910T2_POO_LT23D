package person.demo2;

/**
 * NOTA: a palavra reservada => abstract <= faz com que 
 *       não seja possível criar instâncias do tipo     
 *       definido por esta classe.                      
 *                                                      
 *   Apesar disto, é possível (e necessário) chamar o 
 *   construtor definido nesta classe nas suas classes
 *   derivadas (i.e: Student, Teacher) 
 *                                                      
 */
public abstract class Person {
	
	private Gender gender;
	private String name;
	private int number;

	public Person(int number, String name, Gender gender) {
		setNumber(number);
		setName(name);
		setGender(gender);
	}

	public void setGender(Gender g) { gender = g; }
	public Gender getGender() { return gender; }

	public void setName(String n) { this.name = n; }
	public String getName() { return name; }
	
	public void setNumber(int n) { this.number = n; }
	public int getNumber() { return this.number; }
	
	public String toString() {
		return String.format("%d: %s (%s)", getNumber(), getName(), getGender());
	}
		
}

