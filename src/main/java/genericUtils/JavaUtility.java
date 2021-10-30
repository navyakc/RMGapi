package genericUtils;

import java.util.Random;

/**
 * 
 * @author navya
 * THIS CLASS have generic methods related to java library
 */

public class JavaUtility {

	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
	}
	
}
