package person.demo2;

public class Teacher extends Person {

	private int nif;

	public Teacher(int number, String name, Gender gender, int nif) {
		super(number, name, gender);
		this.setNif(nif);
	}

	public void setNif(int nif) { this.nif = nif; }
	public int getNif() { return nif; 	}

}
