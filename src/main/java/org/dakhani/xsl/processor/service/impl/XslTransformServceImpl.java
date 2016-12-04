package org.dakhani.xsl.processor.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.dakhani.xsl.processor.dto.request.TransformRequest;
import org.dakhani.xsl.processor.dto.response.TransformResponse;
import org.dakhani.xsl.processor.service.XslTransformService;
import org.dakhani.xsl.processor.util.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public class XslTransformServceImpl implements XslTransformService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(XslTransformServceImpl.class);

	/**
	 * @see org.dakhani.xsl.processor.service.XslTransformService#transformXml(org.dakhani.xsl.processor.dto.request.TransformRequest)
	 */
	@Override
	public TransformResponse transformXml(final TransformRequest request) {

		TransformResponse response = new TransformResponse();
		String transformedResult = null;

		try {

			String xmlContent = ResourceUtils
					.readResource(request.getXmlFileName());
			String xslContent = ResourceUtils
					.readResource(request.getXslFileName());

			try (InputStream xmlStream = IOUtils.toInputStream(xmlContent);
					InputStream xsltStream = IOUtils
							.toInputStream(xslContent)) {

				LOGGER.info("Xml and xsl file loaded");

				Source xmlSource = new StreamSource(xmlStream);
				Source xsltSource = new StreamSource(xsltStream);
				ByteArrayOutputStream fOStream = new ByteArrayOutputStream();

				TransformerFactory factory = TransformerFactory.newInstance();
				Transformer transformer = factory.newTransformer(xsltSource);
				transformer.transform(xmlSource, new StreamResult(fOStream));

				transformedResult = this.trim(fOStream.toString());
				LOGGER.info("Resulting transformation generated");
			}

		} catch (TransformerException | IOException e) {
			LOGGER.error("Error while transforming xml file", e);
		}

		response.setTransformResult(transformedResult);
		response.setFileSize(
				transformedResult != null ? transformedResult.length() : 0);

		return response;

	}

	/**
	 * Removes unwanted spaces in the resulting file
	 * 
	 * @param text
	 * @return
	 */
	private String trim(final String content) {

		StringBuffer result = new StringBuffer();

		try (Reader reader = new StringReader(content);
				BufferedReader bReader = new BufferedReader(reader)) {

			String line = null;
			while ((line = bReader.readLine()) != null)
				result.append(line.trim());

		} catch (Exception e) {
			LOGGER.error("Error while removing spaces", e);
		}

		return result.toString();
	}

}
