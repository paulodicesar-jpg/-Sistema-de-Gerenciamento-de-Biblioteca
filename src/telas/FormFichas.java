
package telas;

import classes.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FormFichas extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormFichas.class.getName());
    ArrayList<Obra> listaObras;
    ArrayList<Categoria> listaCategoria;
    ArrayList<FichaConservacao> listaFichas;
    ArrayList<Bibliotecario> listaBibio;
    
    public FormFichas(java.awt.Frame parent, boolean modal, ArrayList<Obra> listaObras, ArrayList<Categoria> listaCategoria, ArrayList<FichaConservacao> listaFichas, ArrayList<Bibliotecario> listaBibio) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.listaCategoria = listaCategoria;
        this.listaObras = listaObras;
        this.listaFichas = listaFichas;
        this.listaBibio = listaBibio;
    }
    
    public Obra encontrarObra(int isbn) {
        for (Obra b : listaObras) { 
            if (b.getISBN() == isbn) {
                return b;
            }
        }
        return null;
    }
    
    public FichaConservacao encontrarFicha (int isbn) {
        for (FichaConservacao f : listaFichas) {
            if (f.getObra().getISBN() == isbn) {
                return f;
            }
        }
        return null;
    }   
    
    private Categoria encontrarCategoria(int codigo) {
        for (Categoria c : listaCategoria) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }
    
    public Bibliotecario buscarBibliotecarioPorCodigo(int codigo) {
        for (Bibliotecario b : listaBibio) {
            if (b.getCodigoInterno() == codigo) {
                return b;
            }
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInserir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnIntervencao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(this::btnInserirActionPerformed);

        taSaida.setColumns(20);
        taSaida.setRows(5);
        jScrollPane1.setViewportView(taSaida);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(this::btnAlterarActionPerformed);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);

        btnListar.setText("Listar");
        btnListar.addActionListener(this::btnListarActionPerformed);

        btnIntervencao.setText("Registrar Intervenção");
        btnIntervencao.addActionListener(this::btnIntervencaoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(btnIntervencao)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(btnInserir)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnIntervencao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            int isbnBusca = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o ISBN da obra para localizar a Ficha:"));

            Obra obraEncontrada = encontrarObra(isbnBusca); 

            if (obraEncontrada != null) {
    
                for (FichaConservacao f : listaFichas) {
                    if (f.getObra().getISBN() == isbnBusca) {
                        JOptionPane.showMessageDialog(this, "Esta obra já possui uma ficha!");
                        return; 
                    }
                }

                int codigoFicha = Integer.parseInt(JOptionPane.showInputDialog("Código da Ficha:"));
                FichaConservacao novaFicha = new FichaConservacao(codigoFicha, obraEncontrada);
                listaFichas.add(novaFicha);

                JOptionPane.showMessageDialog(this, "Ficha criada para: " + obraEncontrada.getTituloObra());
            } else {
                JOptionPane.showMessageDialog(this, "Obra não encontrada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: Digite apenas números!");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            int isbnAlterar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN da obra para localizar a Ficha que deseja alterar:"));
            
            Obra e = encontrarObra(isbnAlterar);
            if (e != null) {
                for (FichaConservacao f : listaFichas) {
                    if (f.getObra().getISBN() == isbnAlterar) {
                        int novoCodigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo código"));
                        f.setCodigo(novoCodigo);
                        JOptionPane.showMessageDialog(this, "Código de ficha alterado!");
                        return; 
                    }
                }
                JOptionPane.showMessageDialog(this, "Ficha não encontrada para esta obra!");

            } else {
                JOptionPane.showMessageDialog(this, "Obra não cadastrada no sistema!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um número");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            int isbnExcluir = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN da Obra para excluir a Ficha de Conservação:"));
            
            Obra e = encontrarObra(isbnExcluir);
            if (e != null) {
                for (FichaConservacao f : listaFichas) {
                    if (f.getObra().getISBN() == isbnExcluir) {
                        listaFichas.remove(f);
                        JOptionPane.showMessageDialog(this, "Ficha excluída!");
                        return;
                    }
                }  JOptionPane.showMessageDialog(this, "Ficha não encontrada!");
            } else {
                JOptionPane.showMessageDialog(this, "Obra não encontrada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um número válido!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        taSaida.setText("");
        taSaida.append("   " + "=== RELATÓRIO ====" + "\n");
        for (FichaConservacao f : listaFichas) {
            taSaida.append(f.retornarFichaConservacaoCompleta() + "\n");
            taSaida.append("Custo total acumulado: " + f.calcularCustoTotal() + "\n");
            taSaida.append("Quantidade de intervencoes: " + f.quantidadeDeIntervencoes() + "\n");
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnIntervencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntervencaoActionPerformed
        try {
            int isbnIntervencao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN da Obra que vai receber manunteção:"));
            
            FichaConservacao f = encontrarFicha(isbnIntervencao);
            if (f != null) {
                String nomeInt = JOptionPane.showInputDialog("Nome da Intervenção (Restauro, Encadernação ou Higienização): ");
                double custoInt = Double.parseDouble(JOptionPane.showInputDialog("Custo do procedimento: "));
                String relatoInt = JOptionPane.showInputDialog("Relato do colaborador sobre o estado/situação:");
                
                int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da categoria que deseja encontrar: "));
                
                Categoria c = encontrarCategoria(codigo);
                
                if (c == null){
                    JOptionPane.showMessageDialog(this, "Categoria não encontrada!");
                    return;
                }

                int idColab = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID/Código do Bibliotecário responsável:"));
                Colaborador colab = buscarBibliotecarioPorCodigo(idColab);

                if (colab == null) {
                    JOptionPane.showMessageDialog(this, "Bibliotecário não encontrado no sistema!");
                    return; 
                }
                
                f.inserirIntervencao(nomeInt, custoInt, relatoInt, c, colab);
                JOptionPane.showMessageDialog(this, "Intervenção registrada!");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum ficha encontrada!");     
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite númericos!");     
        } 
    }//GEN-LAST:event_btnIntervencaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnIntervencao;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    // End of variables declaration//GEN-END:variables
}
