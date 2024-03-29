package com.malleamus.grandyze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grandyze extends JFrame {

	private static final long serialVersionUID = -3027842541591324055L;
	private static final JPanel BLANK_PANEL = new JPanel();
	private static final JButton HACK_BUTTON = new JButton("Please Wait...");
	private static final JPanel WAIT_PANEL = new JPanel();

	static {
		BLANK_PANEL.setBackground(Color.white);
		WAIT_PANEL.setLayout(new GridLayout(3, 3));
		HACK_BUTTON.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(HACK_BUTTON);
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(new JButton());
		WAIT_PANEL.add(new JButton());
	}

	public static void main(String[] args) throws IOException {
		Grandyze grandyze = new Grandyze();
		if (args.length > 0) {
			File fcf = new File(args[0]);
			if (fcf.exists()) {
				VocabularyWord word = new VocabularyWord(fcf);
				grandyze.setCurrentPanel(new EditingPanel(word));
			}
		}
	}

	private void showWaitPanel() {
		WAIT_PANEL.setVisible(true);
		this.validate();
		this.repaint();
		HACK_BUTTON.doClick();
	}

	private void hideWaitPanel() {
		WAIT_PANEL.setVisible(false);
		this.validate();
		this.repaint();
		HACK_BUTTON.doClick();
	}

	private void setCurrentPanel(JPanel panel) {
		if (panel != null) {
			this.setContentPane(panel);
			this.validate();
			this.repaint();
			HACK_BUTTON.doClick();
		}
	}

	private final JFileChooser fc = new JFileChooser();

	public Grandyze() {
		super("Grandyze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1024, 700));
		this.setCurrentPanel(BLANK_PANEL);
		this.setGlassPane(WAIT_PANEL);
		final Grandyze outer = this;

		MenuItem openFile = new MenuItem("Open Files");
		openFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setMultiSelectionEnabled(true);

				if (fc.showOpenDialog(outer) == JFileChooser.APPROVE_OPTION) {
					outer.showWaitPanel();
					File[] selections = fc.getSelectedFiles();

					try {
						if (selections.length == 1) {
							VocabularyWord word = new VocabularyWord(
									selections[0]);
							outer.setCurrentPanel(new EditingPanel(word));
						} else {
							outer.setCurrentPanel(new BrowsingPanel(
									new EditingPanels(selections)));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					outer.hideWaitPanel();
				}
			}
		});

		MenuItem openDirectory = new MenuItem("Open Directory");
		openDirectory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.showOpenDialog(outer);
				File selection = fc.getSelectedFile();
				outer.showWaitPanel();
				outer.setCurrentPanel(new BrowsingPanel(new EditingPanels(
						selection)));
				outer.hideWaitPanel();
			}
		});

		MenuItem close = new MenuItem("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				outer.setCurrentPanel(BLANK_PANEL);
			}
		});
		
		MenuItem importIt = new MenuItem("Import");
		importIt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Choose the image to import...
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.showOpenDialog(outer);
				File imageFile = fc.getSelectedFile();

				// Choose the name of the FCF file you
				// want to create from this image...
				fc.showSaveDialog(outer);
				outer.showWaitPanel();
				File newVocabularyWordFile = fc.getSelectedFile();
				try {
					VocabularyWord newWord = new VocabularyWord(
							newVocabularyWordFile, imageFile);
					outer.setCurrentPanel(new EditingPanel(newWord));
				} catch (IOException e) {
					e.printStackTrace();
				}
				outer.hideWaitPanel();
			}
		});

		MenuItem exit = new MenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		
		MenuItem learnWords = new MenuItem("Learn Words");
		learnWords.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.showOpenDialog(outer);
				File selection = fc.getSelectedFile();
				outer.showWaitPanel();
				outer.setCurrentPanel(new BrowsingPanel(new LearningPanels(
						selection)));
				outer.hideWaitPanel();
			}
		});

		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu learnMenu = new Menu("Learn");

		fileMenu.add(openFile);
		fileMenu.add(openDirectory);
		fileMenu.add(importIt);
		fileMenu.add(close);
		fileMenu.add(exit);
		learnMenu.add(learnWords);

		MenuBar menuBar = new MenuBar();
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(learnMenu);

		this.setMenuBar(menuBar);
		this.pack();
		this.setVisible(true);
	}

}
