package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.event.shared.GwtEvent;

public class PDFApiReadyEvent extends GwtEvent<PDFApiReadyEventHandler> {

	public static Type<PDFApiReadyEventHandler> TYPE = new Type<PDFApiReadyEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PDFApiReadyEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PDFApiReadyEventHandler handler) {
		handler.onApiReady(this);
	}
}