
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author markusmirza
 */
public class SearchCustomer extends javax.swing.JFrame {
    
    private String username;
    private InfDB idb;

    /**
     * Creates new form SearchCustomer
     */
    public SearchCustomer(String username) {
        initComponents();
        //nynamn();
        lista();
        sok();
        this.username = username;
         idb = HattmakarnaStudio.getDatabase();
        
    }
    
    private void nynamn(){
        // Hämta TableColumnModel från tabellen
    }
    private void lista(){
      //String kundNamn = jtxKund.getText();
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HattDB", "hattdb", "hattkey");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE NOT FirstName='Anonym'");
            
            DefaultTableModel model = (DefaultTableModel) jtKund.getModel() ;

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
              TableColumnModel columnModel = jtKund.getColumnModel();
              
// Hämta varje TableColumn och sätt dess headerValue till det namn du vill ha
TableColumn column = columnModel.getColumn(0);
column.setHeaderValue("Kund ID");

column = columnModel.getColumn(1);
column.setHeaderValue("Förnamn");

column = columnModel.getColumn(2);
column.setHeaderValue("Efternamn");

column = columnModel.getColumn(3);
column.setHeaderValue("Telefonummer");

column = columnModel.getColumn(4);
column.setHeaderValue("Email");

column = columnModel.getColumn(5);
column.setHeaderValue("Hattstorlek");

column = columnModel.getColumn(6);
column.setHeaderValue("Adress");

column = columnModel.getColumn(7);
column.setHeaderValue("Postnummer");

column = columnModel.getColumn(8);
column.setHeaderValue("Stad");

// Uppdatera JTable med de nya namnen
jtKund.getTableHeader().repaint();
                
            
        } catch(Exception e){
            System.out.println( "Är du");
        }}
    
    public void sok(){
                  jtxKund.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
        search();
    }
    public void removeUpdate(DocumentEvent e) {
        search();
    }
    public void insertUpdate(DocumentEvent e) {
        search();
    }

    public void search() {
        String kund = jtxKund.getText();
        try {
            DefaultTableModel kundTabell = (DefaultTableModel) jtKund.getModel();
            kundTabell.setRowCount(0);
            ArrayList<HashMap<String, String>> kundLista;
            kundLista = idb.fetchRows("SELECT * FROM Customer WHERE FirstName LIKE '%" + kund + "%'OR LastName LIKE '%" + kund + "%' OR Phone LIKE '%" + kund + "%' OR Email LIKE '%" + kund + "%' OR HatSize LIKE '%" + kund + "%' OR Address LIKE '%" + kund + "%' OR PostalNr LIKE '%" + kund + "%' OR City LIKE '%" + kund + "%'");
             
            
            for (HashMap enKund : kundLista) {
                
                if(!enKund.get("FirstName").equals("Anonym")){
                
                Vector nyLista = new Vector();
                nyLista.add(enKund.get("CustomerID"));
                nyLista.add(enKund.get("FirstName"));
                nyLista.add(enKund.get("LastName"));
                nyLista.add(enKund.get("Phone"));
                nyLista.add(enKund.get("Email"));
                nyLista.add(enKund.get("HatSize"));
                nyLista.add(enKund.get("Address"));
                nyLista.add(enKund.get("PostalNr"));
                nyLista.add(enKund.get("City"));
                
                kundTabell.addRow(nyLista);
                }
            }
                          
        } catch (Exception e) {
            System.out.println("Är du");
        }
    }
});
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtKund = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jtxKund = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbTillbaks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtKund.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kund ID", "Förnamn", "Efternamn", "Telefonummer", "Email", "Hattstorlek", "Adress", "Postnummer", "Stad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtKund);

        jPanel1.setBackground(new java.awt.Color(102, 148, 200));

        jButton3.setText("Ta bort");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtxKund.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxKundActionPerformed(evt);
            }
        });

        jLabel1.setText("Sök:");

        jbTillbaks.setText("Tillbaka");
        jbTillbaks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTillbaksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxKund, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 539, Short.MAX_VALUE)
                .addComponent(jbTillbaks)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jtxKund, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jbTillbaks))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       jtKund.getSelectedRow();
        try {
            idb.update("UPDATE Customer SET FirstName='Anonym', LastName='Anonym', Phone='0', Email='Anonym@Anonym.com', HatSize='0', Address='Anonym', PostalNr='0', City='Anonym' Where CustomerID='" + jtKund.getValueAt(jtKund.getSelectedRow(), 0).toString() + "'");
            DefaultTableModel model = (DefaultTableModel) jtKund.getModel();
            model.setRowCount(0);
            lista();
            
        } catch (InfException ex) {
            Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtxKundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxKundActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxKundActionPerformed

    private void jbTillbaksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTillbaksActionPerformed
        // TODO add your handling code here:
        new HomePageGUI(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_jbTillbaksActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbTillbaks;
    private javax.swing.JTable jtKund;
    private javax.swing.JTextField jtxKund;
    // End of variables declaration//GEN-END:variables

   
}
