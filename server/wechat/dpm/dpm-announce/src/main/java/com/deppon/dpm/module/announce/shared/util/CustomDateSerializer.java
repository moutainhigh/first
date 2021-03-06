//package com.deppon.dpm.module.announce.shared.util;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
///**
// * jackson自定义序列化日期格式
// * 
// * @author 245968
// * 
// */
//public class CustomDateSerializer extends JsonSerializer<Date> {
//
//	@Override
//	public void serialize(Date value, JsonGenerator jgen,
//			SerializerProvider provider) throws IOException,
//			JsonProcessingException {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		String formattedDate = formatter.format(value);
//		jgen.writeString(formattedDate);
//	}
//}