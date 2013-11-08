package com.myit.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtils {

	private static Logger logger = Logger.getLogger(XmlUtils.class);

	public static NodeList runXpath(Node doc, String xquery, NamespaceContext ns) {
		NodeList list = null;
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			if (null != ns) {
				xpath.setNamespaceContext(ns);
			}
			XPathExpression expression = xpath.compile(xquery);

			Object result = expression.evaluate(doc, XPathConstants.NODESET);
			list = (NodeList) result;
		} catch (Exception e) {
			logger.warn("XMLUtils:  unable to evaluate xpath", e);
		}
		return list;
	}

	public static String getValueByXpath(Node doc, String xquery) {
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression expression = xpath.compile(xquery);
			String result = (String) expression.evaluate(doc,
					XPathConstants.STRING);
			return result;
		} catch (Exception e) {

		}
		return null;
	}

	public static String nodeAsString(Node node) {
		String nodeStr = "";
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty("encoding", "UTF-8");

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			tf.transform(new DOMSource(node), new StreamResult(bos));
			return bos.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nodeStr;
	}

	public static Document getW3CDom(String xmlStr)
			throws ParserConfigurationException, SAXException, IOException {
		StringReader sr = new StringReader(xmlStr);
		InputSource is = new InputSource(sr);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(is);
		return doc;
	}

	public static void main(String[] args) {

	}
}
