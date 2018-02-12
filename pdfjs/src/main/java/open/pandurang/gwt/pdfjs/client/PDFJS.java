package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

public class PDFJS {
	public static final PDFJS INSTANCE = new PDFJS();

	private PDFJS() {
	}

	EventBus eventBus = new SimpleEventBus();

	public void onLoad() {
		eventBus.fireEvent(new PDFApiReadyEvent());
	}

	public HandlerRegistration addAPIReadyHandler(PDFApiReadyEventHandler handler) {
		return eventBus.addHandler(PDFApiReadyEvent.TYPE, handler);
	}

	public native void loadAPI()/*-{
		var that = this;
		var tag = $doc.createElement('script');
		tag.src = "https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.0.315/pdf.js";
		tag.async = true;
		tag.onload = function() {
			$wnd.PDFJS.workerSrc = 'https://cdnjs.cloudflare.com/ajax/libs/pdf.js/2.0.315/pdf.worker.js';
			that.@open.pandurang.gwt.pdfjs.client.PDFJS::onLoad()();
		}
		var firstScriptTag = $doc.getElementsByTagName('script')[0];
		firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
	}-*/;

	public native void getDocument(FileDetails file, FetchDocumentDone donehandler)/*-{
		$wnd.PDFJS
				.getDocument(file)
				.then(
						function(pdf_doc) {
							donehandler.@open.pandurang.gwt.pdfjs.client.FetchDocumentDone::onDone(Lopen/pandurang/gwt/pdfjs/client/PDFDoc;)(pdf_doc);
						},
						function(error) {
							donehandler.@open.pandurang.gwt.pdfjs.client.FetchDocumentDone::onError(Lopen/pandurang/gwt/pdfjs/client/Error;)(error);
						});
	}-*/;
}
