package com.brianmviana.myvirtuallibrary.ui.books;

import java.util.ArrayList;
import java.util.List;

import com.brianmviana.myvirtuallibrary.db.SQLiteManager;
import com.brianmviana.myvirtuallibrary.model.Book;
import com.brianmviana.myvirtuallibrary.utils.Colors;
import com.brianmviana.myvirtuallibrary.utils.Images;

import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ListContainer;
import totalcross.ui.ScrollContainer;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class BooksListRead extends Container {
//
//	private ScrollContainer sc;
//	private ListContainer lcSocialNetworks = new ListContainer();
//	List<ListContainer.Item> booksConteinerItens = new ArrayList<ListContainer.Item>();
//
//	@Override
//	public void initUI() {
//
//		try {
//			super.initUI();
//
//			sc = new ScrollContainer(false, true);
//			add(sc,LEFT,TOP,FILL,FILL);
//
//			lcSocialNetworks.getFlick().longestFlick = 15;
//			lcSocialNetworks.setBackColor(Colors.BACKGROUND);
//			sc.add(lcSocialNetworks, LEFT, TOP, FILL, FILL);
//
//			ArrayList<Book> books = SQLiteManager.getInstance().getBooks();
//
//			if (books.size() > 0) {
//
//				//				String items[][] = new String[books.size()][3];
//
//				for (int i = 0; i < books.size(); i++) {
//
//					Book book = books.get(i);
//					//items[i] =  new String[] {book.getTitulo(), book.getIsbn(), book.getEditora()};
//
//					ListContainer.Item item = new ListContainer.Item(getLayout(new Image("images/books.png").hwScaledFixedAspectRatio((int) (48* Settings.screenDensity), true)));
//					item.items = new String[] { "  ", " Title", "   " + book.getTitulo(), book.getIsbn(),  book.getEditora()};
//					booksConteinerItens.add(item);
//				}
//			}
//			int conteiner = booksConteinerItens.size() - 1;
//			Container socialNetworks[] = new Container[conteiner];
//
//			for (int i = 0; i < booksConteinerItens.size(); i++) {
//				socialNetworks[i] = booksConteinerItens.get(i);
//			}
//
//			//			} else {
//			//
//			//				MessageBox mb = new MessageBox("Message" , "No registered books.", new String[]{"Close"});
//			//				mb.setBackColor(Colors.BACKGROUND);
//			//				mb.setForeColor(Colors.FOREGROUND);
//			//				mb.popup();
//			//			}
//
//			lcSocialNetworks.addContainers(socialNetworks);
//			lcSocialNetworks.highlightColor = lcSocialNetworks.getBackColor();
//			lcSocialNetworks.autoScroll = true;
//			lcSocialNetworks.requestFocus();
//
//		} catch (Exception ee) {
//			MessageBox.showException(ee, true);
//		}
//	}
//
//
//
//	private ListContainer.Layout getLayout(Image leftImage) {
//
//		ListContainer.Layout layout = lcSocialNetworks.getLayout(5, 2);
//
//		try {
//
//			layout.insets.set(100, 50, 50, 100);
//			layout.leftImageEnlargeIfSmaller = false;
//			layout.defaultLeftImage = leftImage;
//			layout.defaultRightImage = Images.aplyColor(new Image("images/books.png"), Colors.GRAY)
//					.hwScaledFixedAspectRatio((int) (24 * Settings.screenDensity), true);
//			layout.defaultRightImage2 = Images.aplyColor(new Image("images/books.png"), Colors.BLUE)
//					.hwScaledFixedAspectRatio((int) (24 * Settings.screenDensity), true);
//			layout.controlGap = 30;
//			layout.lineGap = 1;
//			layout.boldItems[2] = false;
//			layout.fontNames[2] = "Lato Bold";
//			layout.defaultItemColors[2] = Color.BLACK;
//			layout.relativeFontSizes[1] = -5;
//			layout.relativeFontSizes[2] = +2;
//			layout.relativeFontSizes[3] = -15;
//			layout.positions[3] = RIGHT;
//			layout.setup();
//
//		} catch (Exception ee) {
//			MessageBox.showException(ee, true);
//		}
//		return layout;
//	}



}
