package com.brianmviana.myvirtuallibrary.ui;

import totalcross.ui.Container;

public class BooksListUI extends Container {

	BooksTabbedContainer container;

	public void initUI() {
		container = new BooksTabbedContainer();
		add(container.getBar(), LEFT, TOP, FILL, fmH * 5 / 2);
		add(container, LEFT, TOP, FILL, FIT);
	}

}
