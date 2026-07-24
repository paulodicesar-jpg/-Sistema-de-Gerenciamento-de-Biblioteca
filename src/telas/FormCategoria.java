
package telas;

import classes.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

    public class FormCategoria extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCategoria.class.getName());
    ArrayList<Categoria> listaCategorias;
    
    public FormCategoria(java.awt.Frame parent, boolean modal,  ArrayList<Categoria> listaCategorias) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        
        this.listaCategorias = listaCategorias;
    }
    
    private Categoria encontrarCategoria(int codigo) {
        for (Categoria c : listaCategorias) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        btnAlteracao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnIncluir.setText("Inserir");
        btnIncluir.addActionListener(this::btnIncluirActionPerformed);

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        btnAlteracao.setText("Alterar");
        btnAlteracao.addActionListener(this::btnAlteracaoActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        jButton1.setText("Listar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        String nome = JOptionPane.showInputDialog(this, "Categoria (Restauração de páginas, Capa dura, Tratamento de fungos, etc) :");
        
        if (nome == null || nome.isBlank()) {
            JOptionPane.showMessageDialog(this, "Campo vazio");
        }

        String codigoStr = JOptionPane.showInputDialog(this, "Código da Categoria:");

        if (codigoStr != null) {
            try {
                int codigo = Integer.parseInt(codigoStr);

                Categoria nova = new Categoria(nome, codigo);
                listaCategorias.add(nova);

                JOptionPane.showMessageDialog(this, "Categoria '" + nome + "' salva com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Digite um número!");
            }
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteracaoActionPerformed
        try {

         int codigoBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da categoria que deseja alterar: "));

         Categoria c = encontrarCategoria(codigoBusca);

         if (c != null) {
            
             String novoNome = JOptionPane.showInputDialog("Digite o novo nome da categoria:", c.getNome());
 
             if (novoNome != null) {
                 c.setNome(novoNome);
                 JOptionPane.showMessageDialog(this, "Categoria atualizada com sucesso!");
             } else {
                 JOptionPane.showMessageDialog(this, "Alteração cancelada ou nome inválido.");
             }

         } else {
             JOptionPane.showMessageDialog(this, "Categoria não encontrada!");
         }
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: Digite apenas números válidos para o código!");
        }     
    }//GEN-LAST:event_btnAlteracaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            int codigoBusca = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código da categoria que deseja EXCLUIR:"));

            Categoria c = encontrarCategoria(codigoBusca);

            if (c != null) {
                listaCategorias.remove(c);
                JOptionPane.showMessageDialog(this, "Categoria removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Categoria não encontrada!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: Digite um número válido para o código!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        taSaida.setText("");
        String relatorio = "";
        for (Categoria c : listaCategorias) {
            relatorio += "Nome da categoria: " + c.getNome() + " - Código da categoria: " + c.getCodigo() + "\n";
        }
        taSaida.append(relatorio);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlteracao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    // End of variables declaration//GEN-END:variables

}