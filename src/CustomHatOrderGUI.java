
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class CustomHatOrderGUI extends javax.swing.JFrame {
    private String username;
     private String PlaceOrderGUI;
     private PlaceOrderGUI order;

    private InfDB idb;
    /**
     * Creates new form ChangeHat
     */
    public CustomHatOrderGUI(PlaceOrderGUI order, String username) {
        initComponents();
        this.username = username;
        this.setLocationRelativeTo(null); 
      this.lblLoggedIn(lblLoggedIn, username);
        this.idb = HattmakarnaStudio.getDatabase();
        this.order = order;
        try{
            fillCBHatName();
            }
        catch(Exception e){
            
            }
    }
     
    private void fillCBHatName()
    {
        cbCustomHat.removeAllItems();
        String hatQuery = "SELECT HATNAME FROM HAT";

        ArrayList<String> allHats;

        try {
            allHats = idb.fetchColumn(hatQuery);
            cbCustomHat.addItem("Välj namn");
            for (String a : allHats) {
            cbCustomHat.addItem(a);
        }
        } 
        catch (InfException ex) {
            System.out.println("Det gick fel");
        }
}
    
   public static void lblLoggedIn(JLabel textbox, String username) {
       textbox.setText("Du är inloggad som " + username + ".");
       
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoggedIn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblHeadline = new javax.swing.JLabel();
        cbCustomHat = new javax.swing.JComboBox<>();
        lblInfo = new javax.swing.JLabel();
        lblLaggTill = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfNote = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoggedIn.setText("Inloggad som");

        jPanel1.setBackground(new java.awt.Color(102, 148, 200));

        lblHeadline.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblHeadline.setText("Skapa en anpassad hatt ");

        cbCustomHat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lblInfo.setText("Välj en hatt i listan att anpassa");

        lblLaggTill.setText("Lägg till");
        lblLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblLaggTillActionPerformed(evt);
            }
        });

        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfNote.setColumns(20);
        tfNote.setLineWrap(true);
        tfNote.setRows(5);
        jScrollPane1.setViewportView(tfNote);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblLaggTill)
                            .addComponent(cbCustomHat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHeadline)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCustomHat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(lblLaggTill))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedIn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblLaggTillActionPerformed
        // TODO add your handling code here:
        if (cbCustomHat.getSelectedIndex() > 0) {
            if (!tfNote.getText().equals("")) {
                String newNote = tfNote.getText();

                try {
                    idb.insert("INSERT INTO CustomHat (Note, StandardHat) "
                            + "VALUES ('" + newNote + "', "
                            + "(SELECT HatID FROM Hat WHERE HatName = '" + cbCustomHat.getSelectedItem() + "'))");
                    order.addCustomHatToOrder(idb.fetchSingle("Select CustomhatID From CustomHat Where Note ='" + newNote + "'"));
                    JOptionPane.showMessageDialog(null, "Den anpassade hatten har lagts till");
                    dispose();
                } catch (InfException ex) {
                    Logger.getLogger(CustomHatOrderGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du måste göra en anteckning");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Du har inte valt en hatt");
        }


    }//GEN-LAST:event_lblLaggTillActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (order != null) {
            this.dispose();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCustomHat;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JButton lblLaggTill;
    private javax.swing.JLabel lblLoggedIn;
    private javax.swing.JTextArea tfNote;
    // End of variables declaration//GEN-END:variables
}
