package com.brianmviana.myvirtuallibrary.ui;

import java.util.ArrayList;

import com.brianmviana.myvirtuallibrary.ui.books.BooksListAbandoned;
import com.brianmviana.myvirtuallibrary.ui.books.BooksListAll;
import com.brianmviana.myvirtuallibrary.ui.books.BooksListNotRead;
import com.brianmviana.myvirtuallibrary.ui.books.BooksListRead;
import com.brianmviana.myvirtuallibrary.ui.books.BooksListReading;
import com.brianmviana.myvirtuallibrary.util.Colors;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.TabbedContainer;
import totalcross.ui.font.Font;

public class BooksTabbedContainer extends TabbedContainer{

	private static final String [] tabs = {"All", "Read", "Reading", "Not Read", "Abandoned"};
	private final Container bottomBar;

	private ArrayList<ButtonContainerAction> btnContainerActionList = new ArrayList<>();

	private BooksListAll booksListAllContainer = new BooksListAll();
	private BooksListRead booksListReadContainer = new BooksListRead();
	private BooksListReading booksListReadingContainer = new BooksListReading();
	private BooksListNotRead booksListNotReadContainer = new BooksListNotRead();
	private BooksListAbandoned booksListAbandonedContainer = new BooksListAbandoned();

	public static final int ALL = 0;
	public static final int READ = 1;
	public static final int READING = 2;
	public static final int NOTREAD = 3;
	public static final int ABANDONED = 4;

	public BooksTabbedContainer() {
		super(tabs);
		started = false;
		setType(TABS_TOP);

		addBottomContainer2List(createButton(ALL), booksListAllContainer, ()-> {});
		addBottomContainer2List(createButton(READ), booksListReadContainer, ()-> {});
		addBottomContainer2List(createButton(READING), booksListReadingContainer, ()-> {});
		addBottomContainer2List(createButton(NOTREAD), booksListNotReadContainer, ()-> {});
		addBottomContainer2List(createButton(ABANDONED), booksListAbandonedContainer, ()-> {});

		this.bottomBar = new Container() {

			@Override
			public void initUI() {
				super.initUI();

				setBorderStyle(BORDER_NONE);
				setBackColor(Colors.PRIMARY);

				boolean firstTime = true;
				for (ButtonContainerAction btnContainerAction: btnContainerActionList) {
					int xPos, yPos, width, height;
					if (firstTime) {
						firstTime = false;
						xPos = LEFT;
						yPos = CENTER;
						width = PARENTSIZE + 33;
						height = PREFERRED;
					} else {
						xPos = AFTER;
						yPos = SAME;
						width = SAME;
						height = SAME;
					}
					add(btnContainerAction.btn, xPos, yPos, width, height);
				}
			}
		};
	}

	public Button createButton(int type) {
		Button b;
		if (type == ALL) {
			b = new Button("ALL");
		} else if (type == READ) {
			b = new Button("READ");
		} else if (type == READING) {
			b = new Button("READING");
		} else if (type == NOTREAD) {
			b = new Button("NOTREAD");
		} else if (type == ABANDONED) {
			b = new Button("ABANDONED");
		} else {
			return null;
		}
		b.setFont(Font.getFont(true, fmH * 8 / 10));
		b.setForeColor(Colors.P_LIGHT);		
		b.setBorder(Button.BORDER_NONE);
		return b;
	}

	public Container getBottomBar() {
		return bottomBar;
	}

	private void addBottomContainer2List(Button btn, Container container, Runnable action) {
		int idx = btnContainerActionList.size();

		btn.addPressListener((e) -> {
			setActiveTab(idx);
		});
		btnContainerActionList.add(new ButtonContainerAction(btn, container, action));
	}

	@Override
	public void initUI() {
		super.initUI();

		int idx = 0;
		for (ButtonContainerAction btnContainer: btnContainerActionList) {
			if (btnContainer.container != null) {
				setContainer(idx, btnContainer.container);
			}
			idx++;
		}
		setActiveTab(0);
	}

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

}
