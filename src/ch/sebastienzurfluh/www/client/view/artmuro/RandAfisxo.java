package ch.sebastienzurfluh.www.client.view.artmuro;

import com.google.gwt.user.client.ui.Widget;

public class RandAfisxo extends SimplaAfisxo {
	public RandAfisxo(Widget widget, int largxo, int alto, int randLargxo) {
		super(widget, largxo + 2 * randLargxo, alto + 2 * randLargxo);
		
		widget.getElement().setAttribute("style",
				"margin: " + randLargxo + "px; width:" + largxo + "px; height: " + alto + "px");
	}
}
