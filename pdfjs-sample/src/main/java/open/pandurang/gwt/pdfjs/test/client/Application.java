package open.pandurang.gwt.pdfjs.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import open.pandurang.gwt.pdfjs.client.PDFApiReadyEvent;
import open.pandurang.gwt.pdfjs.client.PDFApiReadyEventHandler;
import open.pandurang.gwt.pdfjs.client.PDFJS;
import open.pandurang.gwt.pdfjs.client.PDFViewer;

public class Application implements EntryPoint {

	public void onModuleLoad() {
		final PDFViewer viewer = new PDFViewer();
		Button btn = new Button("CHANGE");
		btn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				viewer.updateFileUrl("/testfile.pdf");
			}
		});
		RootPanel.get().add(btn);
		PDFJS.INSTANCE.addAPIReadyHandler(new PDFApiReadyEventHandler() {

			@Override
			public void onApiReady(PDFApiReadyEvent event) {
				viewer.setWidth("1000px");
				viewer.setFileUrl("http://127.0.0.1:8888/multi-page.pdf");
				RootPanel.get().add(viewer);
			}
		});
		// HTMLPanel panel = new HTMLPanel("");
		// RootPanel.get().add(panel);
		// panel.setHeight("90vh");
		//
		// PDFJS.INSTANCE.addAPIReadyHandler(new PDFApiReadyEventHandler() {
		//
		// @Override
		// public void onApiReady(PDFApiReadyEvent event) {
		// // TODO Auto-generated method stub
		// FileDetails file = FileDetails.create();
		// file.setUrl("http://127.0.0.1:8888/multi-page.pdf");
		// PDFJS.INSTANCE.getDocument(file, new FetchDocumentDone() {
		//
		// @Override
		// public void onError(Error error) {
		// }
		//
		// @Override
		// public void onDone(PDFDoc doc) {
		// GWT.log("Here it comes");
		// GWT.log("No of pages -> " + doc.getNumPages());
		// int lastHeight = 0;
		// for (int index = 1; index <= doc.getNumPages(); index++) {
		// doc.getPage(index, new GetPageDone() {
		//
		// @Override
		// public void onError(Error error) {
		//
		// }
		//
		// @Override
		// public void onDone(PDFPage page) {
		// Canvas canvas = Canvas.createIfSupported();
		// int width = panel.getElement().getClientWidth() - 50;
		// GWT.log("Panel Client width -> " + width + "px");
		// canvas.getElement().setAttribute("width", width + "");
		// GWT.log("Canvas Client width -> " + canvas.getElement().getClientWidth());
		// double scaleRequired = new Double(width) / page.getViewPort(1).getWidth();
		// GWT.log("GWT scale required." + scaleRequired);
		// ViewPort viewPort = page.getViewPort(scaleRequired);
		// canvas.getElement().setAttribute("height",
		// (lastHeight + viewPort.getHeight()) + "");
		// RenderContext rctx = RenderContext.create();
		// Context2d ctx = canvas.getContext2d();
		// rctx.setCanvasContext(ctx);
		// rctx.setViewPort(viewPort);
		// page.render(rctx, new RenderComplete() {
		//
		// @Override
		// public void onError(Error error) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void onComplete() {
		// GWT.log("Page rendered ");
		// }
		// });
		// panel.add(canvas);
		// }
		// });
		//
		// }
		// }
		// });
		//
		// }
		// });
	}
}
