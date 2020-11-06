package interfaz;

import javax.swing.JOptionPane;

public class WindowLogin extends javax.swing.JFrame {

    public WindowLogin() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        pasword = new javax.swing.JPasswordField();
        loginAccept = new javax.swing.JButton();
        textMemberlogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        pasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paswordActionPerformed(evt);
            }
        });

        loginAccept.setText("Ingresar");
        loginAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAcceptActionPerformed(evt);
            }
        });

        textMemberlogin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        textMemberlogin.setText("MEMBER LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(textMemberlogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(loginAccept))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pasword, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textMemberlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pasword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginAccept)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void paswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paswordActionPerformed

    //cambia la ventana de acuerdo al usuario que ingresa a la aplicación
    private void loginAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAcceptActionPerformed
        int windowNumber = 0;
        String inUsername = username.getText();
        char[] in = pasword.getPassword();
        String inPasword = new String(in);
        if(inUsername.length() > 0 && inPasword.length() > 0){
            if(windowNumber == 1){
                WindowPharmacyManager window = new WindowPharmacyManager();
                window.setVisible(true);
                dispose();
            }else{
                if(windowNumber == 2){
                    WindowSeller window = new WindowSeller();
                    window.setVisible(true);
                    dispose();
                }else{
                    if(windowNumber == 3){
                        WindowWarehouseManager window = new WindowWarehouseManager();
                        window.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }        
            }
        }else{
            JOptionPane.showMessageDialog(null, "Datos Erroneos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginAcceptActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginAccept;
    private javax.swing.JPasswordField pasword;
    private javax.swing.JLabel textMemberlogin;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
