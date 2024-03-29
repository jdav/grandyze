package com.malleamus.grandyze;

import java.io.File;

public class EditingPanels extends CircularList<VocabularyWordPanel> {

	private static final long serialVersionUID = 7845531104882900472L;

	public EditingPanels(File[] files) {
		for (File file : files) {
			try {
				VocabularyWord flashcard = new VocabularyWord(file);
				VocabularyWordPanel panel = new EditingPanel(flashcard);
				add(panel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public EditingPanels(File directory) {
		this(directory.listFiles());
	}
}
