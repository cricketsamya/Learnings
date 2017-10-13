/**
 * 
 */
package com.myspring.spring.basics.springin5steps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.spring.basics.springin5steps.xml.XMLJdbcConnection;

/**
 * @author S.Kulkarni
 *
 */
@Repository
public class PersonDAO {

	@Autowired
	private JdbcConnection jdbcConnection;

	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

}
