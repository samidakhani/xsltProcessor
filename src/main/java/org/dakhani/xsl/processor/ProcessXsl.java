package org.dakhani.xsl.processor;

import org.dakhani.xsl.processor.util.ResourceUtils;
import org.dakhani.xsl.transform.dto.request.TransformRequest;
import org.dakhani.xsl.transform.dto.response.TransformResponse;
import org.dakhani.xsl.transform.service.XslTransformService;
import org.dakhani.xsl.transform.service.impl.XslTransformServceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public class ProcessXsl {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProcessXsl.class);

	public static void main(final String[] args) {

		if (args.length != 4 || args.length != 6) {
			LOGGER.error(
					"Please specify xml, xsl and result(optional) filepath arguments");
			return;
		}

		if (!"-xml".equals(args[0]) && !"-xsl".equals(args[2])) {
			LOGGER.error("Please specify:");
			LOGGER.error("-xml followed by absolute path to xml file and");
			LOGGER.error("-xsl followed by absolute path to xsl file");
			return;
		}

		String xmlFileName = args[1];
		String xslFileName = args[3];

		TransformRequest request = new TransformRequest();
		request.setXmlFileName(xmlFileName);
		request.setXslFileName(xslFileName);

		XslTransformService transform = new XslTransformServceImpl();
		TransformResponse response = transform.transformXml(request);
		String transformResult = response.getTransformResult();

		if (!"-r".equals(args[4])) {
			LOGGER.info("Transformation:");
			LOGGER.info(transformResult);
		} else {

			if (args.length != 6) {
				LOGGER.error(
						"Please specify -r followed by absolute path to result file");
			} else {
				String transformFileName = args[5];
				ResourceUtils.writeResource(transformResult, transformFileName);
			}
		}

	}

}
