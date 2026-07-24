
package telas;

import classes.*;
import java.util.ArrayList;

public class FormPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPrincipal.class.getName());
    
    final ArrayList<Auxiliar> listaAuxiliares = new ArrayList();
    final ArrayList<Bibliotecario> listaBibio = new ArrayList();
    final ArrayList<Obra> listaObras = new ArrayList();
    final ArrayList<Autor> listaAutores = new ArrayList();
    final ArrayList<Categoria> listaCategorias = new ArrayList();
    final ArrayList<FichaConservacao> listaFichas = new ArrayList();
    final ArrayList<Leitor> listaLeitores = new ArrayList();
    final ArrayList<Emprestimo> listaEmprestimo = new ArrayList();
    
    public FormPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        inserirDireto();
        listarDireto();
    }
    
    public void inserirDireto() {
    listaAutores.add(new Autor("Machado de Assis", "Brasileiro"));
    listaAutores.add(new Autor("J.K. Rowling", "Britânica"));

    listaBibio.add(new Bibliotecario(2, "Joao", "11111111", 123, "Jornalista"));
    listaBibio.add(new Bibliotecario(3, "Paulo", "1293983", 456, "Professor"));
    
    listaAuxiliares.add(new Auxiliar(5, "Gabriely", "10000","Manha"));
    listaAuxiliares.add(new Auxiliar(4, "Marlon", "99999","Tarde"));
    
    Obra obra1 = new Obra("Dom Casmurro", "Editora Nacional", 444444, 1899);
    obra1.getAutores().add(listaAutores.get(0));
    listaObras.add(obra1);
    
    Obra obra2 = new Obra("Harry Potter", "Rocco", 55555, 1997);
    obra2.getAutores().add(listaAutores.get(1));
    listaObras.add(obra2);
    
    taSaida.setText("==== LEITORES ====");
    
    listaLeitores.add(new Leitor(111222, "Madianita Bogo"));
    listaLeitores.add(new Leitor(333333, "Jackson Gomes"));
    listaLeitores.add(new Leitor(444444, "Fabiano Fagundes"));
    listaLeitores.add(new Leitor(555555, "Fernanda Pereira"));
    listaLeitores.add(new Leitor(666666, "Parcilene Brito"));
    listaLeitores.add(new Leitor(777777, "Kênia Mendonça"));
    listaLeitores.add(new Leitor(888888, "Marianne Lacerda"));
    listaLeitores.add(new Leitor(999999, "Robson Gomes"));
    listaLeitores.add(new Leitor(112233, "Lucas Vinicíus"));
    listaLeitores.add(new Leitor(332211, "Douglas Aquino"));
}
    
    public void listarDireto () {
    taSaida.setText("=== RELATÓRIO DA BIBLIOTECA ===\n\n");

    taSaida.append("--- OBRAS ---\n");
    for (Obra o : listaObras) {
        taSaida.append(o.toString() + "\n");
    }

    taSaida.append("\n--- COLABORADORES ---\n");
    
    for (Bibliotecario b : listaBibio) {
        taSaida.append(b.toString() + "\n");
    }
    
    for (Auxiliar a : listaAuxiliares) {
        taSaida.append(a.toString() + "\n");
    }
    
    taSaida.append("\n--- LEITORES ---\n");
    
    for (Leitor l : listaLeitores) {
        taSaida.append(l.toString() + "\n");
    }   
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        btnInclusao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnEmprestimos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        btnInclusao.setText("Gerenciar Colabores");
        btnInclusao.addActionListener(this::btnInclusaoActionPerformed);

        jButton1.setText("Gerenciar Acervo");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Listar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Gerenciar Categorias");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Gerenciar Fichas");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        btnEmprestimos.setText("Gerenciar Emprestimos");
        btnEmprestimos.addActionListener(this::btnEmprestimosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEmprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInclusao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInclusao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmprestimos)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInclusaoActionPerformed
        FormBibliotecario telaColaborador = new FormBibliotecario(this, rootPaneCheckingEnabled, listaAuxiliares, listaBibio);
        telaColaborador.setVisible(true);
    }//GEN-LAST:event_btnInclusaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         listarDireto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormObras telaObras = new FormObras(this, rootPaneCheckingEnabled, listaObras, listaAutores);
        telaObras.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       FormCategoria telaCategoria = new FormCategoria(this, rootPaneCheckingEnabled, listaCategorias);
       telaCategoria.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FormFichas telaFichas = new FormFichas(this, rootPaneCheckingEnabled, listaObras, listaCategorias, listaFichas, listaBibio);
        telaFichas.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimosActionPerformed
        FormEmprestimo telaEmprestimo = new FormEmprestimo(this, rootPaneCheckingEnabled, listaLeitores, listaEmprestimo, listaObras);
        telaEmprestimo.setVisible(true);
    }//GEN-LAST:event_btnEmprestimosActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmprestimos;
    private javax.swing.JButton btnInclusao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    // End of variables declaration//GEN-END:variables
}
