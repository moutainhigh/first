package com.deppon.dpm.module.common.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deppon.dpm.module.common.server.service.impl.PhotoAddressService;
import com.deppon.dpm.module.common.test.BaseTestCase;

public class PhotoAddressServiceTest extends BaseTestCase {
	
	@Autowired
	private PhotoAddressService photoAddressService;

	@Test
	public void testGetter(){
		String feedBackAddress = photoAddressService.getFeedBackAddress();
		String headPortraitAddress = photoAddressService.getHeadPortraitAddress();
		String serverHostPort = photoAddressService.getServerHostPort();
		String taskPhotoAddress = photoAddressService.getTaskPhotoAddress();
		String welcomeAddress = photoAddressService.getWelcomeAddress();
		System.out.println("feedBackAddress = " + feedBackAddress);
		System.out.println("headPortraitAddress = " + headPortraitAddress);
		System.out.println("serverHostPort = " + serverHostPort);
		System.out.println("taskPhotoAddress = " + taskPhotoAddress);
		System.out.println("welcomeAddress = " + welcomeAddress);
	}
}
