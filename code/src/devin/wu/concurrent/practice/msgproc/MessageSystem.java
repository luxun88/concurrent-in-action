package devin.wu.concurrent.practice.msgproc;

import java.util.concurrent.LinkedBlockingQueue;

import devin.wu.concurrent.practice.msgproc.consumer.MessageReceiver;
import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;
import devin.wu.concurrent.practice.msgproc.consumer.processor.MessageProcessorCenter;
import devin.wu.concurrent.practice.msgproc.producer.MessageGenerator;

/**
 * 
 * @date 2019年3月3日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class MessageSystem
{
	public static void main(String[] args) throws InterruptedException
	{
		MessageProcessorCenter msgProcCenter = new MessageProcessorCenter();
		LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		MessageReceiver msgReceveiver = new MessageReceiver(queue, msgProcCenter);
		MessageGenerator msgGenerator = new MessageGenerator(queue);
		
	}
}
