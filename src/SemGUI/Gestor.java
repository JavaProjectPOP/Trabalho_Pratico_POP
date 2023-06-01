package SemGUI;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.text.*;

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
    private ArrayList<Vendas> ListaVendas = new ArrayList<>();

    public Gestor() {
        menu0();
    }

    public void menu0() {
        while (isOn() == true) {
            System.out.println("Bem Vindo a App");
            System.out.println("1-Registar um usuario");
            System.out.println("2-Logar a sua conta");
            System.out.println("3-Sair");
            System.out.println("Escolha: ");
            String Opcao = myObj.nextLine();
            clearBuffer(myObj);
            menu1(Opcao);
        }
    }

    public ArrayList<Vendas> getListaVendas() {
        return ListaVendas;
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

    public void APP(String email, String pass) {
        for (Utilizador u : ListaUtilizador) {
            if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                System.out.println("Bem Vindo " + u.getPrimeiroNome() + " " + u.getUltimoNome());
                System.out.println("1- Alterar os seus dados de usuario");
                System.out.println("2- Adicionar um produto");
                System.out.println("4- Editar as informações de um produto existente");
                System.out.println("5- Remover um produto");
                System.out.println("6- Ver todos os produtos");
                System.out.println("7- Pesquisa por produto(pode pesquisar pela categoria ou pelo no me do produto)");//feito
                System.out.println("Antes de fazer uma compra recomendo que veja os produtos no menu 6\ne anotar o ID.");
                System.out.println("8- Fazer uma compra de um produto");
                System.out.println("9- Ver as informações das suas vendas e compras");
                System.out.println("10- Logout");
                String opcao = myObj.nextLine();
                clearBuffer(myObj);
                menu2(opcao, email, pass);
            }
        }

    }

    public boolean GuardarUser(Utilizador utilizador) {
        if (utilizador != null) {
            getListaUtilizador().add(utilizador);
            return true;
        } else {
            return false;
        }
    }

    public boolean GuardarVenda(Vendas venda) {
        if (venda != null) {
            getListaVendas().add(venda);
            return true;
        } else {
            return false;
        }
    }

    public boolean GuardarProduto(Produtos produtos) {
        if (produtos != null) {
            ListaProdutos.add(produtos);
            return true;
        } else {
            return false;
        }
    }

    public boolean RemoverProduto(int id) {
            ListaProdutos.remove(id);
            return true;
    }

    public void menu1(String Opcao) {
        switch (Opcao) {
            case "1": {
                System.out.println("Primeiro nome: ");
                String P_N = myObj.nextLine();
                clearBuffer(myObj);
                System.out.println("Ultimo nome: ");
                String U_N = myObj.nextLine();
                clearBuffer(myObj);
                System.out.println("Morada: ");
                String Morada = myObj.nextLine();
                clearBuffer(myObj);
                System.out.println("Email: ");
                String email = myObj.nextLine();
                clearBuffer(myObj);
                System.out.println("Palavra passe: ");
                String P_P = myObj.nextLine();
                clearBuffer(myObj);
                Utilizador u = new Utilizador();
                u.setPrimeiroNome(P_N);
                u.setUltimoNome(U_N);
                u.setEmail(email);
                u.setPalavraPasse(P_P);
                u.setMorada(Morada);
                GuardarUser(u);
                if (GuardarUser(u)) {
                    System.out.println("Registrado com sucesso Sr/Sra - " + P_N + " " + U_N);
                } else {
                    System.out.println("Foi detetado um erro quando estava a fazer o registo, " +
                            "tente novamente mais tarde");
                }
                break;
            }
            case "2": {
                System.out.println("Email: ");
                String email = myObj.nextLine();
                clearBuffer(myObj);
                System.out.println("Palavra Passe: ");
                String pp = myObj.nextLine();
                clearBuffer(myObj);
                for (Utilizador utilizador : getListaUtilizador()) {
                    String tEmail = utilizador.getEmail();
                    String tpp = utilizador.getPalavraPasse();
                    boolean auteEmail = email.equals(tEmail);
                    boolean autePalavra = pp.equals(tpp);
                    if (auteEmail && autePalavra) {
                        APP(email, pp);
                    } else {
                        System.out.println("Email/senha Incorretos");
                    }
                }
                break;
            }
            case "3": {
                System.out.println("Obrigado e um bom dia");
                setOff(false);
                break;
            }
        }
    }

    public void menu2(String opcao, String email, String pass) {
        switch (opcao) {
            case "1": {
                for (Utilizador u : getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Quais informações deseja alterar?");
                        System.out.println("1-Primeiro nome");
                        System.out.println("2-Ultimo nome");
                        System.out.println("3-Email");
                        System.out.println("4-Palava-passe");
                        System.out.println("5-Todas as informações");
                        String op = myObj.nextLine();
                        clearBuffer(myObj);
                        menu3(op, email, pass);
                    }
                }
                break;
            }
            case "2": {
                for (Utilizador u : getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Nome do produto: ");
                        String N_P = myObj.nextLine();
                        clearBuffer(myObj);
                        System.out.println("Categoria: ");
                        String cat = myObj.nextLine();
                        clearBuffer(myObj);
                        System.out.println("Preço(xx.xx): ");
                        String tPreco = myObj.nextLine();
                        clearBuffer(myObj);
                        double preco = Double.parseDouble(tPreco);
                        System.out.println("Stock: ");
                        String tStock = myObj.nextLine();
                        clearBuffer(myObj);
                        int Stock = Integer.parseInt(tStock);
                        Produtos p = new Produtos();
                        p.setNomeProduto(N_P);
                        p.setCategoria(cat);
                        p.setPreco(preco);
                        p.setStock(Stock);
                        int tID = p.getId();
                        p.setId(tID);
                        tID += 1;
                        p.setOrigem(email);
                        GuardarProduto(p);
                        System.out.println("Produto adicionado com sucesso");
                        APP(email, pass);
                    }
                }

                break;
            }
            case "4": {
                //Editar as informações de um produto existente
                allProducts();
                System.out.println("Qual é o ID do produto que deseja alterar as informações?");
                System.out.println("Escolha: ");
                String Id = myObj.nextLine();
                clearBuffer(myObj);
                System.out.println("o que deseja alterar?");
                System.out.println("1- Nome do produto");
                System.out.println("2- Categoria");
                System.out.println("3- Preço");
                System.out.println("4- Stock");
                System.out.println("5- Todas as informações");
                String op = myObj.nextLine();
                clearBuffer(myObj);
                menu4(op, email, pass, Id);
                break;
            }
            case "5": {
                allProducts();
                System.out.println("Qual é o ID do produto que deseja remover?");
                System.out.println("Escolha: ");
                String Id = myObj.nextLine();
                clearBuffer(myObj);
                int ID= Integer.parseInt(Id);
                for (Produtos p :
                        getListaProdutos()) {
                    if ((ID == p.getId()) && email.equals(p.getOrigem())) {
                        RemoverProduto(ID);
                        System.out.println("Produto removido com sucesso");
                        APP(email, pass);
                    }else{
                        System.out.println("Produto não pode ser removido");
                        APP(email, pass);
                    }
                }
                break;
            }
            case "6": {
                allProducts();
                APP(email, pass);
                break;
            }
            case "7": {
                //7- Pesquisa por produto(pode pesquisar pela categoria ou pelo no me do produto)
                System.out.println("1- Pesquisar produtos pelo nome dos mesmos");
                System.out.println("2- Pesquisar produtos pela categoria");
                System.out.println("3- Pesquisar em nomes de produtos e categorias");
                String pesquisa = myObj.nextLine();
                clearBuffer(myObj);
                menuPesquisa(pesquisa, email, pass);
                break;
            }
            case "8": {
                //8- Fazer uma compra de um produto
                System.out.println("Bem vindo ao menu de compra");
                System.out.println("Decorou/anotou os IDs?\nSe não decorou e deseja ver os produtos de novo\nintroduza o ID");
                System.out.println("Peço que faça a compra de um produto de cada vez\n" +
                        "Qual é o id do produto que deseja comprar?");
                String produto = myObj.nextLine();
                clearBuffer(myObj);
                if (produto.equals("IDS") || produto.equals("ids")) {
                    allProducts();
                } else {
                    for (Produtos p :
                            getListaProdutos()) {
                        if (produto.equals(p.getId()) && p.getStock() > 0) {
                            System.out.println("Estas a fazer a compra do produto: " + p.getNomeProduto());
                            System.out.println("O produto é da categoria: " + p.getCategoria());
                            System.out.println("O preço Unitario é: " + p.getPreco());
                            System.out.println("Existem " + p.getStock() + " em stock");
                            System.out.println("Qual é a quantidade que deseja comprar?");
                            String QNT = myObj.nextLine();
                            clearBuffer(myObj);
                            int qnt = Integer.parseInt(QNT);
                            if (qnt > p.getStock()) {
                                System.out.println("Valor superior ao stock, compra cancelada, recomeçe a compra");
                                APP(email, pass);
                            }
                            System.out.println("O total é: " + qnt * p.getPreco() +
                                    "\nDeseja prosseguir com a compra?(responda com sim/nao)");
                            String opcion = myObj.nextLine();
                            clearBuffer(myObj);
                            if (opcion.equals("sim") || opcion.equals("Sim") || opcion.equals("SIM")) {
                                Vendas v = new Vendas();
                                v.setCategoria_Produto(p.getCategoria());
                                Date x = new Date();
                                v.setData(x);
                                int nID = v.getID();
                                v.setID(nID);
                                nID++;
                                v.setEmailComprador(email);
                                v.setEmailVendedor(p.getOrigem());
                                v.setID_Produto(p.getId());
                                v.setCategoria_Produto(p.getCategoria());
                                v.setNome_Produto(p.getNomeProduto());
                                v.setQntComprada(qnt);
                                v.setPrecoUni(p.getPreco());
                                v.setValor_Total(qnt * p.getPreco());
                                v.setEstadoCompra("Em processo");
                                boolean c;
                                c = GuardarVenda(v);
                                if (c = true) {
                                    System.out.println("Compra efetuada com sucesso");
                                } else if (c = false) {
                                    System.out.println("compra não sucedida");
                                }

                            } else if (opcion.equals("nao") || opcion.equals("Nao") || opcion.equals("NAO") ||
                                    opcion.equals("nãO") || opcion.equals("Não")) {
                                System.out.println("Compra cancelada");
                                APP(email, pass);
                            }

                        } else {
                            System.out.println("Já nao existe esse produto em stock");
                            APP(email, pass);
                        }
                    }
                }
                APP(email, pass);
                break;
            }
            case "9": {
                System.out.println("1- Ver as vendas feitas");
                System.out.println("2- Ver as compras feitas");
                System.out.println("3- Alterar o estado de uma venda");
                String op = myObj.nextLine();
                clearBuffer(myObj);
                menuCompraVenda(op, email, pass);
                break;
            }
            case "10": {
                menu0();
            }
        }
    }

    public void menu3(String op, String email, String pass) {
        switch (op) {
            case "1": {
                for (Utilizador u :
                        getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Primeiro nome atual: " + u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String nome = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setPrimeiroNome(nome);
                        System.out.println("Nome alterado com sucesso");
                        APP(email, pass);

                    }
                }

                break;
            }
            case "2": {
                for (Utilizador u :
                        getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Ultimo nome atual: " + u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String nome = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setUltimoNome(nome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        APP(email, pass);
                    }
                }

                break;
            }
            case "3": {
                for (Utilizador u :
                        getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Email atual: " + u.getEmail());
                        System.out.println("Novo email: ");
                        String tEmail = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        APP(tEmail, pass);
                    }
                }

                break;
            }
            case "4": {
                for (Utilizador u :
                        getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Palavra-passe atual: " + u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        APP(email, tpp);
                    }
                }
                break;
            }
            case "5": {
                for (Utilizador u :
                        getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        //Alterar primeiro nome
                        System.out.println("Primeiro nome atual: " + u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String Pnome = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setPrimeiroNome(Pnome);
                        System.out.println("Nome alterado com sucesso");
                        //Alterar ultimo nome
                        System.out.println("Ultimo nome atual: " + u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String Unome = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setUltimoNome(Unome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        //Alterar email
                        System.out.println("Email atual: " + u.getEmail());
                        System.out.println("Novo nome: ");
                        String tEmail = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        //Alterar Palaavra passe
                        System.out.println("Palavra-passe atual: " + u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = myObj.nextLine();
                        clearBuffer(myObj);
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        APP(tEmail, tpp);
                    }
                }
                APP(email, pass);
                break;
            }

        }
    }

    //menu utilizado para mudar as inforamaçoes de um produto
    public void menu4(String op, String email, String pass, String ID) {
        switch (op) {
            case "1": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Nome atual do produto: " + p.getNomeProduto());
                        System.out.println("Novo nome do produto: ");
                        String N_N = myObj.nextLine();
                        clearBuffer(myObj);
                        p.setNomeProduto(N_N);
                        System.out.println("Informação alterada com sucesso");
                        APP(email, pass);
                    }
                }
                APP(email, pass);
                break;

            }
            case "2": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Categoria atual do produto: " + p.getCategoria());
                        System.out.println("Nova categoria do produto: ");
                        String N_C = myObj.nextLine();
                        clearBuffer(myObj);
                        p.setNomeProduto(N_C);
                        System.out.println("Informação alterada com sucesso");
                        APP(email, pass);
                    }
                }

                break;
            }
            case "3": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Preço atual do produto: " + p.getPreco());
                        System.out.println("Preço nome do produto: ");
                        String N_P = myObj.nextLine();
                        clearBuffer(myObj);
                        p.setNomeProduto(N_P);
                        System.out.println("Informação alterada com sucesso");
                        APP(email, pass);
                    }
                }

                break;
            }
            case "4": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Stock atual do produto: " + p.getStock());
                        System.out.println("1- Adicionar produtos ao stock atual");
                        System.out.println("2- Mudar o stock atual");
                        String op_p = myObj.nextLine();
                        clearBuffer(myObj);
                        if (op_p.equals("1")) {
                            System.out.println("Quantidade a adicionar: ");
                            String N_S = myObj.nextLine();
                            clearBuffer(myObj);
                            int tStock = Integer.parseInt(N_S);
                            int ttStock = p.getStock();
                            tStock += ttStock;
                            p.setNomeProduto(String.valueOf(tStock));
                            System.out.println("Stock adicionado com sucesso");
                            APP(email, pass);
                        } else if (op_p.equals("2")) {
                            System.out.println("Novo nome do produto: ");
                            String N_S = myObj.nextLine();
                            clearBuffer(myObj);
                            p.setNomeProduto(N_S);
                            System.out.println("Informação alterada com sucesso\n");
                            APP(email, pass);
                        }
                    }
                }
                APP(email, pass);
                break;
            }
            case "5": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Nome atual do produto: " + p.getNomeProduto());
                        System.out.println("Novo nome do produto: ");
                        String N_P = myObj.nextLine();
                        clearBuffer(myObj);
                        System.out.println("Categoria atual: " + p.getCategoria());
                        System.out.println("Nova categoria: ");
                        String Categ = myObj.nextLine();
                        clearBuffer(myObj);
                        System.out.println("Preço atual: " + p.getPreco());
                        System.out.println("Novo preço: ");
                        String tPreco = myObj.nextLine();
                        clearBuffer(myObj);
                        double preco = Double.parseDouble(tPreco);
                        System.out.println("Stock atual: " + p.getStock());
                        System.out.println("Novo stock: ");
                        String tStock = myObj.nextLine();
                        clearBuffer(myObj);
                        int Stock = Integer.parseInt(tStock);
                        p.setNomeProduto(N_P);
                        p.setNomeProduto(Categ);
                        p.setPreco(preco);
                        p.setStock(Stock);
                        System.out.println("Produto alterado com sucesso\n");
                        APP(email, pass);
                    }
                }
                APP(email, pass);
                break;
            }

        }
    }

    public void menuPesquisa(String opcao, String email, String pass) {
        switch (opcao) {
            case "1": {
                if (ListaProdutos.size() == 0) {
                    System.out.println("Sem produtos adicionados na loja");
                    APP(email, pass);
                } else {

                            allProducts();
                        APP(email, pass);
                    }
                APP(email, pass);
                break;
            }
            case "2": {
                if (ListaProdutos.size() == 0) {
                    System.out.println("Sem produtos adicionados na loja");
                    APP(email, pass);
                } else {

                    System.out.println("Escreva o que quer pesquisar:");
                    String pesquisa = myObj.nextLine();


                    System.out.println("Lista de Produtos");

                    for (Produtos p : ListaProdutos) {
                        if (pesquisa.equals(p.getCategoria())) {
                            System.out.println("---------------------------" + "\nID_Produto: " + p.getId() + "\nNome do Produto: " + p.getNomeProduto()
                                    + "\nCategoria: " + p.getCategoria() + "\nPreço: " + p.getPreco() + "\nStock: " + p.getStock() + "\nOrigem do produto: " + p.getOrigem() + "---------------------------\n\n");
                            APP(email, pass);
                        }

                    }
                }
                APP(email, pass);
                break;
            }
            case "3": {

                if (ListaProdutos.size() == 0) {
                    System.out.println("Sem produtos adicionados na loja");
                    APP(email, pass);
                } else {

                    System.out.println("Escreva o que quer pesquisar:");
                    String pesquisa = myObj.nextLine();


                    System.out.println("Lista de Produtos");

                    for (Produtos p : ListaProdutos) {
                        if (pesquisa.equals(p.getCategoria()) || pesquisa.equals(p.getNomeProduto())) {
                            System.out.println("---------------------------" + "\nID_Produto: " + p.getId() + "\nNome do Produto: " + p.getNomeProduto()
                                    + "\nCategoria: " + p.getCategoria() + "\nPreço: " + p.getPreco() + "\nStock: " + p.getStock() + "\nOrigem do produto: " + p.getOrigem() + "---------------------------\n\n");
                            APP(email, pass);
                        }

                    }
                }
                APP(email, pass);
                break;
            }
        }
    }

    //Lista todos os produtos
    public void allProducts(){
        if (getListaProdutos().size() == 0) {
            System.out.println("Sem produtos adicionados na loja");
        } else {
            System.out.println("Lista de Produtos");
            for (Produtos p : getListaProdutos()) {
                System.out.println("---------------------------" + "\nID_Produto: " + p.getId() + "\nNome do Produto: " + p.getNomeProduto()
                        + "\nCategoria: " + p.getCategoria() + "\nPreço: " + p.getPreco() + "\nStock: " + p.getStock() + "\nOrigem do produto: " + p.getOrigem()+"---------------------------\n\n");

            }
        }
        return;
    }
    public void menuCompraVenda(String op, String email, String pass){
        String pattern = "dd-M-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        switch (op){
            case "1":{
                System.out.println("Lista de Vendas");
                for(Vendas v : getListaVendas()){
                    if (v.getEmailVendedor().equals(email)){
                        System.out.println("---------------------------");
                        System.out.println("ID de contrato compra/venda: "+v.getID());
                        String tdate = "";
                        tdate.concat(String.valueOf(v.getData()));
                        date.concat(tdate);
                        System.out.println("Data: "+v.getData());
                        System.out.println("Email comprador: "+v.getEmailComprador());
                        System.out.println("Morada: "+v.getMorada());
                        System.out.println("Nome do produto: "+v.getNome_Produto());
                        System.out.println("Categoria do Produto: "+v.getCategoria_Produto());
                        System.out.println("ID do produto: "+v.getID_Produto());
                        System.out.println("Quantidade: "+v.getQntComprada());
                        System.out.println("Valor unitario: "+v.getPrecoUni());
                        System.out.println("Valor total: "+v.getValor_Total());
                        System.out.println("Estado: "+v.getEstadoCompra());
                        System.out.println("---------------------------");
                        APP(email, pass);
                    }
                }
                APP(email,pass);
                break;
            }
            case "2":{
                System.out.println("Lista de Compras");
                for(Vendas v : getListaVendas()){
                    if (v.getEmailComprador().equals(email)){
                        System.out.println("---------------------------");
                        System.out.println("ID de contrato compra/venda: "+v.getID());
                        System.out.println("Data: "+v.getData());
                        System.out.println("Email comprador: "+v.getEmailComprador());
                        System.out.println("Morada: "+v.getMorada());
                        System.out.println("Nome do produto: "+v.getNome_Produto());
                        System.out.println("Categoria do Produto: "+v.getCategoria_Produto());
                        System.out.println("ID do produto: "+v.getID_Produto());
                        System.out.println("Quantidade: "+v.getQntComprada());
                        System.out.println("Valor unitario: "+v.getPrecoUni());
                        System.out.println("Valor total: "+v.getValor_Total());
                        System.out.println("Estado: "+v.getEstadoCompra());
                        System.out.println("---------------------------");
                        APP(email, pass);
                    }
                }
                APP(email, pass);
                break;
            }
            case "3":{
                System.out.println("Qual é o ID de venda que deseja alterar");
                String id = myObj.nextLine();
                clearBuffer(myObj);
                for(Vendas v : getListaVendas()){
                    if(v.getEmailVendedor().equals(email)&& id.equals(v.getID())){
                        System.out.println("---------------------------");
                        System.out.println("ID de contrato compra/venda: "+v.getID());
                        System.out.println("Data: "+v.getData());
                        System.out.println("Email comprador: "+v.getEmailComprador());
                        System.out.println("Morada: "+v.getMorada());
                        System.out.println("Nome do produto: "+v.getNome_Produto());
                        System.out.println("Categoria do Produto: "+v.getCategoria_Produto());
                        System.out.println("ID do produto: "+v.getID_Produto());
                        System.out.println("Quantidade: "+v.getQntComprada());
                        System.out.println("Valor unitario: "+v.getPrecoUni());
                        System.out.println("Valor total: "+v.getValor_Total());
                        System.out.println("Estado atual: "+v.getEstadoCompra());
                        System.out.println("---------------------------");
                        System.out.println("Estado que deseja colcar: ");
                        String estado = myObj.nextLine();
                        v.setEstadoCompra(estado);
                        System.out.println("Estado atualizado");
                        APP(email, pass);
                    }
                }
                APP(email, pass);
                break;
            }
        }
    }
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
