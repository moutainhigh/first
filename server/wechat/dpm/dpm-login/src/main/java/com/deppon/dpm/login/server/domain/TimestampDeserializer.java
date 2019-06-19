package com.deppon.dpm.login.server.domain;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * @description
 * @version 1.0
 * @author cbb
 * @update 2012-10-30 下午8:59:21
 */
public class TimestampDeserializer extends JsonDeserializer<Timestamp> {

	/**
	 * deserialize
	 */
	@Override
	public Timestamp deserialize(JsonParser parser,
			DeserializationContext context) throws IOException {
		// 获取text
		String text = parser.getText();
		// 时间转换
		Timestamp timestamp = stringToTimestamp(text, "yyyy-MM-dd HH:mm:ss");
		// 返回值
		return timestamp;
	}

	/**
	 * stringToTimestamp
	 * 
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 */
	private Timestamp stringToTimestamp(String dateStr, String dateFormat) {
		// 判断dateStr是否为空
		if (dateStr == null || "".equals(dateStr.trim())) {
			// 返回null
			return null;
		}
		// 时间格式
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			// 格式化时间
			return new Timestamp(df.parse(dateStr).getTime());
		} catch (ParseException e) {
			// 异常处理
			e.printStackTrace();
		}
		// 返回
		return null;
	}

}
