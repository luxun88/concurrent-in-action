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
public class MyObjectProducer extends ObjectProducer<MyObject>
{
	private ConsoleLogger logger = ConsoleLogger.createLogger(getClass().getName());

	public MyObjectProducer(BlockingQueue<MyObject> bufferPool)
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
				MyObject myObj = generate();
				logger.info("Produce: " + myObj);
				this.bufferPool.put(myObj);
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			catch (InterruptedException e)
			{
				logger.error("", e);
			}
		}
	}

	private MyObject generate()
	{
		MyObject myOfbj = new MyObject();
		return myOfbj;
	}

}
