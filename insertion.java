/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author balaji
 */
public class insertion {
     String status="invalid";
  public String check(String fname,String lname,String uname,String pwd,String mail,String ph)
    {

     try{
                Connection connec=getConnection();
		Statement st=connec.createStatement();
                ResultSet rs = st.executeQuery("select * from user where uname='"+uname+"'");
			if(rs.next()){
                                JOptionPane.showMessageDialog(null, "same user already exist....");
				status="valid";

			}
                  else{
                    uploaddata(fname,lname,uname,pwd,mail,ph);
                    status="invalid";
                 }
     }
     catch(Exception e)
     {
         e.printStackTrace();;
     }
     return status;
 }
  public void uploaddata(String fname,String lname,String uname,String pwd,String mail,String ph)
    {
        try{
                Connection connec=getConnection();
		Statement st=connec.createStatement();
		st.executeUpdate("insert into user values('"+fname+"','"+lname+"','"+uname+"','"+pwd+"','"+mail+"','"+ph+"')");
                JOptionPane.showMessageDialog(null, "user created successfully inserted....");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

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

