package com.kazurayam.ksbackyard

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.configuration.RunConfiguration
import junittutorial.Calculator
import org.w3c.dom.NodeList

@RunWith(JUnit4.class)
class ExecutionLogScraperTest {
	
	private static Path executionLog
	
	@BeforeClass
	static void beforeClass() {
		Path projectDir = Paths.get(RunConfiguration.getProjectDir())
		println "projectDir=${projectDir}"
		executionLog = projectDir.resolve("Reports/20241201_170816/TS1/20241201_170816/execution0.log")
	}
	

	@Test
	void testSmoke() {
		String pngFileName = "1733040516240.png"
		ExecutionLogScraper scraper = new ExecutionLogScraper(executionLog)
		NodeList recordElement = scraper.findRecordWithAttachement(pngFileName)
		String s = XMLUtil.nodeListToString(recordElement)
		println s
	}
}
