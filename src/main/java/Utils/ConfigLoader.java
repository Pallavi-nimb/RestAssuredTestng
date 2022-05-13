package Utils;

import java.util.Properties;

public class ConfigLoader {

private final Properties properties;
private static ConfigLoader ConfigLoader;

private ConfigLoader()
{
	properties=PropertyUtils.propertyLoader("src/test/resources/config.properties");
}
public static ConfigLoader getInstance()
{
	if(ConfigLoader==null)
	{
		ConfigLoader=new ConfigLoader();
	}
	return ConfigLoader;
}

public String getBaseUrl()
{
	String prop=properties.getProperty("baseUrl");
	if(prop!=null)
		return prop;
	else throw new RuntimeException("property baseUrl is not specified in the config.properties file");
	
}

public String getuser()
{
	String prop=properties.getProperty("user");
	if(prop!=null)
		return prop;
	else throw new RuntimeException("property user is not specified in the config.properties file");
	
}

public String getemail()
{
	String prop=properties.getProperty("email");
	if(prop!=null)
		return prop;
	else throw new RuntimeException("property email is not specified in the config.properties file");
	
}

public String getpassword()
{
	String prop=properties.getProperty("password");
	if(prop!=null)
		return prop;
	else throw new RuntimeException("property password is not specified in the config.properties file");
	
}
}
	