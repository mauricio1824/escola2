/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Escola {
    private Integer codigo;
    private String nome;
    private Integer nr_alunos;
    private Double area;
    private Integer nr_funcionarios;
    private LocalDate abertura;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNr_alunos() {
        return nr_alunos;
    }

    public void setNr_alunos(Integer nr_alunos) {
        this.nr_alunos = nr_alunos;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNr_funcionarios() {
        return nr_funcionarios;
    }

    public void setNr_funcionarios(Integer nr_funcionarios) {
        this.nr_funcionarios = nr_funcionarios;
    }

    public LocalDate getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDate abertura) {
        this.abertura = abertura;
    }

    @Override
    public String toString() {
        return "Escola{" + "nome=" + nome + '}';
    }
}
