package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.JavaScriptObject;

public class FileDetails extends JavaScriptObject {
	protected FileDetails() {
	}

	public static FileDetails create() {
		return (FileDetails) createObject();
	}

	public final native void setUrl(String url)/*-{
		this.url = url;
	}-*/;

	public final native String getUrl()/*-{
		return this.url;
	}-*/;

	public final native void setPassword(String password)/*-{
		this.password = password;
	}-*/;

	public final native String getPassword()/*-{
		return this.password;
	}-*/;

}
