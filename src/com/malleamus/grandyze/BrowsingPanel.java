package com.malleamus.grandyze;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BrowsingPanel extends JPanel {

	private static final long serialVersionUID = -4152109466369809118L;
	private VocabularyWordPanel current = null;
	private Iterator<VocabularyWordPanel> iterator = null;

	public BrowsingPanel(CircularList<VocabularyWordPanel> list) {
		iterator = list.iterator();
		this.setLayout(new BorderLayout());
		final BrowsingPanel outer = this;

		final JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				outer.setVisible(false);
				if (current != null) {
					outer.remove(current);
				}
				current = iterator.next(); // hasNext() is unnecessary
				outer.add(current, BorderLayout.CENTER);
				outer.setVisible(true);
			}
		});

		this.add(nextButton, BorderLayout.SOUTH);
		nextButton.doClick();
	}
}
