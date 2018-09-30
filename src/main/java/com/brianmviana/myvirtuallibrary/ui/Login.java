package com.brianmviana.myvirtuallibrary.ui;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.font.Font;

public class Login extends Container {
	
	public Login(){
		
	}
	
	public void initUI(){
		Label lbl = new Label("My Books");
		lbl.setFont(Font.getFont("Lato Bold", false, lbl.getFont().size+4));
		add(lbl, CENTER, CENTER);
}
}
