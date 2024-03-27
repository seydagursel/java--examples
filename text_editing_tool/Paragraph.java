
import java.util.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;


public class Paragraph {

	private ArrayList<String> lines;
	private int lineCount;

	private Document document;

	public Paragraph() {
		lines = new ArrayList<>();
		lineCount = 0;
	}

	public void addLine(String line) throws InvalidLine  {
		
	    if(line != null && !line.isEmpty()) {
	    	
	    	lines.add(line);
	        lineCount++;
	    	document.setAllLineCount(document.getAllLineCount() + 1);
	        
	    }
	    else {
	    	throw new InvalidLine("You entered a empty line please try again!");
	        
	    }
			
    }

	public void displayParagraph() {
		for (int i = 0; i < lineCount; i++) {
			System.out.println((i + 1) + ":\t" + lines.get(i));
		}
	}
	
	public int getLineCount() {
		return lineCount;
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public void setDocument(Document d) {
		document = d;
	}



}