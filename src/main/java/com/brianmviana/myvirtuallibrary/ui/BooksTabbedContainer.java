package com.brianmviana.myvirtuallibrary.ui;

import java.util.ArrayList;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ScrollContainer;
import totalcross.ui.TabbedContainer;
import totalcross.ui.gfx.Color;

public class BooksTabbedContainer extends TabbedContainer {

	private static final String [] names = {"1","2","3","4","5",};
	private final ScrollContainer bar;

	private static class ButtonContainerAction {
		final Button btn;
		final Container container;
		final Runnable action;
		ButtonContainerAction(Button btn, Container container, Runnable action) {
			this.btn = btn;
			this.container = container;
			this.action = action;
		}
	}

	ArrayList<ButtonContainerAction> btnContainerActionList = new ArrayList<>();

	BooksListAll booksListAllContainer = new BooksListAll();
	BooksListRead booksListReadContainer = new BooksListRead();
	BooksListReading booksListReadingContainer = new BooksListReading();
	BooksListNotRead booksListNotReadContainer = new BooksListNotRead();
	BooksListAbandoned booksListAbandonedContainer = new BooksListAbandoned();

	public Container getBar() {
		return bar;
	}

	public BooksTabbedContainer() {
		super(names);
		started = false;
		setType(TABS_NONE);

		addBottomContainer2List(new Button("ALL"), booksListAllContainer, booksListAllContainer::update);
		addBottomContainer2List(new Button("READ"), booksListReadContainer, booksListReadContainer::update);
		addBottomContainer2List(new Button("READING"), booksListReadingContainer, booksListReadingContainer::update);
		addBottomContainer2List(new Button("NOT READ"), booksListNotReadContainer, booksListNotReadContainer::update);
		addBottomContainer2List(new Button("ABANDONED"), booksListAbandonedContainer, booksListAbandonedContainer::update);
	
		this.bar = new ScrollContainer() {

			@Override
			public void initUI() {
				super.initUI();

				setBorderStyle(BORDER_SIMPLE);
				setForeColor(0xdcdcdc);

				boolean firstTime = true;
				for (ButtonContainerAction btnContainerAction: btnContainerActionList) {
					int xPos, yPos,  height;
					if (firstTime) {
						firstTime = false;
						xPos = LEFT;
						yPos = CENTER;
						height = PARENTSIZE;
					} else {
						xPos = AFTER;
						yPos = SAME;
						height = SAME;
					}
					btnContainerAction.btn.setBorder(BORDER_NONE);
					add(btnContainerAction.btn, xPos, yPos, PREFERRED + 100, height);
				}
			}
		};
	}

	private void addBottomContainer2List(Button btn, Container container, Runnable action) {
		int idx = btnContainerActionList.size();

		btn.addPressListener((e) -> {
			setActiveTab(idx);
		});
		btnContainerActionList.add(new ButtonContainerAction(btn, container, action));
	}

	@Override
	public void setActiveTab(int tab, boolean animate) {
		int lastActiveTab = getActiveTab();

		if (tab != lastActiveTab) {
			super.setActiveTab(tab, animate);

			int idx = 0;
			for (ButtonContainerAction btnContainer: btnContainerActionList) {
				Button btn = btnContainer.btn;
				if (idx != tab) {
					btn.press(false);
					btn.setForeColor(Color.BLACK);
				} else {
					btn.press(true);
					btn.setForeColor(0x4A90E2);
					btnContainer.action.run();
				}
				idx++;
			}
		}
	}

	@Override
	public void initUI() {
		super.initUI();
		setBackColor(Color.WHITE);
		
		int idx = 0;
		for (ButtonContainerAction btnContainer: btnContainerActionList) {
			if (btnContainer.container != null) {
				setContainer(idx, btnContainer.container);
			}
			idx++;
		}
		setActiveTab(0);
	}

}
