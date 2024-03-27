
public class FormattedView extends PlainTextView {
	
	public FormattedView(Document d) {
		super(d);
	}
	
	@Override
	public void print() {
		int count = 0;
		for (int i = 0; i < getDocument().getParagraphs().size(); i++) {
			Paragraph tmp = getDocument().getParagraphs().get(i);
			for (int j = 0; j < tmp.getLineCount(); j++) {
				if (j == 0)
					System.out.println((count + 1) + ":\t    " + tmp.getLines().get(j));
				else
					System.out.println((count + 1) + ":\t" + tmp.getLines().get(j));
				count++;
			}
			System.out.println((count + 1) + ":\t");
			count++;
		}
	}

}
