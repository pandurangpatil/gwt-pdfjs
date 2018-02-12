package open.pandurang.gwt.pdfjs.client;

import com.google.gwt.event.shared.EventHandler;

public interface ErrorHandler extends EventHandler {

	void onError(ErrorEvent event);
}
