package org.dakhani.xsl.processor.dto.response;

import javax.validation.constraints.NotNull;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public class TransformResponse {

	private long fileSize;

	@NotNull
	private String transformResult;

	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return this.fileSize;
	}

	/**
	 * @return the transformResult
	 */
	public String getTransformResult() {
		return this.transformResult;
	}

	/**
	 * @param fileSize
	 *            the fileSize to set
	 */
	public void setFileSize(final long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @param transformResult
	 *            the transformResult to set
	 */
	public void setTransformResult(final String transformResult) {
		this.transformResult = transformResult;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransformResponse [fileSize=" + this.fileSize
				+ ", transformResult=" + this.transformResult + "]";
	}

}
