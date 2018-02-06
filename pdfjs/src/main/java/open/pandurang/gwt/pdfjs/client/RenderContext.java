package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public class RenderContext extends JavaScriptObject {
	protected RenderContext() {
	}

	public static RenderContext create() {
		return (RenderContext) createObject();
	}

	public final native Context2d getCanvasContext()/*-{
		return this.canvasContext;
	}-*/;

	public final native void setCanvasContext(Context2d context)/*-{
		return this.canvasContext = context;
	}-*/;

	public final native ViewPort getViewPort()/*-{
		return this.viewport;
	}-*/;

	public final native void setViewPort(ViewPort viewport)/*-{
		return this.viewport = viewport;
	}-*/;
}
