/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author balaji
 */
public class rdetails extends Thread{
     public String Sensorport;
    public String Sensorname;
    public ValueObject vo=new ValueObject();
    public ValueObject vo1=new ValueObject();
    public rdetails(String port,String name)
    {
        Sensorport=port;
        Sensorname=name;
        start();
    }
    
    public void run()
    {
        try{

                Connection connec=getConnection();
		Statement st=connec.createStatement();
                ResultSet rs = st.executeQuery("select * from rdetails");
			while(rs.next()){

                                //  System.out.println("---------------ggg---------"+utype);
				String fname=rs.getString("NAME");
                                String lname=rs.getString("RMEM");
                                String uname=rs.getString("SMEM");
                                String email=rs.getString("SPEED");
                                 String c=rs.getString("STYPE");


                                vo.addData(fname);
                                vo.addData(lname);
                                vo.addData(uname);
                                vo.addData(email);
                                vo.addData(c);

                                vo.done();
                                Thread.sleep(500);
                              //  System.out.println("---------------ggg---------"+fname+lname+uname+email+ph+userty);
			}

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
