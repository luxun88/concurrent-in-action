package devin.wu.concurrent.practice.msgproc.consumer.processor;

/**
 * 
 * @date 2019年3月3日
 * @author devin.wu
 * @version 1.0.0
 *
 */
public class MessageProcessorManger
{
	private static MessageProcessorManger manager = new MessageProcessorManger();
	
	
	private MessageProcessorManger()
	{
		
	}
	
	public static MessageProcessorManger getInstance()
	{
		return manager;
	}
}
