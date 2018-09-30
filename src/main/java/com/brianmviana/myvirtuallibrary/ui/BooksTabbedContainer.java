package com.brianmviana.myvirtuallibrary.ui;

import java.util.ArrayList;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.TabbedContainer;
import totalcross.ui.gfx.Color;

public class BooksTabbedContainer extends TabbedContainer {
	
	private static final String [] names = {"1"};
	private final Container bar;
	
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
	
	BooksListAll booksListContainer = new BooksListAll();

	public Container getBar() {
		return bar;
	}
	
	public BooksTabbedContainer() {
		super(names);
		started = false;
		setType(TABS_NONE);
		
		addBottomContainer2List(new Button("all"), booksListContainer, booksListContainer::update);
		
		this.bar = new Container() {
			
			@Override
			public void initUI() {
				super.initUI();
				
				setBorderStyle(BORDER_SIMPLE);
				setBackColor(0x4A90E2);
				
				boolean firstTime = true;
				for (ButtonContainerAction btnContainerAction: btnContainerActionList) {
					int xPos, yPos, width, height;
					if (firstTime) {
						firstTime = false;
						xPos = LEFT;
						yPos = CENTER;
						width = PARENTSIZE + 25;
						height = PARENTSIZE;
					} else {
						xPos = AFTER;
						yPos = SAME;
						width = SAME;
						height = SAME;
					}
					btnContainerAction.btn.setBorder(BORDER_NONE);
					add(btnContainerAction.btn, xPos, yPos, width, height);
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
					btn.setForeColor(Color.WHITE);
				} else {
					btn.press(true);
					btn.setForeColor(Color.BLACK);
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
