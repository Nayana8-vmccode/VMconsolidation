/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.util.Observer;
import java.util.Observable;
import java.util.Vector;
import JtableA.TableRow;
import JtableA.TableCell;

/**
 * @author Pcube03
 */
public class ValueObjectAdapter extends Observer {
         public-read var tablerow:JtableA.TableRow[];
    public-read var neigh:String;
     public-read var neigh1:String;
     public-read var message:String;
      public-read var path:String;
       public-read var dpath:String;
        public-read var ddata:String;
        var priport:Vector=new Vector();
    public var valueObject : ValueObject
    on replace { valueObject.addObserver(this)}
    override function update(observable: Observable, arg: Object)
    {
        FX.deferAction(
            function(): Void
    {

       neigh=valueObject.getneigh();
        neigh1=valueObject.getneigh1();
        message=valueObject.getmsg();
        path=valueObject.getpath();
         dpath=valueObject.getdpath();
          ddata=valueObject.getdata();
           priport=valueObject.getData();

            insert JtableA.TableRow {
                    cells:[
                        for(i in priport)
                        JtableA.TableCell {
                            text:i.toString();
                        }
                    ]
                }into tablerow;


    }
    );
    }
    }
