package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class PDFViewer extends Composite {

	private static PDFViewerUiBinder uiBinder = GWT.create(PDFViewerUiBinder.class);

	interface PDFViewerUiBinder extends UiBinder<Widget, PDFViewer> {
	}

	HTMLPanel panel;
	private String fileUrl;

	public PDFViewer() {
		panel = (HTMLPanel) uiBinder.createAndBindUi(this);
		initWidget(panel);
		setHeight("90vh");
		String existing = panel.getElement().getAttribute("style");
		panel.getElement().setAttribute("style",
				existing + "overflow-y: scroll; border: 1px black solid; padding: 20px;");
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public void updateFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
		render();
	}

	public void setWidth(String width) {
		this.panel.setWidth(width);
	}

	public void setHeight(String height) {
		this.panel.setHeight(height);
	}

	private void render() {
		panel.clear();
		FileDetails file = FileDetails.create();
		file.setUrl(fileUrl);
		PDFJS.INSTANCE.getDocument(file, new FetchDocumentDone() {

			@Override
			public void onError(Error error) {
				// TODO: This doesn't get call as JSNI doesn't allow you to call catch method of
				// promise
			}

			@Override
			public void onDone(PDFDoc doc) {
				for (int index = 1; index <= doc.getNumPages(); index++) {
					doc.getPage(index, new GetPageDone() {
						@Override
						public void onError(Error error) {
							// TODO: This doesn't get call as JSNI doesn't allow you to call catch method of
							// promise
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
									// TODO Auto-generated method stub

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
		if (fileUrl != null && !fileUrl.isEmpty()) {
			render();
		}
	}

}
