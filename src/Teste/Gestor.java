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
            menu1(Opcao);
        }
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
                System.out.println("1- Alterar os seus dados de usuario");//feito
                System.out.println("2- Adicionar um produto");//feito
                System.out.println("4- Editar as informações de um produto existente");//feito
                System.out.println("5- Remover um produto");//feito
                System.out.println("6- Ver todos os produtos");//feito
                System.out.println("7- Pesquisa por produto(pode pesquisar pela categoria ou pelo no me do produto)");
                System.out.println("8- Fazer uma compra de um produto");
                System.out.println("9- Ver as informações das suas vendas e compras");
                System.out.println("10- Logout");//feito
                String opcao = myObj.nextLine();
                menu2(opcao, email, pass);
            }
        }

    }


    public boolean GuardarUser(Utilizador utilizador) {
        if (utilizador != null) {
            ListaUtilizador.add(utilizador);
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

    public boolean RemoverProduto(Produtos produtos) {
        if (produtos != null) {
            ListaProdutos.remove(produtos);
            return true;
        } else {
            return false;
        }
    }

    public void menu1(String Opcao) {
        switch (Opcao) {
            case "1": {
                System.out.println("Primeiro nome: ");
                String P_N = myObj.nextLine();
                System.out.println("Ultimo nome: ");
                String U_N = myObj.nextLine();
                System.out.println("Email: ");
                String email = myObj.nextLine();
                System.out.println("Palavra passe: ");
                String P_P = myObj.nextLine();
                Utilizador u = new Utilizador();
                u.setPrimeiroNome(P_N);
                u.setUltimoNome(U_N);
                u.setEmail(email);
                u.setPalavraPasse(P_P);
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
                System.out.println("Palavra Passe: ");
                String pp = myObj.nextLine();
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
                        menu3(op, email, pass);
                        break;
                    }

                }
            }
            case "2": {
                for (Utilizador u : getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Nome do produto: ");
                        String N_P = myObj.nextLine();
                        System.out.println("Categoria: ");
                        String Categ = myObj.nextLine();
                        System.out.println("Preço(xx.xx): ");
                        String tPreco = myObj.nextLine();
                        double preco = Double.parseDouble(tPreco);
                        System.out.println("Stock: ");
                        String tStock = myObj.nextLine();
                        int Stock = Integer.parseInt(tStock);
                        Produtos p = new Produtos();
                        p.setNomeProduto(N_P);
                        p.setNomeProduto(Categ);
                        p.setPreco(preco);
                        p.setStock(Stock);
                        int tID = p.getId();
                        p.setId(tID);
                        tID += 1;
                        String origin = "";
                        origin.concat(u.getEmail());
                        p.setOrigem(origin);
                        GuardarProduto(p);
                        System.out.println("Produto adicionado com sucesso");
                        break;
                    }
                }
            }
            case "4": {
                //Editar as informações de um produto existente
                if (ListaProdutos.size() == 0) {
                    System.out.println("Sem produtos adicionados na loja");
                } else {

                    System.out.println("Lista de Produtos");

                    for (Produtos p : ListaProdutos) {
                        if (email.equals(p.getOrigem())) {
                            System.out.println("---------------------------" + "ID_Produto: " + p.getId() + "\nNome do Produto: " + p.getNomeProduto()
                                    + "\nCategoria: " + p.getCategoria() + "\nPreço: " + p.getPreco() + "\nStock: " + p.getStock() + "\nOrigem do produto: " + p.getOrigem());
                        }
                    }
                    System.out.println("Qual é o ID do produto que deseja alterar as informações?");
                    System.out.println("Escolha: ");
                    String Id = myObj.nextLine();
                    System.out.println("o que deseja alterar?");
                    System.out.println("1- Nome do produto");
                    System.out.println("2- Categoria");
                    System.out.println("3- Preço");
                    System.out.println("4- Stock");
                    System.out.println("5- Todas as informações");
                    String op = myObj.nextLine();
                    menu4(op, email, pass, Id);
                }
                break;
            }
            case "5": {
                if (ListaProdutos.size() == 0) {
                    System.out.println("Sem produtos adicionados na loja");
                } else {

                    System.out.println("Lista de Produtos");

                    for (Produtos p : ListaProdutos) {
                        if (email.equals(p.getOrigem())) {
                            System.out.println("---------------------------" + "ID_Produto: " + p.getId() + "\nNome do Produto: " + p.getNomeProduto()
                                    + "\nCategoria: " + p.getCategoria() + "\nPreço: " + p.getPreco() + "\nStock: " + p.getStock() + "\nOrigem do produto: " + p.getOrigem());
                        }
                    }
                }
                System.out.println("Qual é o ID do produto que deseja remover?");
                System.out.println("Escolha: ");
                String Id = myObj.nextLine();
                for (Produtos p :
                        getListaProdutos()) {
                    if (Id.equals(p.getId()) && email.equals(p.getOrigem())) {
                        RemoverProduto(p);
                        System.out.println("Produto removido com sucesso");
                    }
                }
                break;
            }
            case "10": {
                menu0();
            }
        }
    }

    
    
    
    
    //menu utilizado para mudar as inforamaçoes de um Utilizador
    public void menu3(String op, String email, String pass) {
        switch (op) {
            case "1": {
                for (Utilizador u :
                        getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Primeiro nome atual: " + u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String nome = myObj.nextLine();
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
                        u.setPrimeiroNome(Pnome);
                        System.out.println("Nome alterado com sucesso");
                        //Alterar ultimo nome
                        System.out.println("Ultimo nome atual: " + u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String Unome = myObj.nextLine();
                        u.setUltimoNome(Unome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        //Alterar email
                        System.out.println("Email atual: " + u.getEmail());
                        System.out.println("Novo nome: ");
                        String tEmail = myObj.nextLine();
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        //Alterar Palaavra passe
                        System.out.println("Palavra-passe atual: " + u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = myObj.nextLine();
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        APP(tEmail, tpp);
                    }
                }
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
                        p.setNomeProduto(N_N);
                        System.out.println("Informação alterada com sucesso");
                    }
                }
                break;

            }
            case "2": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Categoria atual do produto: " + p.getCategoria());
                        System.out.println("Nova categoria do produto: ");
                        String N_C = myObj.nextLine();
                        p.setNomeProduto(N_C);
                        System.out.println("Informação alterada com sucesso");
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
                        p.setNomeProduto(N_P);
                        System.out.println("Informação alterada com sucesso");
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
                        if (op_p.equals("1")) {
                            System.out.println("Quantidade a adicionar: ");
                            String N_S = myObj.nextLine();
                            int tStock = Integer.parseInt(N_S);
                            int ttStock = p.getStock();
                            tStock+=ttStock;
                            p.setNomeProduto(String.valueOf(tStock));
                            System.out.println("Stock adicionado com sucesso");

                        }
                        else if (op_p.equals("2")) {
                            System.out.println("Novo nome do produto: ");
                            String N_S = myObj.nextLine();
                            p.setNomeProduto(N_S);
                            System.out.println("Informação alterada com sucesso");
                        }
                    }
                }
                break;
            }
            case "5": {
                for (Produtos p :
                        getListaProdutos()) {
                    if (ID.equals(p.getId()) && email.equals(p.getOrigem())) {
                        System.out.println("Nome atual do produto: " + p.getNomeProduto());
                        System.out.println("Novo nome do produto: ");
                        String N_P = myObj.nextLine();
                        System.out.println("Categoria atual: " + p.getCategoria());
                        System.out.println("Nova categoria: ");
                        String Categ = myObj.nextLine();
                        System.out.println("Preço atual: " + p.getPreco());
                        System.out.println("Novo preço: ");
                        String tPreco = myObj.nextLine();
                        double preco = Double.parseDouble(tPreco);
                        System.out.println("Stock atual: " + p.getStock());
                        System.out.println("Novo stock: ");
                        String tStock = myObj.nextLine();
                        int Stock = Integer.parseInt(tStock);
                        p.setNomeProduto(N_P);
                        p.setNomeProduto(Categ);
                        p.setPreco(preco);
                        p.setStock(Stock);
                        System.out.println("Produto alterado com sucesso");

                    }
                }
                break;
            }

        }
    }
}
