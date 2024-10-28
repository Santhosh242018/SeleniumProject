package SQLData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDatafromSQL {

	public static void main(String[] args) throws Throwable {
		
		//Step 1 - Register Driver
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step 2 - Get the connection to connect database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainer_details","root","Daakshi@123");
		
		//Step 3 - Create SQL Statement
		
		Statement state = conn.createStatement();
		String query = "select * from trainer";
		
		//Step 4 - Execute Query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"+ result.getString(4));
			
		}
		
		//Step 5 - Close the database
		conn.close();
	}

}
