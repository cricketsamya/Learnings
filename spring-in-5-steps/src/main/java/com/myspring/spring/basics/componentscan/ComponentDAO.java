package com.myspring.spring.basics.componentscan;

/**
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author S.Kulkarni
 *
 */
@Repository
public class ComponentDAO {

	@Autowired
	private ComponentJdbcConnection jdbcConnection;

	public ComponentJdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(ComponentJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

}
