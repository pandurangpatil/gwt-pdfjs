package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Error extends JavaScriptObject {
	protected Error() {
	}

	public static Error create() {
		return (Error) createObject();
	}

	public final native String getMessage()/*-{
		return this.message;
	}-*/;

	public final native String getName()/*-{
		return this.name;
	}-*/;

	public final native String getCode()/*-{
		return this.code;
	}-*/;
}
