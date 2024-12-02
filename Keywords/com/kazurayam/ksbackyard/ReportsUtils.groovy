package com.kazurayam.ksbackyard

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Stream
import java.util.stream.Collectors

public class ReportsUtils {

	public static List<String> lookupScreenshotPngFiles(Path reportDir) {
		Stream<Path> stream
		try {
			stream = Files.list(reportDir)
			return stream
					.filter { f -> Files.isRegularFile(f) }
					.filter { f -> f.getFileName().toString().startsWith("173") }
					.filter { f -> f.getFileName().toString().endsWith(".png") }
					.map { f -> f.getFileName().toString() }
					.collect(Collectors.toList())
		} catch (IOException e) {
			if (stream != null) {
				stream.close()
			}
		}
	}
}
