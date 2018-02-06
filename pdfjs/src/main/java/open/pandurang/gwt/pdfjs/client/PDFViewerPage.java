package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class PDFViewerPage extends Composite {

	private static PDFViewerPageUiBinder uiBinder = GWT.create(PDFViewerPageUiBinder.class);

	interface PDFViewerPageUiBinder extends UiBinder<Widget, PDFViewerPage> {
	}

	@UiField(provided = true)
	Canvas canvas;
	HTMLPanel panel;

	public PDFViewerPage() {
		canvas = Canvas.createIfSupported();
		panel = (HTMLPanel) uiBinder.createAndBindUi(this);
		initWidget(panel);
		String existing = panel.getElement().getAttribute("style");
		panel.getElement().setAttribute("style", existing + "border: 1px gray solid; margin-bottom: 20px; box-shadow: 0px 0px 8px grey;");

	}

	public Context2d getContext() {
		return canvas.getContext2d();
	}

	public void setWidth(int width) {
		canvas.getElement().setAttribute("width", width + "");
	}

	public void setHeight(int height) {
		canvas.getElement().setAttribute("height", height + "");
	}

}
