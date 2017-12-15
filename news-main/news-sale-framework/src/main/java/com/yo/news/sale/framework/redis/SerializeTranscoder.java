/**
 * 
 */
package com.yo.news.sale.framework.redis;

import java.io.Closeable;

/**
 */
/**
 * @author JAN
 * @CreatedTime：2015年5月28日 下午1:56:45 说明：
 */
public abstract class SerializeTranscoder
{

	public abstract byte[] serialize(Object value);

	public abstract Object deserialize(byte[] in);

	public void close(Closeable closeable)
	{
		if (closeable != null)
		{
			try
			{
				closeable.close();
			}
			catch (Exception e)
			{

			}
		}
	}
}
