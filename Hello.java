/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 *
 * @author balaji
 */
public class Hello extends Thread {
     public HashMap hm1=new HashMap();
     public HashMap hm2=new HashMap();
     public HashMap hm3=new HashMap();
     public HashMap hm4=new HashMap();
     public HashMap hm5=new HashMap();
     public HashMap hm6=new HashMap();
     public ArrayList neighbour=new ArrayList();
     public ArrayList neighbour12=new ArrayList();
     public ValueObject valueobject = new ValueObject();
 public Hello()
 {
     start();
 }
 public void run(){
     System.out.println("Inside the user HELLO RECEIVER");
     try{
     while(true){
                InetAddress ip=InetAddress.getByName("228.8.9.7");
                MulticastSocket ms=new MulticastSocket(6678);
                ms.joinGroup(ip);
                byte[] by=new byte[9999];
                DatagramPacket dp=new DatagramPacket(by,by.length);
                ms.receive(dp);
                String details=new String(dp.getData()).trim();
                //System.out.println("HelloReceiver receiving Data............."+details);
                StringTokenizer st=new StringTokenizer(details,"@");
                String set=st.nextToken();
                if(set.equalsIgnoreCase("MobileDetails")){
                     //System.out.println("Enter into the Vechicle");
                     String nname=st.nextToken().trim();
                     String nport=st.nextToken().trim();
                     String sysname=st.nextToken().trim();
                     hm1.put(nname,nport);
                     hm2.put(nname,sysname);
                     if(!neighbour.contains(nname))
                     {
                     neighbour.add(nname);
                    }
//                     String ndist=st.nextToken().trim();
//                     String nrang=st.nextToken().trim();
                             System.out.println(neighbour+"nnmae"+nname);
                             valueobject.setneigh1(nname);

                             }

                     }
         }
catch(Exception e)
{
e.printStackTrace();
}
}


}

