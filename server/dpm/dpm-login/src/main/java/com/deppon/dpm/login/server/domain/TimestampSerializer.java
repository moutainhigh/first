package com.deppon.dpm.login.server.domain;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @description
 * @version 1.0
 * @author cbb
 * @update 2012-10-30 下午8:59:29
 */
public class TimestampSerializer extends JsonSerializer<Timestamp> {

	/**
	 * serialize
	 */
	@Override
	public void serialize(Timestamp timestamp, JsonGenerator generator,
			SerializerProvider provider) throws IOException {
		// 时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间格式化
		String dateStr = sdf.format(new Date(timestamp.getTime()));
		generator.writeString(dateStr);
	}

}
