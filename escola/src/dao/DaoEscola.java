/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Escola;
import java.sql.Date; 
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class DaoEscola {
    public static boolean inserir(Escola objeto) {
        String sql = "INSERT INTO escola (nome, nr_alunos, area, nr_funcionarios, abertura) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setInt(2, objeto.getNr_alunos());
            ps.setDouble(3, objeto.getArea());
            ps.setInt(4, objeto.getNr_funcionarios());
            ps.setDate(5, Date.valueOf(objeto.getAbertura())); 
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Escola objeto = new Escola();
        objeto.setNome("General Osório");
        objeto.setNr_alunos(100);
        objeto.setArea(15.2);
        objeto.setNr_funcionarios(60);
        objeto.setAbertura(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Escola objeto) {
        String sql = "UPDATE escola SET nome = ?, nr_alunos = ?, area = ?, nr_funcionarios = ?, abertura = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setInt(2, objeto.getNr_alunos());
            ps.setDouble(3, objeto.getArea());
            ps.setInt(4, objeto.getNr_funcionarios());
            ps.setDate(5, Date.valueOf(objeto.getAbertura())); 
            ps.setInt(6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static boolean excluir(Escola objeto) {
        String sql = "DELETE FROM escola WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
     }
     public static List<Escola> consultar() {
        List<Escola> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, nr_alunos, area, nr_funcionarios, abertura FROM escola";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola objeto = new Escola();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setNr_alunos(rs.getInt("nr_alunos"));
                objeto.setArea(rs.getDouble("area"));
                objeto.setNr_funcionarios(rs.getInt("nr_funcionarios"));
                objeto.setAbertura(rs.getDate("abertura").toLocalDate());
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
     public static Escola consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, nr_alunos, area, nr_funcionarios, abertura FROM escola WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola objeto = new Escola();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setNr_alunos(rs.getInt("nr_alunos"));
                objeto.setArea(rs.getDouble("area"));
                objeto.setNr_funcionarios(rs.getInt("nr_funcionarios"));
                objeto.setAbertura(rs.getDate("abertura").toLocalDate());
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
