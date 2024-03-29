package com.malleamus.grandyze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EditingPanel extends VocabularyWordPanel {

	private static final long serialVersionUID = -3117322033542416951L;
	private final List<LanguageTextField> textFields = new ArrayList<LanguageTextField>();

	public EditingPanel(final VocabularyWord flashcard) throws IOException {
		super(flashcard);

		JScrollPane scroller = new JScrollPane();
		add(scroller, BorderLayout.CENTER);

		JPanel labelAndTextPanel = new JPanel(new BorderLayout());
		labelAndTextPanel.setBackground(Color.white);
		scroller.getViewport().add(labelAndTextPanel);

		JPanel labelPanel = new JPanel(new GridLayout(Language.values().length,
				1));
		labelPanel.setBackground(Color.white);
		labelAndTextPanel.add(labelPanel, BorderLayout.WEST);

		JPanel textFieldPanel = new JPanel(new GridLayout(
				Language.values().length, 1));
		textFieldPanel.setBackground(Color.white);
		labelAndTextPanel.add(textFieldPanel, BorderLayout.CENTER);

		for (Language language : Language.values()) {
			if (language.isFavorite()) {
				String word = flashcard.getWord(language);
				LanguageTextField wordLabel = new LanguageTextField(language,
						word);
				textFields.add(wordLabel);
				wordLabel.setFont(scroller.getFont().deriveFont(32f));
				textFieldPanel.add(wordLabel);

				String languageName = language.getEnglishName();
				JLabel langNameLabel = new JLabel(languageName);
				langNameLabel.setHorizontalAlignment(JLabel.RIGHT);
				langNameLabel.setFont(scroller.getFont().deriveFont(32f));
				labelPanel.add(langNameLabel);
			}
		}

		final JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					for (LanguageTextField textField : textFields) {
						flashcard.setWord(textField.getLanguage(),
								textField.getText());
					}
					flashcard.store();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		add(saveButton, BorderLayout.SOUTH);
	}
}