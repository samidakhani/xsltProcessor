package org.dakhani.xsl.transform;

import javax.validation.constraints.NotNull;

import org.dakhani.xsl.transform.dto.request.TransformRequest;
import org.dakhani.xsl.transform.dto.response.TransformResponse;

/**
 * @author Sami Dakhani Created on Dec 4, 2016
 *
 */
public interface XslTransform {

	/**
	 * Transform a xml using xsl-style_sheet
	 * 
	 * @param request
	 * @return
	 */
	@NotNull
	TransformResponse transformXml(@NotNull TransformRequest request);
}
