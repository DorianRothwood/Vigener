/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Vigener.KeyTable;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 *
 * @author Michael Roth
 */
public class GUIFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public GUIFrame() {
        
        setFocusable(true);
        initComponents();
        keyTable.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MethodGroup = new javax.swing.ButtonGroup();
        keyTable = new GUI.TableKey();
        keyWindow = new GUI.KeyWindow();
        keyTableLabel = new javax.swing.JLabel();
        keyWindowLabel = new javax.swing.JLabel();
        keyField = new javax.swing.JTextField();
        keyTableKeyField = new javax.swing.JTextField();
        keyFieldLabel = new javax.swing.JLabel();
        keyChangeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        originalTextArea = new javax.swing.JTextArea();
        originalTextAreaLabel = new javax.swing.JLabel();
        encryptedTextAreaLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        encryptedTextArea = new javax.swing.JTextArea();
        EncryptionMethodLabel = new javax.swing.JLabel();
        AutomaticButton = new javax.swing.JRadioButton();
        ManualButton = new javax.swing.JRadioButton();
        keyTableKeyFieldLabel = new javax.swing.JLabel();
        keyTableKeyButton = new javax.swing.JButton();
        EncryptButton = new javax.swing.JButton();
        DecryptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vigener Encrypter");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        keyTable.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        keyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyTableMouseClicked(evt);
            }
        });
        keyTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyTableKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout keyTableLayout = new javax.swing.GroupLayout(keyTable);
        keyTable.setLayout(keyTableLayout);
        keyTableLayout.setHorizontalGroup(
            keyTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        keyTableLayout.setVerticalGroup(
            keyTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );

        keyWindow.setTableKey(keyTable);

        javax.swing.GroupLayout keyWindowLayout = new javax.swing.GroupLayout(keyWindow);
        keyWindow.setLayout(keyWindowLayout);
        keyWindowLayout.setHorizontalGroup(
            keyWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        keyWindowLayout.setVerticalGroup(
            keyWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        keyTableLabel.setText("Keying table");

        keyWindowLabel.setText("Upcomming keys");

        keyField.setText("Key");
        keyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyFieldActionPerformed(evt);
            }
        });

        keyTableKeyField.setText("Table Key");

        keyFieldLabel.setText("Cipher key");

        keyChangeButton.setText("Change key");
        keyChangeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyChangeButtonMouseClicked(evt);
            }
        });
        keyChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyChangeButtonActionPerformed(evt);
            }
        });

        originalTextArea.setEditable(false);
        originalTextArea.setColumns(20);
        originalTextArea.setRows(5);
        originalTextArea.setOpaque(false);
        originalTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                originalTextAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(originalTextArea);

        originalTextAreaLabel.setText("Original text");

        encryptedTextAreaLabel.setText("Encrypted text");

        encryptedTextArea.setEditable(false);
        encryptedTextArea.setColumns(20);
        encryptedTextArea.setRows(5);
        encryptedTextArea.setOpaque(false);
        encryptedTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encryptedTextAreaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(encryptedTextArea);

        EncryptionMethodLabel.setText("Encryption method");

        MethodGroup.add(AutomaticButton);
        AutomaticButton.setText("Automatic");
        AutomaticButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutomaticButtonActionPerformed(evt);
            }
        });

        MethodGroup.add(ManualButton);
        ManualButton.setSelected(true);
        ManualButton.setText("Manual");
        ManualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualButtonActionPerformed(evt);
            }
        });

        keyTableKeyFieldLabel.setText("Table key");

        keyTableKeyButton.setText("Change key");
        keyTableKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyTableKeyButtonActionPerformed(evt);
            }
        });

        EncryptButton.setText("Encrypt");
        EncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButtonActionPerformed(evt);
            }
        });

        DecryptButton.setText("Decrypt");
        DecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyTableLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyFieldLabel)
                    .addComponent(keyTableKeyFieldLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(originalTextAreaLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(encryptedTextAreaLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(keyWindowLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(keyWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(keyField)
                                .addComponent(keyTableKeyField))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(EncryptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DecryptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(keyTableKeyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(keyChangeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(EncryptionMethodLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AutomaticButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ManualButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyTableLabel)
                    .addComponent(originalTextAreaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encryptedTextAreaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyWindowLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(keyWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(EncryptButton)
                                .addComponent(DecryptButton)))
                        .addGap(8, 8, 8)
                        .addComponent(keyFieldLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyChangeButton)
                            .addComponent(keyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyTableKeyFieldLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyTableKeyButton)
                            .addComponent(keyTableKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EncryptionMethodLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AutomaticButton)
                            .addComponent(ManualButton))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyFieldActionPerformed

    private void ManualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualButtonActionPerformed
        originalTextArea.setText("");
        encryptedTextArea.setText("");
        originalTextArea.setEditable(false);
        encryptedTextArea.setEditable(false);
        originalTextArea.setOpaque(false);
        encryptedTextArea.setOpaque(false);
        keyTable.setManual(true);
        keyWindow.setManual(true);
        this.manual = true;
        keyTable.requestFocusInWindow();
    }//GEN-LAST:event_ManualButtonActionPerformed

    private void keyChangeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyChangeButtonMouseClicked
        
    }//GEN-LAST:event_keyChangeButtonMouseClicked

    private void keyTableKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyTableKeyButtonActionPerformed
        originalTextArea.setText("");
        encryptedTextArea.setText("");
        if(!"Table Key".equals(keyTableKeyField.getText())) {
            keyTable.setKey(keyTableKeyField.getText());
            keyTable.setYKey(keyTable.getTableKey().indexOf(Character.toString(keyWindow.getCurrentKey()).toUpperCase()));
        } // end if()
        if(manual) keyTable.requestFocusInWindow();;
    }//GEN-LAST:event_keyTableKeyButtonActionPerformed

    private void AutomaticButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutomaticButtonActionPerformed
        originalTextArea.setText("");
        encryptedTextArea.setText("");
        originalTextArea.setEditable(true);
        encryptedTextArea.setEditable(true);
        originalTextArea.setOpaque(true);
        encryptedTextArea.setOpaque(true);
        keyTable.setManual(false);
        keyWindow.setManual(false);
        this.manual = false;
    }//GEN-LAST:event_AutomaticButtonActionPerformed

    private void keyChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyChangeButtonActionPerformed
        originalTextArea.setText("");
        encryptedTextArea.setText("");
        if(!"Key".equals(keyField.getText())) {
            keyTable.setHasKey(true);
            keyWindow.setKey(KeyTable.process(keyField.getText(),false));
            keyTable.setYKey(keyTable.getTableKey().indexOf(Character.toString(keyWindow.getCurrentKey()).toUpperCase()));
        } // end if()
        if(manual) keyTable.requestFocusInWindow();
    }//GEN-LAST:event_keyChangeButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.println("rg");
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        System.out.println("gr");
    }//GEN-LAST:event_formKeyReleased

    private void keyTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyTableKeyPressed
        System.out.println("pressed");
    }//GEN-LAST:event_keyTableKeyPressed

    private void keyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyTableMouseClicked
        keyTable.requestFocusInWindow();
    }//GEN-LAST:event_keyTableMouseClicked

    private void EncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButtonActionPerformed
        if(!manual)
            encryptedTextArea.setText(Vigener.Encrypter.encrypt(originalTextArea.getText(),keyWindow.getKey(),keyTable.getTableKey()));
        else
            keyTable.requestFocusInWindow();
    }//GEN-LAST:event_EncryptButtonActionPerformed

    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed
        if(!manual) 
            originalTextArea.setText(Vigener.Decrypter.decrypt(encryptedTextArea.getText(),keyWindow.getKey(),keyTable.getTableKey()));
        else 
            keyTable.requestFocusInWindow();
    }//GEN-LAST:event_DecryptButtonActionPerformed

    private void originalTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_originalTextAreaMouseClicked
        if(manual) keyTable.requestFocusInWindow();
    }//GEN-LAST:event_originalTextAreaMouseClicked

    private void encryptedTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encryptedTextAreaMouseClicked
        if(manual) keyTable.requestFocusInWindow();
    }//GEN-LAST:event_encryptedTextAreaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIFrame().setVisible(true);
            }
        });
    }
    private boolean manual = true;
    private boolean isKeyPressed;
    private boolean shift;
    private Integer keyPressed;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AutomaticButton;
    private javax.swing.JButton DecryptButton;
    private javax.swing.JButton EncryptButton;
    private javax.swing.JLabel EncryptionMethodLabel;
    private javax.swing.JRadioButton ManualButton;
    private javax.swing.ButtonGroup MethodGroup;
    private javax.swing.JTextArea encryptedTextArea;
    private javax.swing.JLabel encryptedTextAreaLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton keyChangeButton;
    private javax.swing.JTextField keyField;
    private javax.swing.JLabel keyFieldLabel;
    private GUI.TableKey keyTable;
    private javax.swing.JButton keyTableKeyButton;
    private javax.swing.JTextField keyTableKeyField;
    private javax.swing.JLabel keyTableKeyFieldLabel;
    private javax.swing.JLabel keyTableLabel;
    private GUI.KeyWindow keyWindow;
    private javax.swing.JLabel keyWindowLabel;
    private javax.swing.JTextArea originalTextArea;
    private javax.swing.JLabel originalTextAreaLabel;
    // End of variables declaration//GEN-END:variables
}
