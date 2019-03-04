package devin.wu.concurrent.practice.msgproc.consumer.processor;

import java.util.concurrent.ThreadFactory;

/**
 * 
 * @date 2019年3月4日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class ProcessorThreadFactory implements ThreadFactory
{
	@Override
	public Thread newThread(Runnable r)
	{
		Thread thread = new Thread(r);
		String name = getClass().getName() + System.currentTimeMillis();
		if (r instanceof MessageProcessor)
		{
			name = "MessageProcessor-" + ((MessageProcessor) r).getId();
		}
		thread.setName(name);
		return thread;
	}

}
