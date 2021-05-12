package logic;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javafx.ext.swing.SwingComponent;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;
import javax.swing.text.html.MinimalHTMLWriter;
import java.lang.Math;

public  class TableColumn{
    public var text: String;
}
public class TableCell{
    public var text: String;
}

public class TableRow{

    public var cells: TableCell[];
}

public class JtableA extends SwingComponent {
    var jtab:JTable;
    var model:DefaultTableModel;
    public var selection: Integer;
    public var columns: TableColumn[] on replace{
        model = new DefaultTableModel(for(column in columns) column.text, 0);
        jtab.setModel(model);
        jtab.getTableHeader().setReorderingAllowed(false);
        jtab.setFont(new Font("Caracteres L4", Font.ITALIC, 12));
        jtab.setEnabled(false);
        jtab.setSize(new Dimension(50,50));
    };

    public var rows: TableRow[] on replace oldValue[lo..hi] = newVals{
        //for(index in [hi..lo step -1]){
          //  model.removeRow(index);
        //}

        for(row in newVals){
            model.addRow(for(cell in row.cells) cell.text);
        }
    };

 public override function createJComponent(){
    jtab=new JTable();
    model=jtab.getModel() as DefaultTableModel;
    var jscr:JScrollPane = new JScrollPane(jtab);
    var selectionModel = jtab.getSelectionModel();
        selectionModel.addListSelectionListener(
        ListSelectionListener{
            public override function valueChanged(e: ListSelectionEvent ) {
                selection = jtab.getSelectedRow();
            }
        }
        );
      // jtab.getPreferredScrollableViewportSize();
     //  jtab.setPreferredScrollableViewportSize(new Dimension(Math.min(getPrefWidth(10))),(Math.min(getPrefHeight(10))));
         jscr.setPreferredSize(new Dimension(400,400));
     return jscr;
}
}
