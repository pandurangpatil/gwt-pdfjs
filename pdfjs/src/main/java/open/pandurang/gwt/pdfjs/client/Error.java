package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Error extends JavaScriptObject {
	protected Error() {
	}

	public static Error create() {
		return (Error) createObject();
	}

	public final native void setMessage(String message)/*-{
		this.message = message;
	}-*/;

	public final native String getMessage()/*-{
		return this.message;
	}-*/;
}
