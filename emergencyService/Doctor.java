package deneme;

public class Doctor extends Person {

	private String field;

	public Doctor(String name, String surname, String field) {
		super(name, surname);
		this.field = field;
	}

	public String displayInfo() {
		//System.out.println("\nDisplaying Doctor:");
		//super.displayInfo();
		//System.out.println("Field is " + field);
		return "\nDisplaying Doctor:\n"+super.displayInfo()+"\nField is: " + field+"\n";
	}

	@Override
	public void getAppointment() {
		System.out.println("Doctor " + getName() + " makes an appointment with its superior.");
	}
	

}

