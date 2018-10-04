package com.brianmviana.myvirtuallibrary.ui.books;

import java.util.ArrayList;
import java.util.List;
import com.brianmviana.myvirtuallibrary.utils.Colors;
import com.brianmviana.myvirtuallibrary.utils.Images;

import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ListContainer;
import totalcross.ui.ScrollContainer;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class BooksListAll extends Container {

	private ScrollContainer sc;
	private ListContainer lcSocialNetworks = new ListContainer();

	@Override
	public void initUI() {

		try {
			super.initUI();
			
			sc = new ScrollContainer(false, true);
			add(sc,LEFT,TOP,FILL,FILL);

			lcSocialNetworks.getFlick().longestFlick = 15;
			lcSocialNetworks.setBackColor(Colors.BACKGROUND);
			sc.add(lcSocialNetworks, LEFT, TOP, FILL, FILL);
			
//			List<ListContainer.Item> books = new ArrayList<ListContainer.Item>();
			
			
			ListContainer.Item facebook = new ListContainer.Item(getLayout(new Image("images/books.png").hwScaledFixedAspectRatio((int) (48* Settings.screenDensity), true)));
			facebook.items = new String[] { "  ", " Title", "   Facebook", "", "" };

			ListContainer.Item facebook1 = new ListContainer.Item(getLayout(new Image("images/books.png").hwScaledFixedAspectRatio((int) (48* Settings.screenDensity), true)));
			facebook1.items = new String[] { "  ", " Title", "   Facebook", "", "" };

			ListContainer.Item facebook2 = new ListContainer.Item(getLayout(new Image("images/books.png").hwScaledFixedAspectRatio((int) (48* Settings.screenDensity), true)));
			facebook2.items = new String[] { "  ", " Title", "   Facebook", "", "" };

			ListContainer.Item facebook3 = new ListContainer.Item(getLayout(new Image("images/books.png").hwScaledFixedAspectRatio((int) (48* Settings.screenDensity), true)));
			facebook3.items = new String[] { "  ", " Title", "   Facebook", "", "" };

			ListContainer.Item facebook4 = new ListContainer.Item(getLayout(new Image("images/books.png").hwScaledFixedAspectRatio((int) (48* Settings.screenDensity), true)));
			facebook4.items = new String[] { "  ", " Title", "   Facebook", "", "" };
		
			Container socialNetworks[] = new Container[5];
			socialNetworks[0] = facebook;
			socialNetworks[1] = facebook1;
			socialNetworks[2] = facebook2;
			socialNetworks[3] = facebook3;
			socialNetworks[4] = facebook4;
			
			
			lcSocialNetworks.addContainers(socialNetworks);
			lcSocialNetworks.highlightColor = lcSocialNetworks.getBackColor();
			lcSocialNetworks.autoScroll = true;
			lcSocialNetworks.requestFocus();

		} catch (Exception ee) {
			MessageBox.showException(ee, true);
		}
	}

	private ListContainer.Layout getLayout(Image leftImage) {

		ListContainer.Layout layout = lcSocialNetworks.getLayout(5, 2);

		try {

			layout.insets.set(100, 50, 50, 100);
			layout.leftImageEnlargeIfSmaller = false;
			layout.defaultLeftImage = leftImage;
			layout.defaultRightImage = Images.aplyColor(new Image("images/books.png"), Colors.GRAY)
					.hwScaledFixedAspectRatio((int) (24 * Settings.screenDensity), true);
			layout.defaultRightImage2 = Images.aplyColor(new Image("images/books.png"), Colors.BLUE)
					.hwScaledFixedAspectRatio((int) (24 * Settings.screenDensity), true);
			layout.controlGap = 30;
			layout.lineGap = 1;
			layout.boldItems[2] = false;
			layout.fontNames[2] = "Lato Bold";
			layout.defaultItemColors[2] = Color.BLACK;
			layout.relativeFontSizes[1] = -5;
			layout.relativeFontSizes[2] = +2;
			layout.relativeFontSizes[3] = -15;
			layout.positions[3] = RIGHT;
			layout.setup();

		} catch (Exception ee) {
			MessageBox.showException(ee, true);
		}

		return layout;
	}
}
