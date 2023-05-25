
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Linda
 */
public class PlaceOrderGUI extends javax.swing.JFrame {

    private String username;
    private ArrayList<Hat> chosenHats;
    private ArrayList<String> chosenCustomHats;
    private InfDB idb;
    private DefaultListModel<String> model = new DefaultListModel<>();
    private Double totalBasePrice;

    /**
     * Creates new form PlaceOrderGUI
     */
    public PlaceOrderGUI(String username) {
        initComponents();
        idb = HattmakarnaStudio.getDatabase();
        chosenHats = new ArrayList<>();
        chosenCustomHats = new ArrayList<>();
        totalBasePrice = 0.0;
        lblWarningPrice.setVisible(false);

        //fyller ComboBoxarna
        fillCustomer();
        fillHats();

        //Denna kod gör så att nya fönster öppnas i mitten av skärmen
        this.setLocationRelativeTo(null);
        showDate();
        this.username = username;
        this.lblLoggedIn(lblLoggedIn, username);
    }

    public void fillCustomer() {
        try {
            ArrayList<Customer> allCustomers = Customer.getAllCustomers();

            for (Customer aCustomer : allCustomers) {
                if(!aCustomer.getFirstName().equals("Anonym")){   
                cbCustomer.addItem(aCustomer.getCustomerID() + ": " + aCustomer.getLastName() + ", " + aCustomer.getFirstName());
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void fillHats() {
        try {
            ArrayList<Hat> allHats = Hat.getAllHats();

            for (Hat aHat : allHats) {
                if (aHat.getIsSpecial().equals("0")) {
                    cbBasic.addItem(aHat.getProductName());
                } else {
                    cbBasic.addItem(aHat.getProductName() + " - Special");
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void emptyCustomers() {
        cbCustomer.removeAllItems();
    }

    public void emptyHats() {
        cbBasic.removeAllItems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHats = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblWarningPrice = new javax.swing.JLabel();
        btbNewCustomer = new javax.swing.JButton();
        lblChooseHat = new javax.swing.JLabel();
        btnTaBortHatt = new javax.swing.JButton();
        txtFieldCity = new javax.swing.JTextField();
        txtFieldPostalnmbr = new javax.swing.JTextField();
        btnAddHat = new javax.swing.JButton();
        jspOrder = new javax.swing.JScrollPane();
        jlOrder = new javax.swing.JList<>();
        lblOrder = new javax.swing.JLabel();
        lblNotes = new javax.swing.JLabel();
        btnSpecial = new javax.swing.JButton();
        btnCustom = new javax.swing.JButton();
        cbBasic = new javax.swing.JComboBox<>();
        cbCustomer = new javax.swing.JComboBox<>();
        lblLoggedIn = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblOrderDate = new javax.swing.JLabel();
        chbExpress = new javax.swing.JCheckBox();
        txtFieldPrice = new javax.swing.JTextField();
        lblTotalPrice = new javax.swing.JLabel();
        lblDelivery = new javax.swing.JLabel();
        tfAdress = new javax.swing.JTextField();
        btnPlaceOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFieldNote = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 148, 200));

        jPanel1.setBackground(new java.awt.Color(102, 148, 200));

        lblHats.setText("Basutbud/Special");

        btnAdd.setText("Lägg till");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblWarningPrice.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        lblWarningPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblWarningPrice.setText("Ändra endast pris när du är klar med din beställning.");

        btbNewCustomer.setText("Ny kund");
        btbNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbNewCustomerActionPerformed(evt);
            }
        });

        lblChooseHat.setForeground(new java.awt.Color(255, 0, 0));
        lblChooseHat.setText("Vänligen markera en hatt");
        lblChooseHat.setToolTipText("");
        lblChooseHat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnTaBortHatt.setText("Ta bort");
        btnTaBortHatt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortHattActionPerformed(evt);
            }
        });

        txtFieldCity.setText("Ort");
        txtFieldCity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldCityFocusGained(evt);
            }
        });

        txtFieldPostalnmbr.setText("Postnummer");
        txtFieldPostalnmbr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldPostalnmbrFocusGained(evt);
            }
        });

        btnAddHat.setText("Lägg till hatt");
        btnAddHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHatActionPerformed(evt);
            }
        });

        jspOrder.setViewportView(jlOrder);

        lblOrder.setText("Din order");

        lblNotes.setText("Övrigt:");

        btnSpecial.setText("Registrera ny specialhatt");
        btnSpecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpecialActionPerformed(evt);
            }
        });

        btnCustom.setText("Lägg till anpassad hatt");
        btnCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomActionPerformed(evt);
            }
        });

        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj Kund" }));
        cbCustomer.setToolTipText("");
        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });

        lblLoggedIn.setText("Inloggad som");

        btnBack.setText("Tillbaka");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblOrderDate.setText("YYYY-MM-dd");

        chbExpress.setText("Expressleverans");
        chbExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbExpressActionPerformed(evt);
            }
        });

        txtFieldPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldPriceFocusGained(evt);
            }
        });

        lblTotalPrice.setText("Totalpris:");

        lblDelivery.setText("Leveransadress");

        tfAdress.setText("Gatuadress");
        tfAdress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAdressFocusGained(evt);
            }
        });

        btnPlaceOrder.setText("Lägg order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        txtFieldNote.setColumns(20);
        txtFieldNote.setLineWrap(true);
        txtFieldNote.setRows(5);
        jScrollPane1.setViewportView(txtFieldNote);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDelivery)
                                    .addComponent(lblHats)
                                    .addComponent(btnCustom, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(btnSpecial)
                                    .addComponent(chbExpress)
                                    .addComponent(lblOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTotalPrice)
                                    .addComponent(txtFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbCustomer, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                                        .addComponent(tfAdress, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(cbBasic, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btbNewCustomer)
                                    .addComponent(btnAddHat, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFieldPostalnmbr, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jspOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnTaBortHatt)
                                            .addComponent(btnAdd)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(153, 153, 153)
                                        .addComponent(btnPlaceOrder))
                                    .addComponent(lblNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblChooseHat)
                                        .addGap(3, 3, 3))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblWarningPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(lblLoggedIn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCustom, btnSpecial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblLoggedIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChooseHat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblOrder)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbNewCustomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDelivery)
                        .addGap(12, 12, 12)
                        .addComponent(tfAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldPostalnmbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(lblHats)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBasic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddHat))
                        .addGap(18, 18, 18)
                        .addComponent(btnCustom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSpecial))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnTaBortHatt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jspOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNotes)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnPlaceOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbExpress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOrderDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblWarningPrice)
                .addGap(40, 40, 40)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblChooseHat.setVisible(false);
        tfAdress.setVisible(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new HomePageGUI(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed

        if (cbCustomer.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Du har inte valt något kund för denna order");
        } else if (chosenHats.size() < 1 && chosenCustomHats.size() < 1) {
            JOptionPane.showMessageDialog(null, "Du har inte lagt några hattar i din order");
        } else {
            int result = JOptionPane.showConfirmDialog(null, "Är du helt färdig med din order?", "Lägg beställning", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {

                String customer = (String) cbCustomer.getSelectedItem();
                String[] splitCustomer = customer.split(":");

                boolean isExpress = false;

                if (chbExpress.isSelected()) {
                    isExpress = true;
                }

                new Order(splitCustomer[0], tfAdress.getText(), txtFieldPostalnmbr.getText(), txtFieldCity.getText(), lblOrderDate.getText(), Double.parseDouble(txtFieldPrice.getText()), txtFieldNote.getText(), isExpress, chosenHats, chosenCustomHats);

                dispose();
                
                new HomePageGUI(username).setVisible(true);

            }
        }
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed

        try {
            String addAdress = idb.fetchSingle("SELECT Address FROM Customer WHERE CustomerID ='" + cbCustomer.getSelectedItem() + "'");
            tfAdress.setText(addAdress);

            String addPostalNr = idb.fetchSingle("SELECT PostalNr FROM Customer WHERE CustomerID ='" + cbCustomer.getSelectedItem() + "'");
            txtFieldPostalnmbr.setText(addPostalNr);

            String addCity = idb.fetchSingle("SELECT City FROM Customer WHERE CustomerID ='" + cbCustomer.getSelectedItem() + "'");
            txtFieldCity.setText(addCity);

        } catch (InfException ex) {
            Logger.getLogger(PlaceOrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cbCustomerActionPerformed

    private void btnAddHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHatActionPerformed

        String hatName = (String) cbBasic.getSelectedItem();
        jlOrder.setModel(model);
        jlOrder.getModel();
        model.addElement(hatName);

        if (hatName.contains("-")) {
            String[] splitSpecial = hatName.split("-");
            hatName = splitSpecial[0].trim();
        }

        chosenHats.add(new Hat(hatName));

        addHatToTotalPrice(hatName);
    }//GEN-LAST:event_btnAddHatActionPerformed

    private void btnCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomActionPerformed

        new CustomHatOrderGUI(this, username).setVisible(true);

    }//GEN-LAST:event_btnCustomActionPerformed

    private void btnTaBortHattActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortHattActionPerformed

        int selectedIndex = jlOrder.getSelectedIndex();
        if (selectedIndex == -1) { // om inget objekt är markerat
            // Visa en meddelande-etikett
            lblChooseHat.setVisible(true);

        } else { // om något objekt är markerat
            // Ta bort objektet från modellen
            String removedItem = (String) model.remove(selectedIndex);
            jlOrder.setModel(model); // uppdatera JList-komponenten
            lblChooseHat.setVisible(false);

            if (removedItem.contains("#")) {
                String[] splitCustom = removedItem.split("#");
                removedItem = splitCustom[1].trim();

                for (int i = 0; i < chosenCustomHats.size(); i++) {
                    if (removedItem.equals(chosenCustomHats.get(i))) {
                        subtractCustomHatFromTotalPrice(removedItem);
                        chosenCustomHats.remove(i);
                        break;
                    }
                }
            } else {
                if (removedItem.contains("-")) {
                    String[] splitSpecial = removedItem.split("-");
                    removedItem = splitSpecial[0].trim();
                }
                for (int i = 0; i < chosenHats.size(); i++) {
                    if (chosenHats.get(i).getProductName().equals(removedItem)) {
                        chosenHats.remove(i);
                        subtractHatFromTotalPrice(removedItem);
                        break;
                    }
                }

            }
        }
    }//GEN-LAST:event_btnTaBortHattActionPerformed

    private void tfAdressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAdressFocusGained
        tfAdress.selectAll();
    }//GEN-LAST:event_tfAdressFocusGained

    private void txtFieldPostalnmbrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPostalnmbrFocusGained
        txtFieldPostalnmbr.selectAll();
    }//GEN-LAST:event_txtFieldPostalnmbrFocusGained

    private void txtFieldCityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCityFocusGained
        txtFieldCity.selectAll();
    }//GEN-LAST:event_txtFieldCityFocusGained

    private void btbNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbNewCustomerActionPerformed
        new RegCustomerGUI(username, this).setVisible(true);
    }//GEN-LAST:event_btbNewCustomerActionPerformed

    private void chbExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbExpressActionPerformed
        setPriceAndCheckCB();
    }//GEN-LAST:event_chbExpressActionPerformed

    private void txtFieldPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPriceFocusGained
        lblWarningPrice.setVisible(true);
        txtFieldPrice.selectAll();
    }//GEN-LAST:event_txtFieldPriceFocusGained

    private void btnSpecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialActionPerformed
        new RegHatGUI(this, username).setVisible(true);
    }//GEN-LAST:event_btnSpecialActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        int selectedIndex = jlOrder.getSelectedIndex();
        if (selectedIndex == -1) { // om inget objekt är markerat
            // Visa en meddelande-etikett
            lblChooseHat.setVisible(true);
        } else if (jlOrder.getSelectedValue().contains("#")) {
            String hatName = (String) jlOrder.getSelectedValue();
            jlOrder.setModel(model);
            jlOrder.getModel();
            model.addElement(hatName);

            String[] splitHat = hatName.split("#");
            chosenCustomHats.add(splitHat[1]);

            addCustomHatToTotalPrice(splitHat[1]);

        } else {
            String hatName = (String) jlOrder.getSelectedValue();
            jlOrder.setModel(model);
            jlOrder.getModel();
            model.addElement(hatName);

            if (hatName.contains("-")) {
                String[] splitSpecial = hatName.split("-");
                hatName = splitSpecial[0].trim();
            }

            chosenHats.add(new Hat(hatName));

            addHatToTotalPrice(hatName);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    public void addCustomHatToOrder(String customID) {
        try {

            String query = "select Hatname from hat join customhat on hat.HatID = customhat.StandardHat where CustomhatID = " + customID;
            InfDB idb = HattmakarnaStudio.getDatabase();
            String customName = idb.fetchSingle(query);

            model.addElement(customName + " - Anpassad" + " #" + customID);
            jlOrder.setModel(model);

            chosenCustomHats.add(customID);
            addCustomHatToTotalPrice(customID);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /* Express kostar 25% extra, kundanpassat 10%
    **/
    private void addHatToTotalPrice(String hatName) {

        try {
            String query = "select price from hat where HatName = '" + hatName + "'";
            double bigPrice = Double.parseDouble(idb.fetchSingle(query));
            BigDecimal bd = new BigDecimal(bigPrice).setScale(2, HALF_UP);
            double price = bd.doubleValue();
            this.totalBasePrice = totalBasePrice + price;

            setPriceAndCheckCB();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addCustomHatToTotalPrice(String customID) {

        try {

            String query = "select price from hat join customhat on hat.HatID = customhat.StandardHat where CustomhatID = " + customID;
            double bigPrice = Double.parseDouble(idb.fetchSingle(query));
            bigPrice = bigPrice * 1.1;
            BigDecimal bd = new BigDecimal(bigPrice).setScale(2, HALF_UP);
            double price = bd.doubleValue();
            this.totalBasePrice = totalBasePrice + price;

            setPriceAndCheckCB();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void subtractHatFromTotalPrice(String hatName) {
        try {
            String query = "select price from hat where HatName = '" + hatName + "'";
            double bigPrice = Double.parseDouble(idb.fetchSingle(query));
            BigDecimal bd = new BigDecimal(bigPrice).setScale(2, HALF_UP);
            double price = bd.doubleValue();
            this.totalBasePrice = totalBasePrice - price;

            setPriceAndCheckCB();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void subtractCustomHatFromTotalPrice(String customID) {

        try {
            String query = "select price from hat join customhat on hat.HatID = customhat.StandardHat where CustomhatID = " + customID;
            double bigPrice = Double.parseDouble(idb.fetchSingle(query));
            System.out.println(bigPrice + "i");
            BigDecimal bd = new BigDecimal(bigPrice).setScale(2, HALF_UP);
            double price = bd.doubleValue();
            this.totalBasePrice = totalBasePrice - price * 1.1;

            setPriceAndCheckCB();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setPriceAndCheckCB() {
        if (chbExpress.isSelected()) {

            double expressPrice = this.totalBasePrice * 1.25;
            BigDecimal bd = new BigDecimal(expressPrice).setScale(2, HALF_UP);
            double price = bd.doubleValue();
            txtFieldPrice.setText(price + "");
        } else {
            BigDecimal bd = new BigDecimal(this.totalBasePrice).setScale(2, HALF_UP);
            double price = bd.doubleValue();
            txtFieldPrice.setText(price + "");
        }
    }

    /**
     * Metoden för att visa dagens datum i order.
     */
    void showDate() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        lblOrderDate.setText(s.format(d));
    }

    /**
     * Fyller labeln Inloggad som och tar in det namn som man loggat in som som
     * parameter
     */
    public static void lblLoggedIn(JLabel textbox, String username) {
        textbox.setText("Du är inloggad som " + username + ".");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbNewCustomer;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddHat;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCustom;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnSpecial;
    private javax.swing.JButton btnTaBortHatt;
    private javax.swing.JComboBox<String> cbBasic;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JCheckBox chbExpress;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlOrder;
    private javax.swing.JScrollPane jspOrder;
    private javax.swing.JLabel lblChooseHat;
    private javax.swing.JLabel lblDelivery;
    private javax.swing.JLabel lblHats;
    private javax.swing.JLabel lblLoggedIn;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblWarningPrice;
    private javax.swing.JTextField tfAdress;
    private javax.swing.JTextField txtFieldCity;
    private javax.swing.JTextArea txtFieldNote;
    private javax.swing.JTextField txtFieldPostalnmbr;
    private javax.swing.JTextField txtFieldPrice;
    // End of variables declaration//GEN-END:variables
}
