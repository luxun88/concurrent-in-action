package devin.wu.concurrent.practice.msgproc.consumer.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import devin.wu.concurrent.practice.msgproc.consumer.params.ConsumerParams;
import devin.wu.concurrent.practice.msgproc.consumer.service.ProcessorBalancingService;

/**
 * 
 * @date 2019年3月3日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class MessageProcessorManger
{
	private static MessageProcessorManger manager = new MessageProcessorManger();
	private ExecutorService executorService = Executors.newCachedThreadPool(new ProcessorThreadFactory());
	private ProcessorBalancingService balancing = ProcessorBalancingService.getInstance();
	
	private MessageProcessorManger()
	{
		init();
	}

	public static MessageProcessorManger getInstance()
	{
		return manager;
	}

	private synchronized void init()
	{
		int numberOfProcessor = ConsumerParams.getNumberOfProcessor();
		for (int i = 0; i < numberOfProcessor; i++)
		{
			MessageProcessor processor = new MessageProcessor();
			executorService.execute(processor);
		}
	}

	public synchronized void release()
	{
		executorService.shutdownNow();
	}
}
