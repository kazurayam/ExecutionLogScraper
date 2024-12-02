package com.kazurayam.ksbackyard

import static org.junit.Assert.*

import java.nio.file.Path
import java.nio.file.Paths

import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import com.kms.katalon.core.configuration.RunConfiguration

@RunWith(JUnit4.class)
public class ReportsUtilsTest {

	private static Path reportDir
	
	@BeforeClass
	public static void beforeClass() {
		Path projectDir = Paths.get(RunConfiguration.getProjectDir())
		reportDir = projectDir.resolve("Reports/20241201_170816/TS1/20241201_170816")
	}

	@Test
	public void test_lookupScreenshotPngFiles() {
		List<String> screenshots = ReportsUtils.lookupScreenshotPngFiles(reportDir)
		println screenshots
		assertEquals(4, screenshots.size())
	}
}
