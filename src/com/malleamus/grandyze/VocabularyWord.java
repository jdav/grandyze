package com.malleamus.grandyze;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class VocabularyWord {
	
	private File file = null;
	private byte[] imageBytes = null;
	private ImageIcon image = null;
	private final Map<Language, String> map = new HashMap<Language, String>();
	private static final int MAX = 600;

	private static ImageIcon buildImage(byte[] imageBytes) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
		ImageInputStream iis = ImageIO.createImageInputStream(bis);
		Image img = ImageIO.read(iis);

		int width = img.getWidth(null);
		int height = img.getHeight(null);
		boolean taller = height > width;
		boolean wider = width > height;
		boolean square = height == width;
		int proportinateHeight = (((height * 100) / width) * MAX) / 100;
		int proportinateWidth = (((width * 100) / height) * MAX) / 100;

		if (wider) {
			width = MAX;
			height = proportinateHeight;
		} else if (taller) {
			height = MAX;
			width = proportinateWidth;
		} else if (square) {
			height = MAX;
			width = MAX;
		} else {
			// do nothing
		}

		Image resizedImage = img.getScaledInstance(width, height,
				Image.SCALE_FAST);

		return new ImageIcon(resizedImage);
	}

	public VocabularyWord(File newFile, File imagefile) throws IOException {
		this.file = newFile;
		this.file.createNewFile();
		this.imageBytes = Files.readAllBytes(imagefile.toPath());
		this.image = buildImage(imageBytes);
		this.store();
	}

	public VocabularyWord(String path) {
		this.file = new File(path);
	}

	public VocabularyWord(File inFile) throws IOException {
		if (inFile.getName().endsWith(".fcf")
				|| inFile.getName().endsWith(".FCF")) {
			file = inFile;
		} else {
			throw new IOException("Bad file type!");
		}

		byte[] bytes = Files.readAllBytes(file.toPath());
		imageBytes = Arrays.copyOfRange(bytes, 2048, bytes.length);
		image = buildImage(imageBytes);

		byte[] metadataBytes = Arrays.copyOfRange(bytes, 0, 2047);
		String metadata = new String(metadataBytes);
		metadata = metadata.substring(0, metadata.length() - 2);
		metadata = metadata.trim();
		// System.out.println("metadata is " + metadata);

		String[] lingos = metadata.split("~");
		for (String lingo : lingos) {
			// System.out.println("lingo = " + lingo);
			String[] components = lingo.split("=");
			// System.out.println("components[0] = " + components[0]);
			// System.out.println("components[1] = " + components[1]);
			Language l = Language.valueOf(components[0].toUpperCase());
			// System.out.println("Language = " + l);
			// System.out.println("Value = " + components[1]);
			map.put(l, components[1]);
		}
	}

	public void store() throws IOException {
		FileOutputStream fos = new FileOutputStream(this.file);
		fos.write(this.getMetadata().getBytes());
		fos.write(imageBytes);
		fos.close();
	}

	public String getMetadata() {
		String metadata = "";
		Set<Entry<Language, String>> languages = map.entrySet();
		for (Entry<Language, String> entry : languages) {
			if (!entry.getValue().isEmpty()) {
				if (!metadata.isEmpty()) {
					metadata += "~";
				}
				metadata += entry.getKey() + "=" + entry.getValue();
			}
		}

		metadata = String.format("%1$-" + 1023 + "s", metadata);
		return metadata;
	}

	public String getIPA(Language language) {
		return " ";
	}

	public String getWord(Language language) {
		return map.get(language);
	}

	public void setWord(Language language, String word) {
		map.put(language, word);
	}

	public ImageIcon getImage() throws IOException {
		return image;
	}
}
