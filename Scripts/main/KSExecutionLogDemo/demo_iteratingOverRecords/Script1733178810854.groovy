import java.nio.file.Path
import java.nio.file.Paths

import org.w3c.dom.NodeList

import com.kazurayam.ksbackyard.KSExecution0LogProcessor
import com.kazurayam.ksbackyard.ReportsUtils
import com.kazurayam.ksbackyard.XMLUtils
import com.kms.katalon.core.configuration.RunConfiguration

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path reportDir = projectDir.resolve("Reports/20241201_170816/TS1/20241201_170816")
Path executionLog = reportDir.resolve("execution0.log")
KSExecution0LogProcessor scraper = new KSExecution0LogProcessor(executionLog)

List<String> screenshots = ReportsUtils.lookupScreenshotPngFiles(reportDir)
for (String pngFileName : screenshots) {
	NodeList recordElement = scraper.findRecordsWithAttachment(pngFileName)
	String s = XMLUtils.nodeListToString(recordElement)
	println s
	println "-------------------------------------------------------------"
}