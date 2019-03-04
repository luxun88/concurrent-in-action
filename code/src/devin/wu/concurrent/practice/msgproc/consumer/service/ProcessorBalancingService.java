package devin.wu.concurrent.practice.msgproc.consumer.service;

import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;

/**
 * 
 *@date 2019年3月3日
 *@author devin.wu
 *@version 1.0.0
 *
 */
public class ProcessorBalancingService
{
	private static ProcessorBalancingService instance = new ProcessorBalancingService();
	
	
	private ProcessorBalancingService()
	{
	}
	
	public static ProcessorBalancingService getInstance()
	{
		return instance;
	}

	public void onConsumed(int messageProcessorId, Message message)
	{
		// TODO Auto-generated method stub
		
	}

	public void onAdded(int messageProcessorId, Message message)
	{
		// TODO Auto-generated method stub
		
	}
}
