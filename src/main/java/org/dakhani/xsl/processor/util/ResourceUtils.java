package org.dakhani.xsl.processor.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public class ResourceUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ResourceUtils.class);

	public static String readResource(final String filename) {

		String content = null;

		try (InputStream is = new FileInputStream(filename)) {

			content = IOUtils.toString(is);

		} catch (FileNotFoundException e) {
			LOGGER.error("File not found" + filename, e);
		} catch (IOException ioe) {
			LOGGER.error("Error while reading file " + filename, ioe);
		}

		return content;

	}

	public static void writeResource(final String content,
			final String filename) {

		try (Writer writer = new FileWriter(filename);
				BufferedWriter bWriter = new BufferedWriter(writer)) {

			bWriter.write(content);

		} catch (IOException ex) {
			LOGGER.error("Error while writing to output file " + filename, ex);
		}

	}
}
