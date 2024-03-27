package deneme;

public enum MenuItem {

	M1("(1) Register a doctor"), M2("(2) Register a patient"), M3("(3) Display all doctors"),
	M4("(4) Display all patients"), M5("(5) Register an Ambulance Department"),
	M6("(6) Register a Fire Department"), M7("(7) Display all Ambulance Departments"),
	M8("(8) Display all Fire Departments"), M9("(9) Make an appointment"), M0("(0) Exit");

	private String s;

	private MenuItem(String s) {
		this.s = s;
	}

	public String getStr() {
		return s;
	}

}
