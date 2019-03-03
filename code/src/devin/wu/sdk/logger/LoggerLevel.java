package devin.wu.sdk.logger;

/**
 * 
 * @date 2019年3月3日
 * @author DevinWu
 * @version 1.0.0
 *
 */
public enum LoggerLevel
{
	INFORMATION("INFO"), WARNING("WARN"), ERROR("ERROR");

	private String levelDesc;

	private LoggerLevel(String levelDesc)
	{
		this.levelDesc = levelDesc;
	}

	public String getLevelDesc()
	{
		return levelDesc;
	}
}