package com.kazurayam.ksbackyard

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

import org.w3c.dom.NodeList

public class XMLUtils {

	public static DocumentBuilderFactory newSecureDocumentBuilderFactory() throws ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		dbf.setFeature("http://apache.org/xml/features/dom/create-entity-ref-nodes", false);
		dbf.setExpandEntityReferences(false);
		dbf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
		return dbf;
	}

	public static String nodeListToString(NodeList nodes) throws TransformerException {
		DOMSource source = new DOMSource();
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		for (int i = 0; i < nodes.getLength(); ++i) {
			source.setNode(nodes.item(i));
			transformer.transform(source, result);
		}
		return writer.toString();
	}
}