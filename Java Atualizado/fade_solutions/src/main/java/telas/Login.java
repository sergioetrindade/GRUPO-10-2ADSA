/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;


import funcionalidades.UsuarioValidacao;


public class Login extends javax.swing.JFrame {
 //Criando ojeto da classe UsuarioFuncionalidade
    
    UsuarioValidacao usuarioValid = new UsuarioValidacao();
    public Login() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        input_senha = new javax.swing.JPasswordField();
        txt_password = new javax.swing.JLabel();
        input_user = new javax.swing.JTextField();
        btn_entrar = new javax.swing.JButton();
        txt_user = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_sistema = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 43, 47));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel5.setBackground(new java.awt.Color(251, 207, 90));
        jPanel5.setLayout(null);

        input_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_senhaActionPerformed(evt);
            }
        });
        jPanel5.add(input_senha);
        input_senha.setBounds(123, 250, 234, 30);

        txt_password.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        txt_password.setText("Senha:");
        jPanel5.add(txt_password);
        txt_password.setBounds(210, 220, 57, 25);

        input_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_userActionPerformed(evt);
            }
        });
        jPanel5.add(input_user);
        input_user.setBounds(123, 167, 234, 31);

        btn_entrar.setBackground(new java.awt.Color(0, 0, 0));
        btn_entrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrar.setText("Login");
        btn_entrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_entrar.setBorderPainted(false);
        btn_entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_entrarMouseEntered(evt);
            }
        });
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });
        jPanel5.add(btn_entrar);
        btn_entrar.setBounds(190, 298, 110, 40);

        txt_user.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        txt_user.setText("E-MAIL:");
        jPanel5.add(txt_user);
        txt_user.setBounds(210, 130, 67, 25);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel1);
        jPanel1.setBounds(439, 0, 0, 424);

        txt_sistema.setBackground(new java.awt.Color(255, 255, 255));
        txt_sistema.setFont(new java.awt.Font("Malgun Gothic", 0, 24)); // NOI18N
        txt_sistema.setIcon(new javax.swing.ImageIcon("C:\\Users\\luiz.sousa\\Documents\\GitHub\\GRUPO-10-2ADSA\\projeto-site\\public\\img\\fade.png")); // NOI18N
        jPanel5.add(txt_sistema);
        txt_sistema.setBounds(140, 30, 200, 70);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Não possui cadastro ?");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(260, 360, 200, 40);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Esqueceu a senha ?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(41, 360, 190, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
            
        //Botão de login fazendo select no banco
        String login = input_user.getText();
        String senha = input_senha.getText();
        //Verificando se usuario existe no banco de dados
        Boolean usuarioLogado = usuarioValid.login(login, senha);

        if (usuarioLogado) {
            TelaPrincipal telaPrincipal = new TelaPrincipal(input_user.getText());
            telaPrincipal.setVisible(true);
            dispose();
        }
       
    }//GEN-LAST:event_btn_entrarActionPerformed

    private void input_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_senhaActionPerformed

    private void input_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_userActionPerformed

    private void btn_entrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_entrarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_entrarMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JPasswordField input_senha;
    private javax.swing.JTextField input_user;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel txt_password;
    private javax.swing.JLabel txt_sistema;
    private javax.swing.JLabel txt_user;
    // End of variables declaration//GEN-END:variables
}
