/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.net.InetAddress;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author balaji
 */
public class namegetting {
Random ran = new Random();
    public String cname()
{
String name=JOptionPane.showInputDialog(null,"Enter the user ID.");
boolean ok=true;
while(ok)
{
if(name.equals(""))
{
name=JOptionPane.showInputDialog(null,"Enter the user ID");
}
else
{
ok=false;
}
}
return name;
}
    public String CPort()
{
String cport=String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10));
//System.out.println(nodeport);
return cport;
}
public String SystemName()throws Exception
{
String localsys=InetAddress.getLocalHost().getHostName();
return localsys;
}
}
