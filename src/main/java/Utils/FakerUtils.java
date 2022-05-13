package Utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	public Long generaterandomnumber()
	{
		Faker faker=new Faker();
	return	faker.number().randomNumber();
	}

	}


