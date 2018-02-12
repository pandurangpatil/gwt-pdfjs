package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.JavaScriptObject;

public class PDFDoc extends JavaScriptObject {
	protected PDFDoc() {
	}

	public static PDFDoc create() {
		return (PDFDoc) createObject();
	}

	public final native int getNumPages()/*-{
		return this.numPages;
	}-*/;

	public final native void getPage(int pageno, GetPageDone handler)/*-{
		console.log(pageno);
		this
				.getPage(pageno)
				.then(
						function(page) {
							handler.@open.pandurang.gwt.pdfjs.client.GetPageDone::onDone(Lopen/pandurang/gwt/pdfjs/client/PDFPage;)(page);
						},
						function(error) {
							handler.@open.pandurang.gwt.pdfjs.client.GetPageDone::onError(Lopen/pandurang/gwt/pdfjs/client/Error;)(error);
						});
	}-*/;

}
