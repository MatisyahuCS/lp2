import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lp2.controller.UsuarioJpaController;
import lp2.controller.exceptions.NonexistentEntityException;
import lp2.model.Usuario;
import lp2.persistence.PersistenceSingleton;


public class Principal extends javax.swing.JFrame {

    EntityManagerFactory ponte = PersistenceSingleton.getInstance().getEntityManagerFactory();
    UsuarioJpaController usuController = new UsuarioJpaController(ponte);

    
    public Principal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        inputCpf = new javax.swing.JTextField();
        inputLogin = new javax.swing.JTextField();
        buttonSalvar = new javax.swing.JButton();
        buttonRemover = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputCpf.setText("CPF");
        inputCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputCpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputCpfFocusLost(evt);
            }
        });
        inputCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCpfActionPerformed(evt);
            }
        });

        inputLogin.setText("Login");
        inputLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputLoginFocusLost(evt);
            }
        });
        inputLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLoginActionPerformed(evt);
            }
        });

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "Login "
            }
        ));
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputCpf)
                            .addComponent(inputLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addComponent(buttonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonRemover)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAtualizar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonRemover)
                    .addComponent(buttonAtualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void inputCpfActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void inputCpfFocusGained(java.awt.event.FocusEvent evt) {                                     
        // TODO add your handling code here:
        inputCpf.setText("");
    }                                    

    private void inputLoginFocusGained(java.awt.event.FocusEvent evt) {                                       
        // TODO add your handling code here:
        inputLogin.setText("");
    }                                      

    private void inputLoginActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void inputLoginFocusLost(java.awt.event.FocusEvent evt) {                                     
        // TODO add your handling code here:
        if (inputLogin.getText().equals("")) {
            inputLogin.setText("Login");
        }
    }                                    

    private void inputCpfFocusLost(java.awt.event.FocusEvent evt) {                                   
        // TODO add your handling code here:
        if (inputCpf.getText().equals("")) {
            inputCpf.setText("CPF");
        }
    }                                  

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        String cpf, login;
        cpf = inputCpf.getText();
        login = inputLogin.getText();

        Usuario user = new Usuario();
        if (cpf.equals("CPF") || login.equals("Login")) {
            JOptionPane.showMessageDialog(this, "Campo CPF e Login são de preenchimento obrigatório");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tableUsuarios.getModel();
            
            inputCpf.setText("CPF");
            inputLogin.setText("Login");
            user.setCpf(cpf);
            user.setLogin(login);
            usuController.create(user);
            dtm.addRow(new String[]{user.getId().toString(), cpf, login});
        }
    }                                            

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tableUsuarios.getModel();
        int rowSelected = tableUsuarios.getSelectedRow();

        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "Selecione a linha que deseja remover");
        } else {
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover a linha selecionada?", "Confirme a sua operação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                dtm.removeRow(rowSelected);
            }
        }
    }                                             

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
        
    }                                          

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tableUsuarios.getModel();
        int numRows = dtm.getRowCount();

        for (int i = 0; i < numRows; i++) {
            String cpf = dtm.getValueAt(i, 0).toString();
            String login = dtm.getValueAt(i, 1).toString();

            dtm.setValueAt(login + "-atualizado", i, 1);

            JOptionPane.showMessageDialog(this, "CPF e login: " + cpf + ", " + login);
        }
    }                                               

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JTextField inputCpf;
    private javax.swing.JTextField inputLogin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration                   
}
