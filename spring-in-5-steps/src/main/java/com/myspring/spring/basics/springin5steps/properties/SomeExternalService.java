/**
 * 
 */
package com.myspring.spring.basics.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author S.Kulkarni
 *
 */
@Component
public class SomeExternalService {

	@Value("${external.service.url}")
	private String url;

	public String retrunServiceUrl() {
		return url;
	}

}
