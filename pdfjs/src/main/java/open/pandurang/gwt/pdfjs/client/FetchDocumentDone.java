package open.pandurang.gwt.pdfjs.client;

public interface FetchDocumentDone {

	void onDone(PDFDoc doc);

	void onError(Error error);
}
