
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mattiasmesserer
 */
public class SearchCustomer {

    public SearchCustomer() {
 
        iniTable();
        

    }
    
    public void iniTable(){
        
        try{
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HattDB", "hattdb", "hattkey");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
            
            DefaultTableModel model = new DefaultTableModel();

            ResultSetMetaData meta = rs.getMetaData();
            int numCols = meta.getColumnCount();
            
            String[] columnNames = new String[numCols];
            for (int i = 0; i < numCols; i++){
                columnNames[i] = meta.getColumnName(i+1);
            }
            
            model.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                Object[] rowData = new Object[numCols];
                for (int i = 0; i < numCols; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            JTable table = new JTable(model);
            JFrame frame = new JFrame();
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setVisible(true);
       
            model.addTableModelListener(new TableModelListener() {
                public void tableChanged(TableModelEvent e){
                    
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    
                    Object newValue = model.getValueAt(row, col);
                    
                    try{
                      
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HattDB", "hattdb", "hattkey");
                        
                        String columnName = model.getColumnName(col);
                        System.out.println(columnName);
                        Object CustomerID = model.getValueAt(row, 0);
                        String sql = "UPDATE Customer SET " + columnName + "=? WHERE CustomerID=?";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setObject(1, newValue);
                        stmt.setObject(2, CustomerID);
                        stmt.executeUpdate();

                    stmt.close();
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                        System.out.println(ex.getMessage() + " knas i Actionevent");
                }             
                
            }
        });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public static void main(String[] args){
        new SearchCustomer();
    }
}
