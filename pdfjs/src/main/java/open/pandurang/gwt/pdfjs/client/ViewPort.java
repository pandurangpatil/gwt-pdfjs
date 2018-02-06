package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.JavaScriptObject;

public class ViewPort extends JavaScriptObject {
	protected ViewPort() {
	}

	public static ViewPort create() {
		return (ViewPort) createObject();
	}

	public final native int getWidth()/*-{
		return this.width;
	}-*/;

	public final native int getHeight()/*-{
		return this.height;
	}-*/;
}
