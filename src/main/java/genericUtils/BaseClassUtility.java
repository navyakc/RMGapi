package genericUtils;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassUtility {

	public DatabaseUtility dLib=new DatabaseUtility();
	public RestAssuredUtilities rLib=new RestAssuredUtilities();
	public JavaUtility jLib=new JavaUtility();
	
	@BeforeSuite
	public void bsConfig()
	{
		
			dLib.connectToDB();
			baseURI = "http://localhost";
			port=8084;
		}
		
		@AfterSuite
		public void asConfig() throws SQLException
		{
			dLib.closeDB();
		}
	}

