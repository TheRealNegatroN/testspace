package de.negatron.directory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class AlbumLister {

	public static void main(String[] args) {
		AlbumLister al = new AlbumLister();
		
		String path = "D:\\sound_flac";
		
		try {
			al.doRun(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doRun(String path) throws IOException {

		StringBuilder sb = new StringBuilder();
		
		// startverzeichnis setzen
		File startDir = new File(path);

		File[] interpreten = startDir.listFiles();
		assert interpreten != null;
		Arrays.sort(interpreten);


		for (File interpret : interpreten) {

			sb.append(interpret.getName());
			sb.append("\n");

			if (interpret.isDirectory()) {
				File[] alben = interpret.listFiles();
				assert alben != null;
				Arrays.sort(alben);

				for (File album : alben) {

					if (album.isDirectory()) {
						sb.append("--- ").append(album.getName());
						sb.append("\n");
					}

				}
			}
		}
		
		BufferedWriter buf = new BufferedWriter(new FileWriter(new File(startDir, "albumliste.txt")));		
		buf.write(sb.toString());
		buf.flush();
		buf.close();
	}

}
