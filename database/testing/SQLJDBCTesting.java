package testing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.SQLJDBCConnUtils;

public class SQLJDBCTesting {
	public static void main(String[] args) throws SQLException {
		Connection conn=SQLJDBCConnUtils.getSQLServerConnection();
		
		//dinh nghia 1 cau query
		String sql="SELECT *  FROM [autotest].[dbo].[CUSTOMER]";
		
		//thuc thi query
		Statement statement=conn.createStatement();
		
		//hung du lieu tu query tra ve
		ResultSet result=statement.executeQuery(sql);
		
		//duyet qua du lieu tra ve
		while (result.next()) {
			System.out.println("---------------");
			System.out.println(result.getInt("CUST_ID"));
			System.out.println(result.getString("ADDRESS"));
			System.out.println(result.getString("CITY"));
			System.out.println(result.getString("POSTAL_CODE"));
			System.out.println(result.getString("STATE"));
			
			
		}
		conn.close();
	}
}
