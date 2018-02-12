package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class PDFViewer extends Composite {

	private static PDFViewerUiBinder uiBinder = GWT.create(PDFViewerUiBinder.class);

	interface PDFViewerUiBinder extends UiBinder<Widget, PDFViewer> {
	}

	HTMLPanel parentPanel;
	@UiField
	HTMLPanel panel;
	@UiField
	DivElement loaderElement;

	private FileDetails file;
	private EventBus eventBus = new SimpleEventBus();

	public PDFViewer() {
		parentPanel = (HTMLPanel) uiBinder.createAndBindUi(this);
		initWidget(parentPanel);
		setHeight("90vh");
		String existing = parentPanel.getElement().getAttribute("style");
		parentPanel.getElement().setAttribute("style",
				existing + "overflow-y: scroll; border: 1px black solid; padding: 20px;");
	}

	public FileDetails getFile() {
		return file;
	}

	public void setFile(FileDetails file) {
		this.file = file;
	}

	public void updateFile(FileDetails file) {
		this.file = file;
		render();
	}

	public void setWidth(String width) {
		this.panel.setWidth(width);
	}

	public void setHeight(String height) {
		this.panel.setHeight(height);
	}

	public HandlerRegistration addErrorHandler(ErrorHandler handler) {
		return eventBus.addHandler(ErrorEvent.TYPE, handler);
	}

	public void showLoader(boolean flag) {
		if (flag) {
			loaderElement.setAttribute("style", "text-align: center; margin: 40px;");
		} else {
			loaderElement.setAttribute("style", "display: none;");
		}
	}

	private void render() {
		panel.clear();
		showLoader(true);
		PDFJS.INSTANCE.getDocument(file, new FetchDocumentDone() {

			@Override
			public void onError(Error error) {
				showLoader(false);
				eventBus.fireEvent(new ErrorEvent(error));
			}

			@Override
			public void onDone(PDFDoc doc) {
				showLoader(false);
				for (int index = 1; index <= doc.getNumPages(); index++) {
					doc.getPage(index, new GetPageDone() {
						@Override
						public void onError(Error error) {
							eventBus.fireEvent(new ErrorEvent(error));
						}

						@Override
						public void onDone(PDFPage page) {
							int width = panel.getElement().getClientWidth() - 50;
							GWT.log("Panel Client width -> " + width + "px");
							PDFViewerPage pagec = new PDFViewerPage();
							pagec.setWidth(width);
							double scaleRequired = new Double(width) / page.getViewPort(1).getWidth();
							GWT.log("GWT scale required." + scaleRequired);
							ViewPort viewPort = page.getViewPort(scaleRequired);
							pagec.setHeight(viewPort.getHeight());
							RenderContext rctx = RenderContext.create();
							Context2d ctx = pagec.getContext();
							rctx.setCanvasContext(ctx);
							rctx.setViewPort(viewPort);
							page.render(rctx, new RenderComplete() {

								@Override
								public void onError(Error error) {
									eventBus.fireEvent(new ErrorEvent(error));
								}

								@Override
								public void onComplete() {
									GWT.log("Page rendered ");
								}
							});
							panel.add(pagec);
						}
					});
				}
			}
		});
	}

	@Override
	public void onLoad() {
		if (file != null) {
			render();
		}
	}

}
