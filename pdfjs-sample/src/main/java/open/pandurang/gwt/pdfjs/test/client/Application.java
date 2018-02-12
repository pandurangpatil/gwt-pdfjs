package open.pandurang.gwt.pdfjs.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import open.pandurang.gwt.pdfjs.client.ErrorEvent;
import open.pandurang.gwt.pdfjs.client.ErrorHandler;
import open.pandurang.gwt.pdfjs.client.FileDetails;
import open.pandurang.gwt.pdfjs.client.PDFApiReadyEvent;
import open.pandurang.gwt.pdfjs.client.PDFApiReadyEventHandler;
import open.pandurang.gwt.pdfjs.client.PDFJS;
import open.pandurang.gwt.pdfjs.client.PDFViewer;

public class Application implements EntryPoint {

	public void onModuleLoad() {
		TextBox tbp = new TextBox();
		TextBox tb = new TextBox();
		final PDFViewer viewer = new PDFViewer();
		viewer.addErrorHandler(new ErrorHandler() {

			@Override
			public void onError(ErrorEvent event) {
				Window.alert("Error message -> " + event.getError().getMessage() + " -> Name -> "
						+ event.getError().getName() + " -> code -> " + event.getError().getCode());
			}
		});
		Button btn = new Button("CHANGE");
		btn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				FileDetails file = FileDetails.create();
				file.setUrl(tb.getValue());
				if (tbp.getValue() != null && !tbp.getValue().trim().isEmpty()) {
					file.setPassword(tbp.getValue());
				}
				viewer.updateFile(file);
			}
		});
		RootPanel.get().add(tbp);
		RootPanel.get().add(tb);
		RootPanel.get().add(btn);
		PDFJS.INSTANCE.addAPIReadyHandler(new PDFApiReadyEventHandler() {

			@Override
			public void onApiReady(PDFApiReadyEvent event) {
				FileDetails file = FileDetails.create();
				file.setUrl("/multi-page.pdf");
				viewer.setFile(file);
				RootPanel.get().add(viewer);
			}
		});
	}
}
