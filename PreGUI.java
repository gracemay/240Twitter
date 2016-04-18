/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterAssignment;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains the login, account creation, and public message viewing handlers
 * @author evan
 */
public class PreGUI extends javax.swing.JFrame
{

    /**
     * Creates new form PreGUI
     */
    public PreGUI()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        newUser = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        newUsername = new javax.swing.JTextField();
        newEmail = new javax.swing.JTextField();
        newDescription = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        publicMsgs = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        publicMessages = new javax.swing.JTextArea();
        publicRefresh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        createAccount = new javax.swing.JButton();
        error1 = new javax.swing.JLabel();
        viewPublic = new javax.swing.JButton();

        newUser.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        newUser.setTitle("Create Account");
        newUser.setResizable(false);
        newUser.setSize(new java.awt.Dimension(350, 225));
        newUser.setType(java.awt.Window.Type.NORMAL);
        newUser.addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                newUserWindowClosed(evt);
            }
        });
        newUser.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                newUserKeyPressed(evt);
            }
        });

        jLabel3.setText("Password");

        jLabel4.setText("Email");

        jLabel5.setText("Username");

        jLabel6.setText("Description");

        create.setText("Create Account");
        create.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newUserLayout = new javax.swing.GroupLayout(newUser.getContentPane());
        newUser.getContentPane().setLayout(newUserLayout);
        newUserLayout.setHorizontalGroup(
            newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newUserLayout.createSequentialGroup()
                .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newUserLayout.createSequentialGroup()
                        .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newUserLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newUserLayout.createSequentialGroup()
                                        .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(newUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                            .addComponent(newPassword)
                                            .addComponent(newEmail)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newUserLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(newUserLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(create)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        newUserLayout.setVerticalGroup(
            newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newUserLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(newUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(newEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(newDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(create)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        publicMsgs.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        publicMsgs.setTitle("Public Messages");
        publicMsgs.setSize(new java.awt.Dimension(557, 425));
        publicMsgs.addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                publicMsgsWindowClosed(evt);
            }
        });

        publicMessages.setEditable(false);
        publicMessages.setColumns(20);
        publicMessages.setLineWrap(true);
        publicMessages.setRows(5);
        publicMessages.setWrapStyleWord(true);
        jScrollPane1.setViewportView(publicMessages);

        publicRefresh.setText("Refresh");
        publicRefresh.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                publicRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout publicMsgsLayout = new javax.swing.GroupLayout(publicMsgs.getContentPane());
        publicMsgs.getContentPane().setLayout(publicMsgsLayout);
        publicMsgsLayout.setHorizontalGroup(
            publicMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicMsgsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(publicMsgsLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(publicRefresh)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        publicMsgsLayout.setVerticalGroup(
            publicMsgsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(publicMsgsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(publicRefresh)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel7.setText("Username");

        jLabel8.setText("Password");

        password.setMinimumSize(new java.awt.Dimension(12, 18));
        password.setPreferredSize(new java.awt.Dimension(62, 18));
        password.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                passwordKeyPressed(evt);
            }
        });

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loginActionPerformed(evt);
            }
        });

        createAccount.setText("Create Account");
        createAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                createAccountActionPerformed(evt);
            }
        });

        viewPublic.setText("View Public Messages");
        viewPublic.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewPublicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(login)
                                .addGap(18, 18, 18)
                                .addComponent(createAccount)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(username)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(viewPublic)
                        .addGap(36, 36, 36)
                        .addComponent(error1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(createAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPublic))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loginActionPerformed
    {//GEN-HEADEREND:event_loginActionPerformed
        String uname = username.getText();
        String pwd = String.valueOf(password.getPassword());
        
        
        boolean success = LogUserIn.checkLoginSuccess(Main.userList, uname, pwd);
        if (success)
        {
            Main.currentUser = LogUserIn.getUser(Main.userList, uname, pwd);
            GUI.start();
            
            this.setVisible(false);
            this.dispose();
        }
        else
        {
            error1.setForeground(Color.RED);
            error1.setText("Incorrect username/password");
        }
        
        
    }//GEN-LAST:event_loginActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_createAccountActionPerformed
    {//GEN-HEADEREND:event_createAccountActionPerformed
        newUsername.setText(username.getText());
        newPassword.setText(String.valueOf(password.getPassword()));
        
        original.setVisible(false);
        newUser.setVisible(true);
        error.setText("");
        newEmail.setText("");
        newDescription.setText("");
    }//GEN-LAST:event_createAccountActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_createActionPerformed
    {//GEN-HEADEREND:event_createActionPerformed
        String uname = newUsername.getText();
        String pwd = String.valueOf(newPassword.getPassword());
        String email = newEmail.getText();
        String description = newDescription.getText();
        
        if (!uname.isEmpty() && !pwd.isEmpty() && !email.isEmpty() && !description.isEmpty())
        {
            boolean exists = false;
            for (User u : Main.userList)
            {
                if (u.getUsername().equals(uname))
                {
                    error.setForeground(Color.RED);
                    error.setText("That username is already taken!");
                    exists = true;
                }
            }
            if (!exists)
            {
                User created = new User(uname, pwd, email, description, 0, 0, "", "");
                Main.userList.add(created);
                try
                {
                    LogUserIn.updateUserFile();
                } catch (IOException ex)
                {
                    Logger.getLogger(PreGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(PreGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                original.setVisible(true);
                username.setText("");
                password.setText("");
                newUser.dispose();
            }
        }
        else
        {
            error.setForeground(Color.RED);
            error.setText("All fields are required!");
        } 
    }//GEN-LAST:event_createActionPerformed

    private void newUserWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_newUserWindowClosed
    {//GEN-HEADEREND:event_newUserWindowClosed
        original.setVisible(true);
        error1.setText("");
    }//GEN-LAST:event_newUserWindowClosed

    private void viewPublicActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewPublicActionPerformed
    {//GEN-HEADEREND:event_viewPublicActionPerformed
        publicMsgs.setVisible(true);
        publicRefresh.doClick();
        this.setVisible(false);
    }//GEN-LAST:event_viewPublicActionPerformed

    private void publicMsgsWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_publicMsgsWindowClosed
    {//GEN-HEADEREND:event_publicMsgsWindowClosed
        original.setVisible(true);
    }//GEN-LAST:event_publicMsgsWindowClosed

    private void publicRefreshActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_publicRefreshActionPerformed
    {//GEN-HEADEREND:event_publicRefreshActionPerformed
        String toPrint = "";
        
        for (Message m : Main.messageList)
            if (!m.getPrivacy())
                toPrint += m.getUser() + "  on " + Main.sdfMessages.format(new Date(m.getDate())) + "\n" + m.getMessage() + "\n\n";
        publicMessages.setText(toPrint);
        
        
    }//GEN-LAST:event_publicRefreshActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_passwordKeyPressed
    {//GEN-HEADEREND:event_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            login.doClick();
    }//GEN-LAST:event_passwordKeyPressed

    private void newUserKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_newUserKeyPressed
    {//GEN-HEADEREND:event_newUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            create.doClick();
    }//GEN-LAST:event_newUserKeyPressed

    public static void start()
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Metal".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(PreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PreGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new PreGUI().setVisible(true);
            }
        });
    }

    public javax.swing.JFrame original = this;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JButton createAccount;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JTextField newDescription;
    private javax.swing.JTextField newEmail;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JDialog newUser;
    private javax.swing.JTextField newUsername;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextArea publicMessages;
    private javax.swing.JFrame publicMsgs;
    private javax.swing.JButton publicRefresh;
    private javax.swing.JTextField username;
    private javax.swing.JButton viewPublic;
    // End of variables declaration//GEN-END:variables
}