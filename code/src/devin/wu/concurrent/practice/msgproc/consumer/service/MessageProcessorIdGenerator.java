package devin.wu.concurrent.practice.msgproc.consumer.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @date 2019年3月4日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class MessageProcessorIdGenerator
{
	private static AtomicInteger id = new AtomicInteger();

	public static int generate()
	{
		return id.incrementAndGet();
	}
}
