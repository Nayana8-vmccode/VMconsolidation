/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.util.Observable;
import java.util.Vector;

/**
 *
 * @author Pcube03
 */
public class ValueObject extends Observable {
private String neigh;
private String neigh1;
private String message;
private String path;
private String dpath;
private String ddata;
 Vector<String> tableDataHolder=new Vector<String>();
public String getdata()
{
    return ddata;
}
public String getdpath()
{
    return dpath;
}
public String getpath()
{
    return path;
}
public void setpath(String msg)
{
    path=msg;
    fireNotify();
}
public String getmsg()
{
    return message;
}
public void setdata(String msg)
{
    ddata=msg;
    fireNotify();
}
public void setmsg(String msg)
{
    message=msg;
    fireNotify();
}
public void setdpath(String msg)
{
    dpath=msg;
    fireNotify();
}
public String getneigh()
{
   //System.out.println("neighbour2:"+cnodenei);
  return neigh;

}
public void setneigh(String dispneiname1)
{
 neigh=dispneiname1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public String getneigh1()
{
   //System.out.println("neighbour2:"+cnodenei);
  return neigh1;

}
public void setneigh1(String dispneiname1)
{
 neigh1=dispneiname1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
 
}
 public void addData(String input){
 //tableDataHolder.clear();
         tableDataHolder.add(input);
         //System.out.println("tableDataHolder:"+ tableDataHolder);
    }
    public Vector<String> getData(){
        //System.out.println("tableDataHolder1:"+ tableDataHolder);
        Vector<String> temp=(Vector<String>)tableDataHolder.clone();
       // System.out.println("valueobject:"+temp);
        tableDataHolder.clear();
        return temp;
    }
    public void done(){
        setChanged();
        notifyObservers();
    }
private void fireNotify()
{
         setChanged();
         notifyObservers();
}

}
