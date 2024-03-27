import java.util.Scanner;

public class Patient extends Person {

	private long ID;
	private static int patientCount = 0;

	public Patient(String name, String surname, long ID) {
		super(name, surname);
		this.ID = ID;
		patientCount++;
	}

	public Patient(String name, String surname) {
		this(name, surname, 11111);
	}

	public static int getPatientCount() {
		return patientCount;
	}

	public String displayInfo() {
		//System.out.println("Displaying Patient:");
		//super.displayInfo();
		//System.out.println("ID is " + ID);
		return "\nDisplaying Patient:\n"+super.displayInfo()+"\nID is: " + ID+"\n";
	}

	@Override
	public void getAppointment() {
		System.out.println("Making an appointment for patient " + getName());
		System.out.println("Please enter a doctor name");
		Scanner sc = new Scanner(System.in);
		String tmpName = sc.nextLine();
		for (Appointment a : MainClass.list) {
			if (a instanceof Doctor) {
				Doctor d = (Doctor) a;
				if (d.getName().equals(tmpName)) {
					System.out.println("Patient " + getName() + " makes an appointment"
							+ " with doctor " + d.getName() + ".");
					return;
				}
			}
		}
		System.out.println("No such doctor name!");
	}

}
