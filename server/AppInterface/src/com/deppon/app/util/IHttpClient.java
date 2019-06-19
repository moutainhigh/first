/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2006 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2012-2-11
 *******************************************************************************/

package com.deppon.app.util;

import java.io.ByteArrayOutputStream;

public interface IHttpClient {
	public abstract void addHead(String paramString1, String paramString2);

	public abstract boolean isReDirect();

	public abstract void setCookie(String paramString);

	public abstract void setRequestURL(String paramString);

	public abstract void setMethod(String paramString);

	public abstract ByteArrayOutputStream getOutputStream();

	public abstract String fetchCookie();

	public abstract String getLocation();

	public abstract void send(String paramString);

	public abstract void send(String paramString1, String paramString2);
}
