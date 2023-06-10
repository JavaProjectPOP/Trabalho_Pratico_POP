package SemGUI;
/**
@Authors
André Carvalho - 29740
Lucas Cruz -
Luís Martinho-
*/
public class Produtos {
    private String NomeProduto;
    private String Categoria;
    private double Preco;
    private int Stock;
    private String Origem;
    private int id = 0;

    public Produtos(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return Preco;
    }

    public int getStock() {
        return Stock;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public String getOrigem() {
        return Origem;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public void setOrigem(String origem) {
        Origem = origem;
    }
}
