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

import com.google.gwt.user.client.ui.Widget;

public class RandAfisxo extends SimplaAfisxo {
	public RandAfisxo(Widget widget, int largxo, int alto, int randLargxo) {
		super(widget, largxo + 2 * randLargxo, alto + 2 * randLargxo);
		
		widget.getElement().setAttribute("style",
				"margin: " + randLargxo + "px; width:" + largxo + "px; height: " + alto + "px");
	}
}
