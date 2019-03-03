package devin.wu.sdk.logger;

import java.text.SimpleDateFormat;


/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public class ConsoleLogger
{
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String className;

	private ConsoleLogger(String className)
	{
		this.className = className;
	}

	public static ConsoleLogger createLogger(String className)
	{
		return new ConsoleLogger(className);
	}

	public void info(Object message)
	{
		System.out.println(formatMessage(message, LoggerLevel.INFORMATION));
	}

	public void info(Object message, Exception e)
	{
		System.out.println(formatMessage(message, LoggerLevel.INFORMATION));
		e.printStackTrace();
	}

	public void warn(Object message)
	{
		System.out.println(formatMessage(message, LoggerLevel.WARNING));
	}

	public void warn(Object message, Exception e)
	{
		System.out.println(formatMessage(message, LoggerLevel.WARNING));
		e.printStackTrace();
	}

	public void error(Object message)
	{
		System.out.println(formatMessage(message, LoggerLevel.ERROR));
	}

	public void error(Object message, Exception e)
	{
		System.out.println(formatMessage(message, LoggerLevel.ERROR));
		e.printStackTrace();
	}

	private String formatMessage(Object message, LoggerLevel loggerLevel)
	{
		String formatedCurrentDate = simpleDateFormat.format(System.currentTimeMillis());
		StringBuffer formatedMsg = new StringBuffer(formatedCurrentDate);
		formatedMsg.append(" ").append(loggerLevel.getLevelDesc()).append(" ");
		formatedMsg.append(className).append(" ").append(message);
		return formatedMsg.toString();
	}
}
