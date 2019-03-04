package devin.wu.concurrent.practice.msgproc.consumer.processor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;
import devin.wu.concurrent.practice.msgproc.consumer.service.MessageProcessorIdGenerator;
import devin.wu.concurrent.practice.msgproc.consumer.service.ProcessorBalancingService;
import devin.wu.sdk.logger.ConsoleLogger;

/**
 * 
 * @date 2019年3月3日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class MessageProcessor implements Runnable
{
	private ConsoleLogger logger = ConsoleLogger.createLogger(getClass().getName());
    
	private final int id = MessageProcessorIdGenerator.generate();
	private ProcessorBalancingService balancing = ProcessorBalancingService.getInstance();
	private LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<>();

	public int getId()
	{
		return id;
	}
	
	public void put(Message message)
	{
		try
		{
			queue.put(message);
		}
		catch (InterruptedException e)
		{
			logger.error("", e);
		}
		balancing.onAdded(id, message);
	}

	@Override
	public void run()
	{
		while (true)
		{
			Message message = null;
			try
			{
				message = queue.take();
				consumeMessage(message);
			}
			catch (InterruptedException e)
			{
				logger.error("", e);
			}
			balancing.onConsumed(id, message);
		}
	}

	private void consumeMessage(Message message)
	{
		logger.info("consume message: " + message.toString());
		try
		{
			TimeUnit.MILLISECONDS.sleep(100);
		}
		catch (InterruptedException e)
		{
			logger.error("", e);
		}
	}
}
