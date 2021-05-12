/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;



import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author user
 */
public class Logincheck {
    String status="invalid";
      public String check(String name,String pass)
    {
        try{
            Connection connec=getConnection();
		Statement st=connec.createStatement();
                ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()){
                            if(rs.getString("uname").trim().equals(name.trim())&&(rs.getString("pass").trim().equals(pass.trim())))
                            {

                               // uploaddata(fname,lname,uname,pwd,mail,ph,usertype);
				status="valid";

			}
            }
    }
      catch(Exception e)
       {
          e.printStackTrace();
      }
         return status;
    }
public Connection getConnection(){
		Connection conn=null;
	try{

                     Statement stmt = null;
            String url = "jdbc:mysql://localhost/";
            String dbName = "VM_consolidation";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "root";
  Class.forName(driver).newInstance();
  conn = DriverManager.getConnection(url+dbName,userName,password);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
