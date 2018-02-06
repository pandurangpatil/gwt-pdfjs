package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.event.shared.EventHandler;

public interface PDFApiReadyEventHandler extends EventHandler {

	void onApiReady(PDFApiReadyEvent event);
}
