package celo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class NotepadFiles {

	public static void main(String args[]) throws IOException {
		File folder = new File("/Users/vivb/eclipse/workspace/practice/src/celo/test1");

		TreeSet<File> files = new TreeSet<File>(new Comparator<File>() {
			public int compare(File file1, File file2) {
				try {
					BasicFileAttributes file1Attr = Files.readAttributes(
							file1.toPath(), BasicFileAttributes.class);
					BasicFileAttributes file2Attr = Files.readAttributes(
							file2.toPath(), BasicFileAttributes.class);
					return (int) (file1Attr.creationTime().toMillis()
							- file2Attr.creationTime().toMillis());
				} catch (IOException e) {
					e.printStackTrace();
				}
				return 0;
			}
		});

		listFilesForFolder(folder, files);

		String text = "";
		for (File file : files) {
			// BufferedReader br = new BufferedReader(new FileReader(file));
			// String line;
			// while ((line = br.readLine()) != null) {
			// text += line;
			// }
			Scanner scanner = new Scanner(file);
			boolean newLine = false;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (newLine) {
					text += "\n";
				} else {
					newLine = true;
				}
				text += line;
			}
			scanner.close();
		}

		System.out.println(text);
	}

	public static void listFilesForFolder(File folder, TreeSet<File> files) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry, files);
			} else {
				files.add(fileEntry);
			}
		}
	}
}
