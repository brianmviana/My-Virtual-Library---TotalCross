package com.brianmviana.myvirtuallibrary.ui;

import com.brianmviana.myvirtuallibrary.ui.cards.CardSearch;

import totalcross.sys.Settings;
import totalcross.ui.ScrollContainer;
import totalcross.ui.gfx.Color;

public class Search extends ScrollContainer {

	public Search() {
		super(false, true);
	}

	public void initUI() {
	    setBackColor(Color.WHITE);
	    final int DP_10 = (int) (Settings.screenDensity * 10);
	    setInsets(0, 0, DP_10, DP_10);
	    add(new CardSearch(), LEFT, TOP, FILL, DP + 50);
	  }
}
