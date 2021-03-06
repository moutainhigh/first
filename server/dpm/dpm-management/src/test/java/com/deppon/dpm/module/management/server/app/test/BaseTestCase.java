package com.deppon.dpm.module.management.server.app.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations={
		"classpath:spring.xml"
		})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class BaseTestCase extends AbstractTransactionalJUnit4SpringContextTests{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
}
