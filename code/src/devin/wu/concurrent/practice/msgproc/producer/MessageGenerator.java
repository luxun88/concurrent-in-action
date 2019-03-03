package devin.wu.concurrent.practice.msgproc.producer;

import java.util.concurrent.LinkedBlockingQueue;

import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class MessageGenerator implements Runnable
{
	private LinkedBlockingQueue<Message> queue;

	public MessageGenerator(LinkedBlockingQueue<Message> queue)
	{
		this.queue = queue;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}

}
