package net.javaman.filemethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import net.javaman.homesethome.Main;

public class FileMethods {
	public static void create(String path, String name, String text)
			throws FileNotFoundException, UnsupportedEncodingException {
		File dir = new File(path);
		dir.mkdirs();
		PrintWriter writer = new PrintWriter(path + name + ".txt", "UTF-8");
		writer.println(text);
		writer.flush();
		writer.close();
	}

	public static String read(String name) {
		String text = null;
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(name + ".txt"));
			text = reader.readLine();
		} catch (Exception e) {
			Main.getLogger().info("Could not read file.");
		}
		return text;
	}

	public static boolean check(String name) {
		File file = new File(name + ".txt");
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public static void remove(String name) {
		File file = new File(name);
		file.delete();
	}
}
