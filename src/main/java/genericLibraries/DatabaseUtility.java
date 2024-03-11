package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains reusable methods to read from and modify database
 * 
 * @author jyoth
 *
 */
public class DatabaseUtility {
	private Connection connection;
	private Statement statement;
	/**
	 * This method initializes database
	 * @param url
	 * @param username
	 * @param password
	 */
	public void databaseInit(String url, String username, String password) {
		Driver dbDriver = null;
		try {
			dbDriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
			connection=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method fetches the data from database
	 * @param query
	 * @param colName
	 * @return
	 * @throws SQLException
	 */
	public List<Object> readFromDatabase(String query, String colName) throws SQLException {
		ResultSet result=statement.executeQuery(query);
			List<Object> list=new ArrayList<Object>();
			while(result.next()) {
				list.add(result.getObject(colName));
		}
	   return list;
	}
	/**
	 * This method modifies the data in the database
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query) {
		int result=0;
		try {
			result=statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method is used to close the database connection
	 */
	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
