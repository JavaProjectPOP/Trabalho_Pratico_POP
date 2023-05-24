package Teste;

import java.util.ArrayList;
import java.util.Scanner;

//Este projeto consiste em desenvolver um sistema de gestão de stock de produtos para
//uma loja online.
//1. O programa deve permitir ao utilizador criar uma conta. Para aceder ao sistema, o
//utilizador deverá efetuar login.
//2. O utilizador pode editar os dados da sua conta, nomeadamente o seu nome, dados de
//autenticação e informações de contacto.
//3. O programa deve permitir ao utilizador adicionar um novo produto com as informações
//de nome, descrição, categoria, preço e quantidade disponível em stock.
//4. O programa deve permitir ao utilizador editar as informações de um produto existente,
//incluindo a quantidade disponível em stock.
//5. O programa deve permitir ao utilizador remover um produto existente.
//6. O programa deve permitir ao utilizador pesquisar um produto específico pelo nome ou
//categoria.
//7. O programa deve permitir ao utilizador listar todos os produtos existentes, bem como as
//informações de stock atualizadas.
//8. O programa deve permitir ao utilizador gerir encomendas de clientes, incluindo a
//atualização do stock disponível após a compra de produtos.
//9. O programa deve permitir ao utilizador criar relatórios de vendas, que mostram as vendas
//totais por período de tempo, as vendas por produto e a quantidade em stock atualizada.

public class Gestor {
    private boolean on = true;
    Scanner myObj = new Scanner(System.in);
    private ArrayList<Utilizador> ListaUtilizador = new ArrayList<>();
    private ArrayList<Produtos> ListaProdutos = new ArrayList<>();

    private Menus menus=new Menus();
    public Gestor()
    {
        menus.menu0();
    }

    public boolean isOn() {
        return on;
    }

    public void setOff(boolean on) {
        this.on = on;
    }



    public ArrayList<Utilizador> getListaUtilizador() {
        return ListaUtilizador;
    }

    public ArrayList<Produtos> getListaProdutos() {
        return ListaProdutos;
    }

    public void APP(String email, String pass){
        for (Utilizador u : ListaUtilizador){
            if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                System.out.println("Bem Vindo "+u.getPrimeiroNome()+" "+u.getUltimoNome());
                System.out.println("1- Alterar os seus dados de usuario");
                System.out.println("3- Adicionar um produto");
                System.out.println("4- Editar as informações de um produto existente");
                System.out.println("5- Logout");
                String opcao = myObj.nextLine();
                menus.menu2(opcao, email,pass);
            }
        }

    }



    public boolean GuardarUser(Utilizador utilizador){
        if(utilizador != null){
            ListaUtilizador.add(utilizador);
            return true;
        }else{
            return false;
        }
    }
    public boolean GuardarProduto(Produtos produtos){
        if(produtos != null){
            ListaProdutos.add(produtos);
            return true;
        }else{
            return false;
        }
    }

}
