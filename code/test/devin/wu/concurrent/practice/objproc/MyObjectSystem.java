package devin.wu.concurrent.practice.objproc;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import devin.wu.concurrent.practice.objproc.entity.MyObject;

/**
 * 
 *@date 2019年3月3日
 *@author DevinWu
 *@version 1.0.0
 *
 */
public class MyObjectSystem
{
	public static void main(String[] args)
	{
		BlockingQueue<MyObject> bufferPool = new LinkedBlockingQueue<>();
		MyObjectConsumer consumer = new MyObjectConsumer(bufferPool);
		MyObjectProducer producer = new MyObjectProducer(bufferPool);
		
		Thread consumerThread1 = new Thread(consumer);
		consumerThread1.setName("MyObject-Consumer-1");
		Thread producerTread1 = new Thread(producer);
		producerTread1.setName("MyObject-Producer-1");
		Thread producerTread2 = new Thread(producer);
		producerTread2.setName("MyObject-Producer-2");
		Thread producerTread3 = new Thread(producer);
		producerTread3.setName("MyObject-Producer-3");
		
		consumerThread1.start();
		producerTread1.start();
		producerTread2.start();
		producerTread3.start();
		try
		{
			consumerThread1.join();
			producerTread1.join();
			producerTread2.join();
			producerTread3.join();
			
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println(new Date() + "# " + MyObjectSystem.class.getSimpleName() + " Exit().");
	}
	
}
