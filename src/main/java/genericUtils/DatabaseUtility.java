package genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Driver driverref;
	Connection con;
	ResultSet result;
	
	public void connectToDB() throws SQLException
	{
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);
	}
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	public String executeQueryAndGetData(String query, int columnIndex,String expData) throws SQLException
	{
		Boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData=result.getString(columnIndex);
			if(actData.equalsIgnoreCase(expData))
			{
			flag=true;
			break;
		}
	}
	if(flag)
	{
		System.out.println(expData+ "data verified");
	}
	else
	{
		System.out.println(expData + " data is not verified");
		return "";
	}
	return expData;
	}
	}

