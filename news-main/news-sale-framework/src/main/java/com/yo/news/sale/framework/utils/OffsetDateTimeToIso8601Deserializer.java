package com.yo.news.sale.framework.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeToIso8601Deserializer extends JsonDeserializer<OffsetDateTime>
{
	public static final OffsetDateTimeToIso8601Deserializer INSTANCE = new OffsetDateTimeToIso8601Deserializer();

	/**
	 * @author JAN
	 * @CreatedTime：2017年11月22日 下午1:48:51 说明：
	 * @param p
	 * @param ctxt
	 * @return
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	@Override
	public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException
	{
		// TODO 自动生成的方法存根
		return OffsetDateTime.parse(p.getText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	}

}
