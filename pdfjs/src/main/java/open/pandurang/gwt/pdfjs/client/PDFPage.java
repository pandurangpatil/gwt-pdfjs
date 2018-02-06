package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.core.client.JavaScriptObject;

public class PDFPage extends JavaScriptObject {
	protected PDFPage() {
	}

	public static PDFPage create() {
		return (PDFPage) createObject();
	}

	public final native ViewPort getViewPort(double scale)/*-{
		return this.getViewport(scale);
	}-*/;

	public final native void render(RenderContext context, RenderComplete handler)/*-{
		this
				.render(context)
				.then(
						function() {
							handler.@open.pandurang.gwt.pdfjs.client.RenderComplete::onComplete()();
						});
	}-*/;
}
