
public class AmbulanceDepartment extends EmergencyServices {

	public AmbulanceDepartment(String code) {
		super(code);
	}

	public void print() {
		System.out.println("AmbulanceDepartment");
		super.print();
	}

	@Override
	public void getAppointment() {
		System.out.println("An ambulance is displatched to the given address!");
	}

}
