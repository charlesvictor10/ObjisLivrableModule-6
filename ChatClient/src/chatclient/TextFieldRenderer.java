package chatclient;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class TextFieldRenderer implements TableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column)
    {
        JTextField editor = new JTextField();
        editor.setBorder(null);
        editor.setFont(new Font("Tahoma", Font.BOLD, 10));
        if (value != null)
        {
            editor.setText(value.toString());
        }
        return editor;
  }
}