package org.dakhani.xsl.transform.dto.request;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public class TransformRequest {

	/** Filename of xmlFile */
	private String xmlFileName;

	/** Filename of xslFile */
	private String xslFileName;

	/**
	 * @return the xmlFileName
	 */
	public String getXmlFileName() {
		return this.xmlFileName;
	}

	/**
	 * @return the xslFileName
	 */
	public String getXslFileName() {
		return this.xslFileName;
	}

	/**
	 * @param xmlFileName
	 *            the xmlFileName to set
	 */
	public void setXmlFileName(final String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * @param xslFileName
	 *            the xslFileName to set
	 */
	public void setXslFileName(final String xslFileName) {
		this.xslFileName = xslFileName;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransformRequest [xslFileName=" + this.xslFileName
				+ ", xmlFileName=" + this.xmlFileName + "]";
	}

}
