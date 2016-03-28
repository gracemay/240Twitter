/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterAssignment;

import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author evan
 */
public class GUI extends javax.swing.JFrame
{

    /**
     * Creates new form GUI
     */
    public GUI()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        post = new javax.swing.JTextArea();
        characters = new javax.swing.JLabel();
        postButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        msgs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Twitter");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(18);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        post.setColumns(20);
        post.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        post.setLineWrap(true);
        post.setRows(5);
        post.setWrapStyleWord(true);
        post.setAutoscrolls(false);
        post.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        post.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                postKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                postKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                postKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(post);

        characters.setText("0/140");

        postButton.setText("Post");
        postButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                postButtonActionPerformed(evt);
            }
        });

        msgs.setEditable(false);
        msgs.setColumns(20);
        msgs.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        msgs.setLineWrap(true);
        msgs.setRows(5);
        msgs.setWrapStyleWord(true);
        jScrollPane3.setViewportView(msgs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(postButton)
                    .addComponent(characters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(characters)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(postButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_postKeyTyped
    {//GEN-HEADEREND:event_postKeyTyped
        characters.setText(post.getText().length() + "/140");
        if (post.getText().length() > 140)
        {
            characters.setForeground(Color.RED);
            postButton.setVisible(false);characters.setForeground(Color.RED);
            postButton.setVisible(false);
        }
        else
        {
            characters.setForeground(Color.BLACK);
            postButton.setVisible(true);
        }
    }//GEN-LAST:event_postKeyTyped

    private void postKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_postKeyPressed
    {//GEN-HEADEREND:event_postKeyPressed
        characters.setText(post.getText().length() + "/140");
        if (post.getText().length() > 140)
        {
            characters.setForeground(Color.RED);
            postButton.setVisible(false);
        }
        else
        {
            characters.setForeground(Color.BLACK);
            postButton.setVisible(true);
        }
    }//GEN-LAST:event_postKeyPressed

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_postButtonActionPerformed
    {//GEN-HEADEREND:event_postButtonActionPerformed
//        msgs.append("--------------------\n" + post.getText());
        String user = String.format("%1$34s", "@RandomUser");
        if (!msgs.getText().equals(""))
            msgs.setText(user + "\n" + post.getText() + "\n--------------------\n" + msgs.getText());
        else
            msgs.setText(post.getText());
        post.setText("");
    }//GEN-LAST:event_postButtonActionPerformed

    private void postKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_postKeyReleased
    {//GEN-HEADEREND:event_postKeyReleased
        characters.setText(post.getText().length() + "/140");
        if (post.getText().length() > 140)
        {
            characters.setForeground(Color.RED);
            postButton.setVisible(false);
        }
        else
        {
            characters.setForeground(Color.BLACK);
            postButton.setVisible(true);
        }
    }//GEN-LAST:event_postKeyReleased

    /**
     * @param args the command line arguments
     */
    public void start()
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
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel characters;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea msgs;
    private javax.swing.JTextArea post;
    private javax.swing.JButton postButton;
    // End of variables declaration//GEN-END:variables
}
