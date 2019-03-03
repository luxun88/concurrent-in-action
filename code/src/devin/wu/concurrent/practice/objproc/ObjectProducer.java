package devin.wu.concurrent.practice.objproc;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public abstract class ObjectProducer<E> implements Runnable
{
	protected BlockingQueue<E> bufferPool;

	public ObjectProducer(BlockingQueue<E> bufferPool)
	{
		this.bufferPool = bufferPool;
	}
}
