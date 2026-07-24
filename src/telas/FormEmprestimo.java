
package telas;

import classes.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FormEmprestimo extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormEmprestimo.class.getName());
    ArrayList<Leitor> listaLeitores;
    ArrayList<Emprestimo> listaEmprestimo;
    ArrayList<Obra> listaObras;
 
    public FormEmprestimo(java.awt.Frame parent, boolean modal, ArrayList<Leitor> listaLeitores, ArrayList<Emprestimo> listaEmprestimo, ArrayList<Obra> listaObras) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(parent);
        
        this.listaLeitores = listaLeitores;
        this.listaEmprestimo = listaEmprestimo;
        this.listaObras = listaObras;
    }

    public Obra encontrarObra (int isbn) {
        for (Obra o : listaObras) {
            if (o.getISBN() == isbn) {
                return o;
            }
        }
        return null;
    }
    
    public Leitor encontrarLeitor (int cpf) {
        for (Leitor l : listaLeitores) {
            if (l.getCpf() == cpf) {
                return l;
            }
        }
        return null;
    }
    
    public Emprestimo encontrarEmprestimo (int cpf) {
        for (Emprestimo e : listaEmprestimo) {
            if (e.getLeitor().getCpf() == cpf) {
                return e;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            int isbnBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ISBN: "));
            
            Obra o = encontrarObra(isbnBuscar);
            
            if (o == null) {
                JOptionPane.showMessageDialog(this, "Obra não encontrada!");
                return;
            }
            
            for (Emprestimo e : listaEmprestimo) {
                if (e.getObra().getISBN() == isbnBuscar && e.isStatus() == true) {
                    JOptionPane.showMessageDialog(this, "Essa obra já foi emprestada e possui empréstimo ativo!");
                    return;
                }
            }
            
            int cpfBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite o  CPF do leitor: "));
            
            Leitor l = encontrarLeitor(cpfBuscar);
            
            if (l == null) {
                JOptionPane.showMessageDialog(this, "Leitor não encontrado!");
                return;
            }
            
            int codigoEmp = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código do empréstimo:"));
            String dataSaida = JOptionPane.showInputDialog(this, "Digite a data de saída (ex: 06/06/2026):");
            String dataPrevista = JOptionPane.showInputDialog(this, "Digite a data prevista para devolução:");
            
            double valorMultaInicial = 0.0;
            boolean statusInicial = true;
            
            Emprestimo novoEmprestimo = new Emprestimo(o, l, codigoEmp, dataSaida, dataPrevista, valorMultaInicial, statusInicial);
            listaEmprestimo.add(novoEmprestimo);
            
            JOptionPane.showMessageDialog(this, "Emprestimo " + codigoEmp + " realizado com sucesso para o leitor: " + l.getNome());     
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite apenas númericos!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Digite um número maior que zero!");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            int codBuscar = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código do empréstimo que deseja alterar / devolver: "));
            
            Emprestimo e = encontrarEmprestimo (codBuscar);
            
            if (e == null) {
                JOptionPane.showMessageDialog(this, "Empréstimo não encontrado!");
                return;
            }
            
            if (e.isStatus() == false) {
                JOptionPane.showMessageDialog(this, "Esse empréstimo já constava como devolvido!");
                return;
            }
            
            String opcao = JOptionPane.showInputDialog(this, 
                "O que deseja fazer?\n" +
                "1 - Registrar Devolução\n" +
                "2 - Editar Datas\n" +
                "3 - Cancelar");
            
            if (opcao == null) return;  // usuario clicar em cancelar. nao sabia disso :D
            
            if (opcao.equals("1")) {
                
                double multa = Double.parseDouble(JOptionPane.showInputDialog(this,"Digite o valor da multa (ou 0 se não houver): "));
                
                if (multa < 0) {
                    throw new IllegalArgumentException("O valor da multa não pode ser negativo"); 
                }
                
                e.setValorMulta(multa);
                e.setStatus(false);  // devolvido = libera obra
                
                JOptionPane.showMessageDialog(this, "Devolução realizada com sucesso!");
            }
            
            else if (opcao.equals("2")) {
                String novaDataSaida = JOptionPane.showInputDialog(this, "Nova data de saída:", e.getDataSaida());
                String novaDataPrevista = JOptionPane.showInputDialog(this, "Nova data prevista para devolução: ", e.getDataPrevista());
                
                e.setDataSaida(novaDataSaida);
                e.setDataPrevista(novaDataPrevista);
                
               JOptionPane.showMessageDialog(this, "Datas atualizadas com sucesso!");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite apenas númericos!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Sem valores negativos!!");
            
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            int codExcluir = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código do empréstimo que deseja excluir: "));

            Emprestimo e = encontrarEmprestimo(codExcluir);

            if (e == null) {
                JOptionPane.showMessageDialog(this, "Código não encontrado!");
                return; 
            }
           
            if (e.isStatus() == true) {
                String confirmar = JOptionPane.showInputDialog(this, "Este empréstimo ainda está ATIVO. Deseja excluir? \n 1 - Sim \n 2 - Não");
   
                if (confirmar != null && confirmar.equals("1")) {
                    listaEmprestimo.remove(e);
                    JOptionPane.showMessageDialog(this, "Empréstimo removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Empréstimo NÃO excluído!");
                }
            } 
           
            else {
                listaEmprestimo.remove(e);
                JOptionPane.showMessageDialog(this, "Empréstimo removido com sucesso!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite apenas números!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Sem valores negativos");
        }      
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        taSaida.setText("");
        
        String opcao = JOptionPane.showInputDialog(this,
                "Escolha o relatório: \n" + 
                "1 - Listar todos os Empréstimos\n" +
                "2 - Filtrar por Leitor (CPF)\n" +
                "3 - Filtrar por OBRA (ISBN)\n" +
                "4 - Filtrar por Data de Saída");
        
        if (opcao == null) return;
        
        String relatorio = "";
        
        if (opcao.equals("1")) {
            relatorio = "=== RELATÓRIO: Todos os Empréstimos ====\n";
            for (Emprestimo e : listaEmprestimo) {
                relatorio += e.toString() + "\n----------------------------------------\n";
            }
        }
        else if (opcao.equals("2")) {        
            try {
                int cpfBusca = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o CPF do leitor:"));
                relatorio = "=== EMPRÉSTIMOS DO LEITOR (CPF: " + cpfBusca + ") ===\n\n";

                boolean achou = false;
                for (Emprestimo e : listaEmprestimo) {
                    if (e.getLeitor().getCpf() == cpfBusca) {
                        relatorio += e.toString() + "\n----------------------------------------\n";
                        achou = true;
                    }
                }
                if (!achou) relatorio += "Nenhum empréstimo encontrado para este CPF.\n";

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: Digite um CPF válido (apenas números)!");
                return;
            }
        }
        
        taSaida.setText(relatorio);
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSaida;
    // End of variables declaration//GEN-END:variables
}
