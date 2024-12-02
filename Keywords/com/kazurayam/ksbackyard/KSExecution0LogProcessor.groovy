package com.kazurayam.ksbackyard

import java.nio.file.Files
import java.nio.file.Path

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathExpression
import javax.xml.xpath.XPathExpressionException
import javax.xml.xpath.XPathFactory

import org.w3c.dom.Document
import org.w3c.dom.NodeList


public class KSExecution0LogProcessor {

	private Document xmlDocument

	public KSExecution0LogProcessor(File executionlog) {
		this(executionlog.toPath())
	}

	public KSExecution0LogProcessor(Path executionlog) throws IOException {
		InputStream is = Files.newInputStream(executionlog)
		DocumentBuilderFactory dbFactory = XMLUtils.newSecureDocumentBuilderFactory()
		DocumentBuilder builder = dbFactory.newDocumentBuilder()
		this.xmlDocument = builder.parse(is)
	}

	public NodeList findRecordsWithAttachment(String attachement) {
		return applyXPath("/log/record[property[@name='attachment' and contains(text(),'${attachement}')]]")
	}

	public NodeList applyXPath(String expression) {
		XPath xPath = XPathFactory.newInstance().newXPath()
		XPathExpression expr
		try {
			expr = xPath.compile(expression)
		} catch (XPathExpressionException e) {
			throw new IllegalArgumentException("invalid XPath: ${expression}", e)
		}
		return expr.evaluate(xmlDocument, XPathConstants.NODESET)
	}
}
