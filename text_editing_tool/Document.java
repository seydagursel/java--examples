import java.util.*;

public class Document implements Comparator<Paragraph> {

	private ArrayList<Paragraph> paragraphs;
	private int paragraphCount;
	private Integer allLineCount = 0;

	public Document() {
		paragraphs = new ArrayList<>();
		paragraphCount = 0;
	}

	public void addParagraph(Paragraph p) {
		p.setDocument(this);
		paragraphs.add(p);
		paragraphCount++;
	}

	public Integer getAllLineCount() {
		return allLineCount;
	}

	public void setAllLineCount(Integer allLineCount) {
		this.allLineCount = allLineCount;
	}

	public ArrayList<Paragraph> getParagraphs() {
		return paragraphs;
	}
    public Integer getParagraphCount() {
    	return paragraphCount;
    }
	public int compare(Paragraph p1,Paragraph p2) {
        int result= p1.getLineCount()-p2.getLineCount();
        if(result==0) {
        	StringBuffer tmpStr1=new StringBuffer();
        	StringBuffer tmpStr2=new StringBuffer();
            for(String s: p1.getLines()) {
            	tmpStr1.append(s);
                tmpStr1.append(" ");
            }
            for(String s: p2.getLines()) {
            	tmpStr2.append(s);
                tmpStr2.append(" ");
            }
            String tmpP1=tmpStr1.toString();
            String tmpP2=tmpStr2.toString();
        	return tmpP1.compareTo(tmpP2);
        }
        else
        	return result;
        	
	}
	public void search(String word) {
		LinkedList<String> tmpList = new LinkedList<>();
		
		for (int i = 0; i < paragraphCount; i++) {
			Paragraph tmp = paragraphs.get(i);
			for (int j = 0; j < tmp.getLineCount(); j++) {
				if (j == 0)
					tmpList.add("    " + tmp.getLines().get(j));
				else
					tmpList.add(tmp.getLines().get(j));
			}
			tmpList.add("\n");
		}
		
		String[] lines = tmpList.toArray(new String[tmpList.size()]);

		// storing found line indexes
		int[] foundLines = new int[lines.length];

		String[] parts = word.split(" ");

		// Search within lines first
		for (int i = 0; i < lines.length; i++) {
			if (lines[i] != null) {
				if (lines[i].contains(word)) {
					foundLines[i] = 1;
				}
			}
		}

		// if string to be search contains multiple words
		if (parts.length > 1) {
			// Search within all document to found matches at line endings

			// Merge lines in a single String using special characters
			String allLines = "";
			for (int i = 0; i < lines.length; i++) {
				if (lines[i] != null) {
					if (i == 0)
						allLines = lines[i];
					else
						allLines += "----" + lines[i];
				}
			}

			// Merge words in a single String using special characters
			String wordMerged = "";
			for (int i = 0; i < parts.length; i++) {
				if (i == 0)
					wordMerged = parts[i];
				else
					wordMerged += "----" + parts[i];
			}

			// if the string to be search is found within multiple lines
			if (allLines.contains(wordMerged)) {

				int tmpCount1 = 0;
				int fromIndex1 = 0;

				// find the index of those matches in the merged paragraph
				while ((fromIndex1 = allLines.indexOf(wordMerged, fromIndex1)) != -1) {

					tmpCount1++;
					fromIndex1++;

					int tmpCount2 = 0;

					int fromIndex2 = 0;

					// when index of match is found, count the occurrence of special
					// characters up until that index to find the line number
					while ((fromIndex2 < fromIndex1) && (fromIndex2 = allLines.indexOf("----", fromIndex2)) != -1) {
						tmpCount2++;
						fromIndex2++;
					}

					// store the found lines to print it on console
					if (foundLines[tmpCount2 - 1] == 1)
						foundLines[tmpCount2 - 1] = 4;
					else
						foundLines[tmpCount2 - 1] = 2;

				}
			}

		}

		for (int i = 0; i < foundLines.length; i++) {
			if (foundLines[i] == 1) {
				System.out.println("Found match at line #" + (i + 1));
			} else if (foundLines[i] == 2) {
				System.out.println("Found match at the end of line #" + (i + 1) + " and next line");
			} else if (foundLines[i] == 4) {
				System.out.println("Found match at line #" + (i + 1));
				System.out.println("Found match at the end of line #" + (i + 1) + " and next line");
			}
		}

	}

}
