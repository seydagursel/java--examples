import java.util.*;
public class MyComparator implements Comparator<Doctor> {
	
	public int compare(Doctor a,Doctor b) {
		int result= a.getSurname().compareTo(b.getSurname());
		if(result==0) {
			return a.getName().compareTo(b.getName());
		}
		else {
			return result;
		}

		
	}

}
