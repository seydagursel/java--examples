package deneme;
public abstract class Person implements Appointment {

	private String name;
	private String surname;
    

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}


	public String displayInfo() {
		//System.out.println("The name is: " + name);
		//System.out.println("The surname is: " + surname);
		return "The name is: " + name + "\nThe surname is: " + surname;
	}

	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}

}