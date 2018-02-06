package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.EntryPoint;

public class PDFJSOnModuleLoad implements EntryPoint {

	@Override
	public void onModuleLoad() {
		PDFJS.INSTANCE.loadAPI();
	}
}
