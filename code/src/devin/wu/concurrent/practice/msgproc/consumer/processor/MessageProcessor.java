package devin.wu.concurrent.practice.msgproc.consumer.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;
import devin.wu.concurrent.practice.msgproc.consumer.params.ConsumerParams;

/**
 * 
 * @date 2019年3月3日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class MessageProcessor implements Runnable
{
	private final int queueNumber;
	private List<LinkedBlockingQueue<Message>> queues;

	public MessageProcessor()
	{
		queueNumber = ConsumerParams.getQueueNumberInOneProcessor();
		init();
	}

	private synchronized void init()
	{
		queues = new ArrayList<>(queueNumber);
		for (int i = 0; i < queueNumber; i++)
		{
			queues.add(new LinkedBlockingQueue<Message>());
		}
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

}
