package open.pandurang.gwt.pdfjs.client;

public interface GetPageDone {

	void onDone(PDFPage page);

	void onError(Error error);
}
