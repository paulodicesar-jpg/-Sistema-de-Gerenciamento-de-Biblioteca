
package telas;

import classes.Auxiliar;
import classes.Bibliotecario;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FormBibliotecario extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormBibliotecario.class.getName());
    ArrayList<Auxiliar> listaAuxiliares;
    ArrayList<Bibliotecario> listaBibio;
    
    public FormBibliotecario(java.awt.Frame parent, boolean modal,ArrayList<Auxiliar> listaAuxiliares, ArrayList<Bibliotecario> listaBibio) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        
        this.listaAuxiliares = listaAuxiliares;
        this.listaBibio = listaBibio;
    }

    public Bibliotecario buscarBibliotecarioPorCodigo(int codigo) {
        for (Bibliotecario b : listaBibio) {
            if (b.getCodigoInterno() == codigo) {
                return b;
            }
        }
        return null;
    }
    
     public Auxiliar buscarAuxiliarPorCodigo(int codigo) {
        for (Auxiliar a : listaAuxiliares) {
            if (a.getCodigoInterno() == codigo) {
                return a;
            }
        }
        return null;
    }
    
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        btnIncluir = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        brnListar = new javax.swing.JButton();
        btnExclusao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(this::btnIncluirActionPerformed);

        btnListar.setText("Listar");
        btnListar.addActionListener(this::btnListarActionPerformed);

        brnListar.setText("Alterar");
        brnListar.addActionListener(this::brnListarActionPerformed);

        btnExclusao.setText("Excluir");
        btnExclusao.addActionListener(this::btnExclusaoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExclusao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExclusao)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de colaborador:\n 1 - Bibliotecário \n 2 - Auxiliar"));
        
        if (tipo == 1) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite seu código: "));
           
            if (buscarBibliotecarioPorCodigo(codigo) != null) {
                JOptionPane.showConfirmDialog(null, "Código já existe!");
            }
            
            String nome = JOptionPane.showInputDialog("Digite seu nome completo: ");
            
            if (nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo vazio!");
                return;
            }
            
            
            String telefone = JOptionPane.showInputDialog("Digite seu telefone: ");
            int numCRB = Integer.parseInt(JOptionPane.showInputDialog("Número: "));
            String area = JOptionPane.showInputDialog("Área de atuação: ");
            listaBibio.add(new Bibliotecario(codigo, nome, telefone, numCRB, area));
        }
        
        else if (tipo == 2) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite seu código: "));
           
            if (buscarAuxiliarPorCodigo(codigo) != null) {
                JOptionPane.showConfirmDialog(null, "Código já existe!");
            }
            
            String nome = JOptionPane.showInputDialog("Digite seu nome completo: ");
            
            if (nome == null || nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo vazio!");
                return;
            }
            
            String turnoTrabalho = JOptionPane.showInputDialog("Digite seu turno de trabalho (manhã/tarde/noite): ");
            String telefone = JOptionPane.showInputDialog("Digite seu telefone: ");
            Auxiliar novo = new Auxiliar(codigo, nome, telefone, turnoTrabalho);
            novo.validarTurno(turnoTrabalho);
            listaAuxiliares.add(novo);
        }
        else {
            JOptionPane.showConfirmDialog(null, "Digite uma opção válida");
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
      int listar = Integer.parseInt(JOptionPane.showInputDialog("1 - listar bibliotecário \n 2 - listar auxiliares")); 
      
      if (listar == 1) {
          taSaida.setText("==== LISTA BIBLIOTECARIOS ===" + "\n");
          for (Bibliotecario b : listaBibio) {
              taSaida.append("   " + b.toString() + "\n");
          }
      } 
      else if (listar == 2) {
           taSaida.setText("==== LISTA AUXILIARES ===" + "\n");
           for (Auxiliar a : listaAuxiliares) {
              taSaida.append("   " + a.toString() + "\n");
          }    
      }
      else {
          JOptionPane.showMessageDialog(null, "Opção inválida!");
      }
    }//GEN-LAST:event_btnListarActionPerformed

    private void brnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnListarActionPerformed
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Alterar colaborador:\n 1 - Bibliotecário \n 2 - Auxiliar"));
        
        if (tipo == 1) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do bibliotecário que deseja alterar: "));
            
            Bibliotecario b = buscarBibliotecarioPorCodigo(codigo);
    
            if (b != null) {
       
            b.setNomeCompleto(JOptionPane.showInputDialog("Novo nome completo:", b.getNomeCompleto()));
        
            String novoTel = JOptionPane.showInputDialog("Novo telefone:");
            b.getTelefones().clear(); 
            b.getTelefones().add(novoTel);

            b.setNumeroCRB(Integer.parseInt(JOptionPane.showInputDialog("Novo número CRB:", b.getNumeroCRB())));
            b.setAreaAtuacao(JOptionPane.showInputDialog("Nova área de atuação:", b.getAreaAtuacao()));

            JOptionPane.showMessageDialog(null, "Bibliotecário alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Código não encontrado!");
            }
        } 
        
        else if (tipo == 2) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do auxiliar que deseja alterar: "));

   
            Auxiliar a = buscarAuxiliarPorCodigo(codigo);

            if (a != null) {

                a.setNomeCompleto(JOptionPane.showInputDialog("Novo nome completo:", a.getNomeCompleto()));

                String novoTel = JOptionPane.showInputDialog("Novo telefone:");
                a.getTelefones().clear();
                a.getTelefones().add(novoTel);

                String novoTurno = JOptionPane.showInputDialog("Novo turno (Manha/Tarde):");
                a.validarTurno(novoTurno); 

                JOptionPane.showMessageDialog(null, "Auxiliar alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Código não encontrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }//GEN-LAST:event_brnListarActionPerformed

    private void btnExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExclusaoActionPerformed
        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Excluir colaborador:\n 1 - Bibliotecário \n 2 - Auxiliar"));
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código de quem deseja excluir:"));

        if (tipo == 1) {
 
            Bibliotecario b = buscarBibliotecarioPorCodigo(codigo);

            if (b != null) {
                listaBibio.remove(b);
                JOptionPane.showMessageDialog(null, "Bibliotecário " + b.getNomeCompleto() + " excluído!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Código não encontrado!");
            }
        } 
        else if (tipo == 2) {
  
            Auxiliar a = buscarAuxiliarPorCodigo(codigo);

            if (a != null) {
          
                listaAuxiliares.remove(a);
                JOptionPane.showMessageDialog(null, "Auxiliar " + a.getNomeCompleto() + " excluído!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Código não encontrado!");
            }
    }//GEN-LAST:event_btnExclusaoActionPerformed
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnListar;
    private javax.swing.JButton btnExclusao;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    // End of variables declaration//GEN-END:variables

}