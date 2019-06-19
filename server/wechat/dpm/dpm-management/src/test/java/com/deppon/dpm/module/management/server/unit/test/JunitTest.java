package com.deppon.dpm.module.management.server.unit.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations={
	
		"classpath*:com/deppon/**/META-INF/ibatis/*.xml"
		
		})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class JunitTest {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
}
