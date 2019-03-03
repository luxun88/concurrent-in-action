package devin.wu.concurrent.practice.msgproc.consumer;

import java.util.concurrent.LinkedBlockingQueue;

import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;
import devin.wu.concurrent.practice.msgproc.consumer.processor.MessageProcessorCenter;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class MessageReceiver implements Runnable
{
	private volatile boolean isContinuing = true;
	private LinkedBlockingQueue<Message> queue;
	private MessageProcessorCenter msgProcCenter;

	public MessageReceiver(LinkedBlockingQueue<Message> queue,
			               MessageProcessorCenter msgProcCenter)
	{
		this.queue = queue;
		this.msgProcCenter = msgProcCenter;
	}

	public void put(Message msg) throws InterruptedException
	{
		queue.put(msg);
	}

	@Override
	public void run()
	{
		while (isContinuing)
		{
			try
			{
				Message message = queue.take();
				msgProcCenter.onProcess(message);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
