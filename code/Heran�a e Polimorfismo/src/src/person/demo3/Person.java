package person.demo3;

/**
 * NOTA: a palavra reservada => abstract <= NO MÉTODO getEmail, 
 *       indica que o método TEM que SER DEFINIDO NA CLASSE 
 *       DERIVADA (a não ser que também seja abtracta - faz sentido!)
 *                                                      
 * NOTA: As classes com métodos abstractos TÊM QUE SER abstractas
 *        -> Também me parece que faz sentido.
 *        -> Pensem o que seria criar uma instância e depois chamar o método em causa!!!
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
	
	/**
	 * Método ABSTRACTO (a definir nas classes derivadas - não estáticas) que
	 * retorna o email da pessoa de acordo com determinado critério.
	 * 
	 * @return email da pessoa
	 */
	public abstract String getEmail(); 
		
}

