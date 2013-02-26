package ch.sebastienzurfluh.www.client.view.artmuro;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class SimplaAfisxo extends SimplePanel implements Afisxo {
	private int largxo, alto;
	private Widget widget;
	
	public SimplaAfisxo(Widget widget, int largxo, int alto) {
		setWidget(widget);
		this.largxo = largxo;
		this.alto = alto;
		this.widget = widget;
	}

	@Override
	public int petiLargxo() {
		return largxo;
	}

	@Override
	public int petiAlto() {
		return alto;
	}
}
