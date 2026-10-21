package model;

import javax.persistence.*;

@Entity
@Table(name ="contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConta;
    private String nomeConta;
    private double  saldoemConta;
    private int idUsuario;

    public Conta() {
    }

    public Conta(String nomeConta,  int idUsuario) {
        this.nomeConta = nomeConta;
        this.idUsuario = idUsuario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getSaldoemConta() {
        return saldoemConta;
    }

    public void setSaldoemConta(double saldoemConta) {
        this.saldoemConta = saldoemConta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
