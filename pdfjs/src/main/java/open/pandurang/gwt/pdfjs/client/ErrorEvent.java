package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.event.shared.GwtEvent;

public class ErrorEvent extends GwtEvent<ErrorHandler> {

	public static Type<ErrorHandler> TYPE = new Type<ErrorHandler>();

	private Error error;

	public ErrorEvent(Error error) {
		this.error = error;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ErrorHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ErrorHandler handler) {
		handler.onError(this);
	}

	public Error getError() {
		return error;
	}
}