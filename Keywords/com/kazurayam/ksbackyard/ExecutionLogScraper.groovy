package com.kazurayam.ksbackyard

import java.nio.file.Files
import java.nio.file.Path

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList

import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;


public class ExecutionLogScraper {

	private Document xmlDocument;

	public ExecutionLogScraper(File executionlog) {
		this(executionlog.toPath())
	}

	public ExecutionLogScraper(Path executionlog) throws IOException {
		InputStream is = Files.newInputStream(executionlog)
		DocumentBuilderFactory dbFactory = XMLUtils.newSecureDocumentBuilderFactory()
		DocumentBuilder builder = dbFactory.newDocumentBuilder()
		this.xmlDocument = builder.parse(is)
	}

	public NodeList findRecordWithAttachement(String attachement) {
		return applyXPath("/log/record[property[contains(@name='attachement']/text(),'${attachement})']")
	}

	public NodeList applyXPath(String expression) {
		XPath xPath = XPathFactory.newInstance().newXPath()
		NodeList nodeList =
				(NodeList)xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET)
		return nodeList
	}
}
