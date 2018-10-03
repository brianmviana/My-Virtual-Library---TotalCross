package com.brianmviana.myvirtuallibrary.ui.cards;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.image.Image;

public class CardBook extends Container {

	Image capa;
	Label titulo;


	public void initUI() {
		setBackColor(0xFFFFFF);
		setBorderStyle(BORDER_SIMPLE);
		borderColor = 0xFFFFFF;

		titulo = new Label();


//		capa = new Image("images/books.png").hwScaledFixedAspectRatio((int) (Settings.screenDensity * 24), true);


	}
}
