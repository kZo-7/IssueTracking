package kzo.issuetracking.util;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {
	
	//Connection Pool with DB
	private static JDBCDataSource datasource;
	private JDBCDataSource() {
	}
	private ComboPooledDataSource cpds = null;
	
	//Create an instance of Connection Pool
	public static JDBCDataSource getInstance() {
		if (datasource == null) {
			//allow us to load data from our distinct System.properties file
			ResourceBundle resBundl = ResourceBundle.getBundle("issueTrackingApp.System");
			//store into driver var the url value from system.properties file
			String driver = resBundl.getString("MYSQL_DB_DRIVER");
			String urlDB = resBundl.getString("MYSQL_DB_URL");
			String user = resBundl.getString("MYSQL_DB_USERNAME");
			String psw = resBundl.getString("MYSQL_DB_PASSWORD");
			//String inPoolSz = resBundl.getString("initialPoolSize");
			int inPoolSz = Integer.parseInt(resBundl.getString("initialPoolSize"));
			int acqIncrement = Integer.parseInt(resBundl.getString("acquireIncrement"));
			int maxPoolSz = Integer.parseInt(resBundl.getString("maxPoolSize"));
			int minPoolSz = Integer.parseInt(resBundl.getString("minPoolSize"));
			int tmOut = DataUtil.getInt(resBundl.getString("timeout"));
			
			//System.out.println("inPoolSz : "+Integer.parseInt(inPoolSz));	
			/*
			 * System.out.println("inPoolSz : " + inPoolSz);
			 * System.out.println("acqIncrement : " + acqIncrement);
			 * System.out.println("maxPoolSz : " + maxPoolSz);
			 * System.out.println("minPoolSz : " + minPoolSz); System.out.println("tmOut : "
			 * + tmOut);
			 */
			
			datasource = new JDBCDataSource();
			//create a connection pool
			datasource.cpds = new ComboPooledDataSource();
			
			try {
				datasource.cpds.setDriverClass(driver);
			} catch (Exception e) {
				System.out.println("DataUtil.JDBCDataSource.getInstance()");
				e.printStackTrace();
			}
			
			datasource.cpds.setJdbcUrl(urlDB);
			datasource.cpds.setUser(user);
			datasource.cpds.setPassword(psw);
			//datasource.cpds.setInitialPoolSize(new Integer((String) inPoolSz));
			//datasource.cpds.setInitialPoolSize(Integer.parseInt(inPoolSz));	
			datasource.cpds.setInitialPoolSize(inPoolSz);
			datasource.cpds.setAcquireIncrement(acqIncrement);
			datasource.cpds.setMaxPoolSize(maxPoolSz);
			datasource.cpds.setMinPoolSize(minPoolSz);
			datasource.cpds.setMaxIdleTime(tmOut);
			//System.out.println("Get Initial Pool Size = " + datasource.cpds.getInitialPoolSize());
		}
		//System.out.println("Datasource is : " + datasource);
		return datasource;
	}
	
	//Gets the connection from ComboPooledDataSource
	//"Connection" class with a "connection()" method
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}
	
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("DataUtil.closeConnection(conn)");
				e.printStackTrace();
			}
		}
	}
	
}
