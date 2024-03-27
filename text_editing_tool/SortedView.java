
package deneme;
import java.util.*;

public class SortedView extends PlainTextView {
	
	public SortedView (Document d) {
		super(d);
	}
	@Override
	public void print() {
		for (int i = 0; i < getDocument().getParagraphs().size(); i++) {
			Collections.sort(getDocument().getParagraphs(),new Document());
			
			Paragraph tmp = getDocument().getParagraphs().get(i);
			
			for (int j = 0; j < tmp.getLineCount(); j++) {
				if (j == 0)
					System.out.println("\t   " + tmp.getLines().get(j));
				else
					System.out.println(tmp.getLines().get(j));
				
			}
			System.out.println(" ");
			
		}
	}
}