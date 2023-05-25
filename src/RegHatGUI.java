
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import oru.inf.InfDB;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import oru.inf.InfException;

public class RegHatGUI extends javax.swing.JFrame {

    private String username;

    public static InfDB idb;
    private byte[] choosenImage;
    private ArrayList<String> colours;
    private ArrayList<String> materials;
    private PlaceOrderGUI orderPage;

    /**
     * Creates new form RegHatGUI
     */
    public RegHatGUI(String username) {
        idb = HattmakarnaStudio.getDatabase();
        initComponents();
        colours = new ArrayList<>();
        materials = new ArrayList<>();
        orderPage = null;
        choosenImage = null;

        //Denna kod gör så att nya fönster öppnas i mitten av skärmen
        this.setLocationRelativeTo(null);

        //Denna kod gör så att programmet inte stängs när fönster stängs
        RegHatGUI.this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.username = username;
        this.lblLoggedIn(lblLoggedIn, username);
    }

    public RegHatGUI(PlaceOrderGUI orderPage, String username) {
        idb = HattmakarnaStudio.getDatabase();
        initComponents();
        colours = new ArrayList<>();
        materials = new ArrayList<>();
        chbSpecial.setSelected(true);
        choosenImage = null;

        //Denna kod gör så att nya fönster öppnas i mitten av skärmen
        this.setLocationRelativeTo(null);

        //Denna kod gör så att programmet inte stängs när fönster stängs
        RegHatGUI.this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.username = username;
        this.lblLoggedIn(lblLoggedIn, username);
        this.orderPage = orderPage;
    }

    RegHatGUI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLoggedIn = new javax.swing.JLabel();
        txtHatName = new javax.swing.JTextField();
        lblHatName = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        chbSpecial = new javax.swing.JCheckBox();
        scrollNote = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        lblNote = new javax.swing.JLabel();
        btnChoosePic = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSaveNewHat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        boxBomull = new javax.swing.JCheckBox();
        boxNylon = new javax.swing.JCheckBox();
        boxPolyester = new javax.swing.JCheckBox();
        boxFleece = new javax.swing.JCheckBox();
        boxSilke = new javax.swing.JCheckBox();
        boxKashmir = new javax.swing.JCheckBox();
        boxStra = new javax.swing.JCheckBox();
        boxLader = new javax.swing.JCheckBox();
        boxLinne = new javax.swing.JCheckBox();
        boxUll = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        boxVit = new javax.swing.JCheckBox();
        boxGra = new javax.swing.JCheckBox();
        boxBrun = new javax.swing.JCheckBox();
        boxBeige = new javax.swing.JCheckBox();
        boxRosa = new javax.swing.JCheckBox();
        boxSvart = new javax.swing.JCheckBox();
        boxLila = new javax.swing.JCheckBox();
        boxBla = new javax.swing.JCheckBox();
        boxGron = new javax.swing.JCheckBox();
        boxGul = new javax.swing.JCheckBox();
        boxOrange = new javax.swing.JCheckBox();
        boxRod = new javax.swing.JCheckBox();
        lblPic = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 148, 200));

        lblLoggedIn.setText("Inloggad som");

        lblHatName.setText("Hattnamn:");

        lblPrice.setText("Pris:");

        chbSpecial.setText("Specialhatt");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        scrollNote.setViewportView(txtNote);

        lblNote.setText("Anteckning:");

        btnChoosePic.setText("Välj bild");
        btnChoosePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePicActionPerformed(evt);
            }
        });

        btnBack.setText("Tillbaka");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSaveNewHat.setText("Spara");
        btnSaveNewHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNewHatActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        boxBomull.setText("Bomull");
        boxBomull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBomullActionPerformed(evt);
            }
        });

        boxNylon.setText("Nylon");

        boxPolyester.setText("Polyester");

        boxFleece.setText("Fleece");

        boxSilke.setText("Silke");

        boxKashmir.setText("Ull");

        boxStra.setText("Kashmir");

        boxLader.setText("Strå");

        boxLinne.setText("Läder");

        boxUll.setText("Linne");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(boxBomull)
                        .addGap(18, 18, 18)
                        .addComponent(boxStra))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxPolyester)
                            .addComponent(boxFleece)
                            .addComponent(boxSilke)
                            .addComponent(boxNylon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxLader)
                            .addComponent(boxKashmir)
                            .addComponent(boxUll)
                            .addComponent(boxLinne))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxBomull)
                    .addComponent(boxStra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxNylon)
                    .addComponent(boxLader))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxPolyester)
                    .addComponent(boxLinne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxFleece)
                    .addComponent(boxUll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxSilke)
                    .addComponent(boxKashmir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        boxVit.setText("Vit");

        boxGra.setText("Grå");

        boxBrun.setText("Brun");

        boxBeige.setText("Beige");

        boxRosa.setText("Rosa");

        boxSvart.setText("Svart");
        boxSvart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSvartActionPerformed(evt);
            }
        });

        boxLila.setText("Lila");

        boxBla.setText("Blå");
        boxBla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBlaActionPerformed(evt);
            }
        });

        boxGron.setText("Grön");

        boxGul.setText("Gul");

        boxOrange.setText("Orange");

        boxRod.setText("Röd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(boxRosa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxRod))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(boxSvart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxLila))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxBrun)
                            .addComponent(boxBeige))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxOrange)
                            .addComponent(boxGul)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxGra)
                            .addComponent(boxVit))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxBla)
                            .addComponent(boxGron))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxVit)
                    .addComponent(boxBla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxGra)
                    .addComponent(boxGron))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxBrun)
                    .addComponent(boxGul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxBeige)
                    .addComponent(boxOrange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxRosa)
                    .addComponent(boxRod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxSvart)
                    .addComponent(boxLila))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        jLabel1.setText("Registrera ny hatt");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoggedIn)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnSaveNewHat)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnChoosePic)
                                    .addGap(105, 105, 105))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollNote, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack)
                                        .addComponent(lblNote, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(107, 107, 107)))
                            .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblHatName, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHatName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chbSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblLoggedIn)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblHatName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHatName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice)
                                .addGap(3, 3, 3)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chbSpecial))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(lblNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(scrollNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChoosePic)
                            .addComponent(btnSaveNewHat))
                        .addGap(16, 16, 16)
                        .addComponent(btnBack))
                    .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveNewHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNewHatActionPerformed

        try {
            JCheckBox[] mCheckboxes = new JCheckBox[10];
            mCheckboxes[0] = boxBomull;
            mCheckboxes[1] = boxNylon;
            mCheckboxes[2] = boxPolyester;
            mCheckboxes[3] = boxFleece;
            mCheckboxes[4] = boxSilke;
            mCheckboxes[5] = boxKashmir;
            mCheckboxes[6] = boxStra;
            mCheckboxes[7] = boxLader;
            mCheckboxes[8] = boxLinne;
            mCheckboxes[9] = boxUll;

            for (JCheckBox mOneBox : mCheckboxes) {
                if (mOneBox.isSelected()) {
                    materials.add(mOneBox.getText());
                }
            }

            JCheckBox[] cCheckboxes = new JCheckBox[12];
            cCheckboxes[0] = boxVit;
            cCheckboxes[1] = boxGra;
            cCheckboxes[2] = boxBrun;
            cCheckboxes[3] = boxBeige;
            cCheckboxes[4] = boxRosa;
            cCheckboxes[5] = boxSvart;
            cCheckboxes[6] = boxBla;
            cCheckboxes[7] = boxGron;
            cCheckboxes[8] = boxGul;
            cCheckboxes[9] = boxOrange;
            cCheckboxes[10] = boxRod;
            cCheckboxes[11] = boxLila;

            for (JCheckBox oneBox : cCheckboxes) {
                if (oneBox.isSelected()) {
                    colours.add(oneBox.getText());
                }
            }

            if (!Validation.checkEmpty(txtPrice) || !Validation.checkEmpty(txtHatName)) {
            } 
            
            else if (choosenImage == null || colours.isEmpty() || materials.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Du har inte fyll i alla nödvändiga uppgifter");
                System.out.println("n");
            } 
            
            else {

                String name = txtHatName.getText();
                double price = Double.parseDouble(txtPrice.getText());
                String note = txtNote.getText();
                String isSpecial = "";

                if (chbSpecial.isSelected()) {
                    isSpecial = "1";
                } else {
                    isSpecial = "0";
                }

                if (Validation.chechIfHatDoesNotExist(txtHatName)) {
                    Hat newHat = new Hat(name, price, note, choosenImage, isSpecial, colours, materials);

                    if (this.orderPage != null) {
                        orderPage.emptyHats();
                        orderPage.fillHats();
                        this.dispose();
                    }

                    if (this.orderPage == null) {
                        new RegHatGUI(username).setVisible(true);
                        dispose();
                    }
                }
            }
        }
                catch (InfException ex) {
              Logger.getLogger(RegHatGUI.class.getName()).log(Level.SEVERE, null, ex);
          }
               
                   
    }//GEN-LAST:event_btnSaveNewHatActionPerformed

    private void btnChoosePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePicActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Bildfiler", "jpg", "png", "jpeg", "gif");
        chooser.setFileFilter(filter);
        chooser.showOpenDialog(null);

        //Validation.checkEmpty(txtHatName);
        //Validation.checkEmpty(txtPrice);
        //Validation.checkEmptyArea(txtNote);
        File selectedFile = chooser.getSelectedFile();

        try {

            choosenImage = new byte[(int) selectedFile.length()];
            FileInputStream fis = new FileInputStream(selectedFile);
            fis.read(choosenImage);

            ImageIcon imageI = new ImageIcon(choosenImage);
            Image image1 = imageI.getImage().getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image1);
            lblPic.setIcon(scaledIcon);

        } catch (Exception ex) {
            Logger.getLogger(RegHatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnChoosePicActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (orderPage != null) {
            this.dispose();
        } else {
            new HatPageGUI(username).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void boxBlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBlaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_boxBlaActionPerformed

    private void boxSvartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSvartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSvartActionPerformed

    private void boxBomullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBomullActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxBomullActionPerformed

    /**
     * Fyller labeln Inloggad som och tar in det namn som man loggat in som som
     * parameter
     *
     * @param textbox
     * @param username
     */
    public static void lblLoggedIn(JLabel textbox, String username) {
        textbox.setText("Du är inloggad som " + username + ".");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxBeige;
    private javax.swing.JCheckBox boxBla;
    private javax.swing.JCheckBox boxBomull;
    private javax.swing.JCheckBox boxBrun;
    private javax.swing.JCheckBox boxFleece;
    private javax.swing.JCheckBox boxGra;
    private javax.swing.JCheckBox boxGron;
    private javax.swing.JCheckBox boxGul;
    private javax.swing.JCheckBox boxKashmir;
    private javax.swing.JCheckBox boxLader;
    private javax.swing.JCheckBox boxLila;
    private javax.swing.JCheckBox boxLinne;
    private javax.swing.JCheckBox boxNylon;
    private javax.swing.JCheckBox boxOrange;
    private javax.swing.JCheckBox boxPolyester;
    private javax.swing.JCheckBox boxRod;
    private javax.swing.JCheckBox boxRosa;
    private javax.swing.JCheckBox boxSilke;
    private javax.swing.JCheckBox boxStra;
    private javax.swing.JCheckBox boxSvart;
    private javax.swing.JCheckBox boxUll;
    private javax.swing.JCheckBox boxVit;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChoosePic;
    private javax.swing.JButton btnSaveNewHat;
    private javax.swing.JCheckBox chbSpecial;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblHatName;
    private javax.swing.JLabel lblLoggedIn;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JScrollPane scrollNote;
    private javax.swing.JTextField txtHatName;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
