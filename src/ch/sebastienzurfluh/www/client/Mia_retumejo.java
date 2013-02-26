package ch.sebastienzurfluh.www.client;

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

import ch.sebastienzurfluh.www.client.view.artmuro.RandAfisxo;
import ch.sebastienzurfluh.www.client.view.artmuro.SimplaArtMuro;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Mia_retumejo implements EntryPoint {

	public void onModuleLoad() {
		
		SimplaArtMuro artMuro = new SimplaArtMuro(
				Window.getClientWidth(), Window.getClientHeight());
		artMuro.setStyleName("artMuro");


		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_blue.gif"), 200, 200, 20));

		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_green.gif"), 200, 600, 20));
		
		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_violet.gif"), 150, 350, 20));
		
		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_yellow.gif"), 100, 150, 20));
		
		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_blue.gif"), 150, 200, 20));
		
		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_green.gif"), 250, 350, 20));
		
		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_violet.gif"), 250, 250, 20));
		
		artMuro.aldoni(
				new RandAfisxo(new Image("resources/pix/light_blue.gif"), 30, 10, 20));
		
		RootPanel.get().add(artMuro);
	}
}
