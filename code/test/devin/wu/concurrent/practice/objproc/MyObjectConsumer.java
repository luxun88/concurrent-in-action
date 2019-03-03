package devin.wu.concurrent.practice.objproc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import devin.wu.concurrent.practice.objproc.entity.MyObject;
import devin.wu.sdk.logger.ConsoleLogger;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class MyObjectConsumer extends ObjectConsumer<MyObject>
{
	private ConsoleLogger logger = ConsoleLogger.createLogger(getClass().getName());

	public MyObjectConsumer(BlockingQueue<MyObject> bufferPool)
	{
		super(bufferPool);
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				MyObject obj = this.bufferPool.take();
				logger.info("Consume: " + obj);
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
