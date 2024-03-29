package com.malleamus.grandyze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class VocabularyWordPanel extends JPanel {

	private static final long serialVersionUID = -5774388721782942084L;

	public VocabularyWordPanel(VocabularyWord flashcard) throws IOException {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		add(new JLabel(flashcard.getImage()), BorderLayout.WEST);
	}
}
