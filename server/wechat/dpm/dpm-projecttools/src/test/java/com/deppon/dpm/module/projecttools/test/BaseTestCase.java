package com.deppon.dpm.module.projecttools.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations={
		"classpath*:com/deppon/dpm/module/projecttools/test/META-INF/ibatis/*.xml"
		})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class BaseTestCase{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
}
