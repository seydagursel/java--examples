
public class PlainTextView {

	private Document document;

	public PlainTextView(Document d) {
		document = d;
	}

	public void print() {
		for (int i = 0; i < document.getParagraphs().size(); i++) {
			Paragraph tmp = document.getParagraphs().get(i);
			for (int j = 0; j < tmp.getLineCount(); j++) {
				System.out.println(tmp.getLines().get(j));
			}
		}
	}

	public Document getDocument() {
		return document;
	}

}
