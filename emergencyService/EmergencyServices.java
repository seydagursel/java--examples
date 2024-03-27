
public abstract class EmergencyServices implements Appointment {

	private String serviceCode;

	public EmergencyServices(String code) {
		serviceCode = code;
	}

	public void print() {
		System.out.println("Service name is " + serviceCode);
	}

}
