package SemGUI;

import java.util.Date;

public class Vendas {
    private int ID=0;
    private Date data;
    private String emailVendedor;//feito
    private String emailComprador;//feito
    private String estadoCompra;//feito
    private int ID_Produto;//feito
    private int QntComprada;//feito
    private double PrecoUni;//feito
    private double Valor_Total;//feito
    private String Nome_Produto;//feito
    private String Categoria_Produto;//feito
    private String morada; //c


    public Vendas(){

    }

    public double getPrecoUni() {
        return PrecoUni;
    }

    public void setPrecoUni(double precoUni) {
        PrecoUni = precoUni;
    }

    public String getMorada() {
        return morada;
    }

    public double getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(double valor_Total) {
        Valor_Total = valor_Total;
    }

    public int getQntComprada() {
        return QntComprada;
    }

    public void setQntComprada(int qntComprada) {
        QntComprada = qntComprada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCategoria_Produto() {
        return Categoria_Produto;
    }

    public String getNome_Produto() {
        return Nome_Produto;
    }

    public void setCategoria_Produto(String categoria_Produto) {
        Categoria_Produto = categoria_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        Nome_Produto = nome_Produto;
    }

    public String getEstadoCompra() {
        return estadoCompra;
    }

    public int getID_Produto() {
        return ID_Produto;
    }

    public void setEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public void setID_Produto(int ID_Produto) {
        this.ID_Produto = ID_Produto;
    }

    public int getID() {
        return ID;
    }

    public Date getData() {
        return data;
    }

    public String getEmailComprador() {
        return emailComprador;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public void setEmailComprador(String emailComprador) {
        this.emailComprador = emailComprador;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
