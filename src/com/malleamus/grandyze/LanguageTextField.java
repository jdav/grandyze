package com.malleamus.grandyze;

import java.awt.ComponentOrientation;

import javax.swing.JTextField;

public class LanguageTextField extends JTextField {

	private Language language = null;

	public LanguageTextField(Language language, String value) {
		super(value);
		this.language = language;
		if (language.isRightLeft()) {
			this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
	}

	public Language getLanguage() {
		return language;
	}
}
