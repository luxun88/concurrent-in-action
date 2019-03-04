package devin.wu.concurrent.practice.msgproc.consumer.processor;

import devin.wu.concurrent.practice.msgproc.consumer.entity.Message;
import devin.wu.concurrent.practice.msgproc.consumer.service.ProcessorBalancingService;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class MessageProcessorCenter
{
	private ProcessorBalancingService balancing = ProcessorBalancingService.getInstance();

	public void onProcess(Message message)
	{
		//TODO
	}

}
