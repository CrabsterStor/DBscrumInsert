package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class States {
	
	Connection myConn;
	PreparedStatement statement = null;
	String sql = null;
	
	public States(Connection con){
	myConn = con;
	}
	
	public void tableInsert() {
		System.out.println("Inserting states...");
		String[] tab = {"DONE", "TODO"};
		statement = null;
		
		for(int quantity = 0; quantity < tab.length; quantity++) {
			
			sql = "INSERT INTO States (StateValue) VALUE (?)";
			try {
				statement = myConn.prepareStatement(sql);
				statement.setString(1, tab[quantity]);
				statement.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}
		System.out.println("Done");
	}
}