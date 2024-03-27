
public class DetailedView extends PlainTextView {

	public DetailedView(Document d) {
		super(d);
	}
	
	@Override
	public void print() {
		int count = 0;
		for (int i = 0; i < getDocument().getParagraphs().size(); i++) {
			Paragraph tmp = getDocument().getParagraphs().get(i);
			for (int j = 0; j < tmp.getLineCount(); j++) {
				if (j == 0)
					System.out.println((count + 1) + ":\tP" + (i + 1) + "L" + (j + 1) + "\t    " + tmp.getLines().get(j));
				else
					System.out.println((count + 1) + ":\tP" + (i + 1) + "L" + (j + 1) + "\t" + tmp.getLines().get(j));
				count++;
			}
			System.out.println((count + 1) + ":");
			count++;
		}
	}

}
