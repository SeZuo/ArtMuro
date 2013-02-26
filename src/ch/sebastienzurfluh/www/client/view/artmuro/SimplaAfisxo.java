/*
 * Copyright 2013 Sebastien Zurfluh
 * 
 * This file is part of "MiaRetumejo".
 * 
 * "MiaRetumejo" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "MiaRetumejo" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with "MiaRetumejo".  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.sebastienzurfluh.www.client.view.artmuro;

import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class SimplaAfisxo extends SimplePanel implements Afisxo {
	private int largxo, alto;
	
	public SimplaAfisxo(Widget widget, int largxo, int alto) {
		setWidget(widget);
		this.largxo = largxo;
		this.alto = alto;
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
