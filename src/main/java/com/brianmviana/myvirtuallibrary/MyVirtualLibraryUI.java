package com.brianmviana.myvirtuallibrary;

import java.io.IOException;
import com.brianmviana.myvirtuallibrary.ui.BooksTabbedContainer;
import com.brianmviana.myvirtuallibrary.ui.Search;
import com.brianmviana.myvirtuallibrary.util.Colors;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class MyVirtualLibraryUI extends MainWindow{
	SideMenuContainer sideMenu;

	  public MyVirtualLibraryUI() {

	    super("My Books", NO_BORDER);

	    setUIStyle(Settings.Android);
	    Settings.uiAdjustmentsBasedOnFontHeight = true;

	    setBackForeColors(Colors.BACKGROUND, Colors.FOREGROUND);
	  }

	  @Override
	  public void initUI() {
//		SideMenuContainer.Item home = new SideMenuContainer.Item("Home", MaterialIcons._HOME, Color.BLACK, false, () -> { return new Home();});
//		SideMenuContainer.Item login= new SideMenuContainer.Item("Login", MaterialIcons._PERSON, Color.BLACK,  () -> { return new Login(); });
		SideMenuContainer.Item books = new SideMenuContainer.Item("My Books", MaterialIcons._LIBRARY_BOOKS, Color.BLACK,  ()-> {return new BooksTabbedContainer();});
		SideMenuContainer.Item search = new SideMenuContainer.Item("Search", MaterialIcons._SEARCH, Color.BLACK,  ()-> {return new Search();});
			
//	    SideMenuContainer.Sub group =
//	        new SideMenuContainer.Sub("Components", buttons, edits, checkRadio);
		
	    sideMenu =
	        new SideMenuContainer(
	            null,
	            books,
	            search);

	    sideMenu.topMenu.header =
	        new Container() {
	          @Override
	          public void initUI() {

	            try {
	              setBackColor(Colors.REDDESIGN);

	              Label title = new Label("My Books", LEFT, Color.WHITE, false);
	              title.setFont(Font.getFont("Lato Bold", false, this.getFont().size + 5));
	              title.setForeColor(Color.WHITE);
	              add(title, LEFT + 45, BOTTOM - 30, FILL, DP + 56);

	              ImageControl profile = new ImageControl(new Image("images/books.png"));
	              profile.scaleToFit = true;
	              profile.transparentBackground = true;
	              add(profile, LEFT + 45, TOP + 150, PREFERRED, FIT);

	            } catch (IOException | ImageException e) {
	              e.printStackTrace();
	            }
	          }
	        };

	    sideMenu.setBarFont(Font.getFont(Font.getDefaultFontSize() + 5));
	    sideMenu.setBackColor(Colors.PRIMARY);
	    sideMenu.setForeColor(Color.WHITE);
	    sideMenu.setItemForeColor(Color.BLACK);
	    sideMenu.topMenu.drawSeparators = false;
	    sideMenu.topMenu.itemHeightFactor = 3;

	    add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
	  }

}
