package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="movimentacoes")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovimentacao;
    private String descricao,descricaoPagamento,status,tipo;
    private Date dataMovimentacao;
    private int idUsuario,idCategoria,idConta;
    private double valor;

    public Movimentacao() {
    }

    public Movimentacao(String descricao, String descricaoPagamento, String status, String tipo, Date dataMovimentacao, int idUsuario, int idCategoria, int idConta, double valor) {
        this.descricao = descricao;
        this.descricaoPagamento = descricaoPagamento;
        this.status = status;
        this.tipo = tipo;
        this.dataMovimentacao = dataMovimentacao;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.idConta = idConta;
        this.valor = valor;
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoPagamento() {
        return descricaoPagamento;
    }

    public void setDescricaoPagamento(String descricaoPagamento) {
        this.descricaoPagamento = descricaoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
