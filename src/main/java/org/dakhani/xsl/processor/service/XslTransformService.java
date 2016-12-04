package org.dakhani.xsl.processor.service;

import javax.validation.constraints.NotNull;

import org.dakhani.xsl.processor.dto.request.TransformRequest;
import org.dakhani.xsl.processor.dto.response.TransformResponse;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public interface XslTransformService {

	/**
	 * Transform a xml using xsl-style_sheet
	 * 
	 * @param request
	 * @return
	 */
	@NotNull
	TransformResponse transformXml(@NotNull TransformRequest request);
}
