package collections.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 	abc.properties file
 		user=scott
 		pwd=tiger
 		venki=9999
*/

public class PropertiesDemo {
	
	public static void main(String[] args) throws Exception 
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("D:\\HHCIB\\codes\\core-java\\CoreJava\\src\\collections\\map\\abc.properties");
		p.load(fis);
		
		System.out.println(p);
		
		String s = p.getProperty("venki");
		System.out.println(s);
		
		p.setProperty("nag", "88888");
		
		FileOutputStream fos = new FileOutputStream("D:\\HHCIB\\codes\\core-java\\CoreJava\\src\\collections\\map\\abc.properties");
		p.store(fos, "Updated properties file");
		
		//dbPropertiesExample();
	}

	private static void dbPropertiesExample() throws Exception 
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("db.properties");
		p.load(fis);
		
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("pwd");
		
		Connection con = DriverManager.getConnection(url, user, pwd);
	}
}
