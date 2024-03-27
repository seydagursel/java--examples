
public enum MenuItems {
	
	M1("1. Create a paragraph"), M2("2. Enter a new line"),
	M3("3. Display a single paragraph by number"), M4("4. Display all document"),
	M5("5. Search for a word"), M6("6. Exit");
	
	private String str;
	
	private MenuItems(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}

}
