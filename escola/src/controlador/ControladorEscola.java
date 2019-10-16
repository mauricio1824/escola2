/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoEscola;
import javax.swing.JOptionPane;
import modelo.Escola;
import tela.manutencao.ManutencaoEscola;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ControladorEscola {

   public static void inserir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setNome(man.jtfNome.getText());
        objeto.setNr_alunos(Integer.parseInt(man.jtfNr_alunos.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setNr_funcionarios(Integer.parseInt(man.jtfNr_funcionarios.getText()));
        objeto.setAbertura(LocalDate.parse(man.jtfAbertura.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        boolean resultado = DaoEscola.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
     public static void alterar(ManutencaoEscola man){
        Escola objeto = new Escola();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setNr_alunos(Integer.parseInt(man.jtfNr_alunos.getText()));
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setNr_funcionarios(Integer.parseInt(man.jtfNr_funcionarios.getText()));
        objeto.setAbertura(LocalDate.parse(man.jtfAbertura.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        boolean resultado = DaoEscola.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }   

    public static void excluir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoEscola.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        List<Escola> resultados = DaoEscola.consultar();
        for (Escola objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getNr_alunos());
            linha.add(objeto.getArea());
            linha.add(objeto.getNr_funcionarios());
            linha.add(objeto.getAbertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoEscola man, int pk){ 
        Escola objeto = DaoEscola.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome.setText(objeto.getNome());
        man.jtfNr_alunos.setText(objeto.getNr_alunos().toString());
        man.jtfArea.setText(objeto.getArea().toString());
        man.jtfNr_funcionarios.setText(objeto.getNr_funcionarios().toString());
        man.jtfAbertura.setText(objeto.getAbertura().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
}
}
