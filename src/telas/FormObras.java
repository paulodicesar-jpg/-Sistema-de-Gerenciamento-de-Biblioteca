
package telas;

import classes.Autor;
import classes.Categoria;
import classes.Obra;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FormObras extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormObras.class.getName());
    ArrayList<Obra> listaObras;
    ArrayList<Autor> listaAutores;
    
    public FormObras(java.awt.Frame parent, boolean modal,  ArrayList<Obra> listaObras, ArrayList<Autor> listaAutores) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        
        this.listaObras = listaObras;
        this.listaAutores = listaAutores;
    }

    FormObras(FormPrincipal aThis, boolean rootPaneCheckingEnabled, ArrayList<Categoria> listaCategorias) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Obra encontrarObra (int isbn) {
        for (Obra b : listaObras) {
            if (b.getISBN() == isbn) {
                return b;
            }
        } 
        return null;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        btnInserir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(this::btnInserirActionPerformed);

        jButton1.setText("Alterar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Listar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Excluir");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        String titulo = JOptionPane.showInputDialog("Digite o título da obra: ");
        String editora = JOptionPane.showInputDialog("Digite o nome da editora: ");

        if (titulo == null || titulo.isBlank() || editora == null || editora.isBlank()) {
            JOptionPane.showMessageDialog(null, "Título e Editora são obrigatórios!");
            return;
        }

        try {
            int isbn = Integer.parseInt(JOptionPane.showInputDialog("Digite o número ISBN: "));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de publicação: "));

            Obra novaObra = new Obra(titulo, editora, isbn, ano);

            String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor: ");
            String nacionalidade = JOptionPane.showInputDialog("Digite a nacionalidade: ");

            if (nomeAutor == null || nomeAutor.isBlank()) {
                JOptionPane.showMessageDialog(null, "O nome do autor é obrigatório!");
                return; 
            }

            Autor a = new Autor(nomeAutor, nacionalidade);
            novaObra.getAutores().add(a);

            listaObras.add(novaObra);
            JOptionPane.showMessageDialog(null, "Obra cadastrada com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: ISBN e Ano devem conter apenas números!");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int alteracao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN da obra que deseja alterar: "));

            Obra b = encontrarObra(alteracao);

            if (b != null) {
                b.setTituloObra(JOptionPane.showInputDialog("Digite o novo nome da obra:", b.getTituloObra()));
                b.setEditora(JOptionPane.showInputDialog("Digite o novo nome da editora:", b.getEditora()));

                
                b.setISBN(Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ISBN:", b.getISBN())));
                b.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano de publicação:", b.getAno())));

                String novoNomeAutor = JOptionPane.showInputDialog("Digite o nome do novo autor:");
                String novaNacionalidade = JOptionPane.showInputDialog("Digite a nacionalidade:");

                Autor novoAutor = new Autor(novoNomeAutor, novaNacionalidade);

                b.getAutores().clear(); 
                b.getAutores().add(novoAutor);

                JOptionPane.showMessageDialog(null, "Obra e autores atualizados com sucesso!"); 
            } else {
                JOptionPane.showMessageDialog(null, "Obra não encontrada!");   
            }        

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite apenas números válidos!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        taSaida.setText("===== LISTA OBRAS ===="+ "\n");
        for (Obra b : listaObras) {
            taSaida.append("   " + b.toString() + "\n");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int isbn = Integer.parseInt(JOptionPane.showInputDialog("Digite o número ISBN da obra que deseja excluir:"));
        
        Obra b = encontrarObra(isbn);
        if (b != null) {
            listaObras.remove(b);
            JOptionPane.showMessageDialog(null, "Obra de " + b.getAutores() + "Excluída!"); 
        } else {
            JOptionPane.showMessageDialog(null, "Obra não encontrada!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    // End of variables declaration//GEN-END:variables
}
