package devin.wu.concurrent.practice.objproc.entity;

import devin.wu.concurrent.practice.objproc.SequenceIdGenerator;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class MyObject
{
	private final long sequenceId;
	private OperationObject operationObject;
	private Operation operation;
	private String additionalMessage;
	
	public MyObject()
	{
		this.sequenceId = SequenceIdGenerator.getInstance().get();
	}
	
	@Override
	public String toString()
	{
		return "" + sequenceId;
	}
}
