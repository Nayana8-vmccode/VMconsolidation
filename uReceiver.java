/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author balaji
 */
public class uReceiver extends Thread {
     public String pport;
    public String pname;
    String k="";
    public ValueObject v=new ValueObject();
public void uReceiver1(String port)
    {
        pport=port;
         start();
    }
    public void uReceiver2(String name)
    {
     pname=name;
    }
    public void run()
    {
        System.out.println("---------->Server Started-------->");
      try{
          ServerSocket ss=new ServerSocket(Integer.parseInt(pport));
          while(true)
          {
              Socket s=ss.accept();
              ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
              String Startdata=(String)ois.readObject();
              if(Startdata.equals("response"))
               {
                 String status=(String)ois.readObject();
                 k=status;
                // result(status);
              }
              else if(Startdata.equals("uresponse"))
               {
                 String data=(String)ois.readObject();
                 v.setdata(data);
                // result(status);
              }
        }
        }
      catch(Exception e)

      {
          e.printStackTrace();
      }
    }
    public String result()
    {
         String m="";
        try{
            m=k;
             JOptionPane.showMessageDialog(null,m);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return m;
    }
}
