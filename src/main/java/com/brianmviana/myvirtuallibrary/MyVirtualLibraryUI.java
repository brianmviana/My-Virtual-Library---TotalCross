package com.brianmviana.myvirtuallibrary;


import com.brianmviana.myvirtuallibrary.ui.BooksListUI;

import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class MyVirtualLibraryUI extends MainWindow{
	
	public MyVirtualLibraryUI(){
		super("Books", NO_BORDER);

		setUIStyle(Settings.Android);
		Settings.uiAdjustmentsBasedOnFontHeight = true;
		setBackForeColors(Color.WHITE, Color.BLACK);
	}

	public void initUI(){

		SideMenuContainer.Item home = new SideMenuContainer.Item("My Books", MaterialIcons._BOOK, 0x4A90E2, ()-> {return new BooksListUI();});
		//		SideMenuContainer.Item sample = new SideMenuContainer.Item("Sample", MaterialIcons._THUMB_UP, 0x4A90E2, ()-> {return new Login();});
		//		
		//		SideMenuContainer.Sub submenu = new SideMenuContainer.Sub("SubMenu", sample);
		//		
		SideMenuContainer sideMenu = new SideMenuContainer(null, home);//, submenu);

		sideMenu.topMenu.header = new Container(){
			public void initUI(){
				setBackColor(0x4A90E2);

				Label title = new Label("My Library Vitual", CENTER, Color.WHITE, false);
				title.setFont(Font.getFont("Lato Bold", false, this.getFont().size+2));
				title.setForeColor(Color.WHITE);
				add(title, LEFT+45, BOTTOM-45, PARENTSIZE+90, DP+60);
			}
		};

		sideMenu.setBarFont(Font.getFont(Font.getDefaultFontSize()));
		sideMenu.setBackColor(0x4A90E2);
		sideMenu.setForeColor(Color.WHITE);
		sideMenu.setItemForeColor(Color.BLACK);
		sideMenu.topMenu.drawSeparators = true;
		sideMenu.topMenu.itemHeightFactor = 3;


		Icon icon = new Icon(MaterialIcons._MENU);
		icon.setBackColor(Color.WHITE);
		add(icon, CENTER, TOP);
		add(sideMenu, RIGHT, TOP, PARENTSIZE, PARENTSIZE);
	}
}
