package com.malleamus.grandyze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LearningPanel extends VocabularyWordPanel {

	private static final long serialVersionUID = -2481825519643509261L;

	public LearningPanel(VocabularyWord flashcard) throws IOException {
		super(flashcard);
		
		String word = flashcard.getWord(Language.FR);
		JLabel wordLabel = new JLabel(word);
		wordLabel.setHorizontalAlignment(JLabel.CENTER);
		wordLabel.setVerticalAlignment(JLabel.BOTTOM);
		float pointSize = 200f - (20f * word.length());
		wordLabel.setFont(getFont().deriveFont(pointSize));
		wordLabel.setBackground(Color.white);

		JLabel ipaLabel = new JLabel(flashcard.getIPA(Language.KO));
		ipaLabel.setHorizontalAlignment(JLabel.CENTER);
		ipaLabel.setVerticalAlignment(JLabel.TOP);
		ipaLabel.setFont(getFont().deriveFont(50f));
		ipaLabel.setBackground(Color.white);

		JPanel inner = new JPanel(new GridLayout(2, 1));
		inner.setBackground(Color.white);
		inner.add(wordLabel);
		inner.add(ipaLabel);
		add(inner, BorderLayout.CENTER);
	}
}