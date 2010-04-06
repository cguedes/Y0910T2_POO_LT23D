package person.demo1;

public class Person {
	
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

