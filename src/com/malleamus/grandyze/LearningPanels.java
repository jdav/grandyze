package com.malleamus.grandyze;

import java.io.File;
import java.util.Random;

public class LearningPanels extends CircularList<VocabularyWordPanel> {

	private static final long serialVersionUID = -2700786295492119749L;
	private static final int MAX_SAMPLE_SIZE = 10;
	private static final Random random = new Random();

	public LearningPanels(File directory) {
		File[] files = directory.listFiles();
		int sampleSize = (files.length < MAX_SAMPLE_SIZE ? files.length
				: MAX_SAMPLE_SIZE);
		for (File file : files) {
			int selectionLikelihood = files.length / sampleSize;
			if (random.nextInt(selectionLikelihood) == 0) {
				try {
					VocabularyWord word = new VocabularyWord(file);
					VocabularyWordPanel panel = new LearningPanel(word);
					add(panel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (size() >= sampleSize) {
				break;
			}
		}

		randomize();
	}
}
