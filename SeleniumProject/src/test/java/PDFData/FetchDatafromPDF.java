package PDFData;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchDatafromPDF {

	public static void main(String[] args) throws Throwable {

		File file = new File("./src/test/resources/Document.pdf");
		PDDocument doc = PDDocument.load(file);

		int pages = doc.getNumberOfPages();
		System.out.println(pages);

		PDFTextStripper pdfData = new PDFTextStripper();
		// String readDoc = pdfData.getText(doc);
		// System.out.println(readDoc);

		pdfData.setStartPage(7);
		String readDoc = pdfData.getText(doc);
		System.out.println(readDoc);

		// pdfData.setStartPage(1);
		// pdfData.setEndPage(2);
		// String readDoc = pdfData.getText(doc);
		// System.out.println(readDoc);

	}

}
