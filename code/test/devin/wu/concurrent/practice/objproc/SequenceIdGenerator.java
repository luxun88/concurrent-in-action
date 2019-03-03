package devin.wu.concurrent.practice.objproc;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class SequenceIdGenerator
{
	private static SequenceIdGenerator seqGenerator = new SequenceIdGenerator();
	
	public static SequenceIdGenerator getInstance()
	{
		return seqGenerator;
	}
	
	public synchronized long get()
	{
		try
		{
			TimeUnit.MILLISECONDS.sleep(1);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}
}
