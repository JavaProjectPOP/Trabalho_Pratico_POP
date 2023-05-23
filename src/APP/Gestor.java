package APP;

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

    private String Opcao;
    private boolean on = true;
    Scanner myObj = new Scanner(System.in);
    private ArrayList<Utilizador> ListaUtilizador = new ArrayList<>();

    public Gestor()
    {
        menu0();
    }

    public boolean isOn() {
        return on;
    }

    public void setOff(boolean on) {
        this.on = on;
    }

    public void menu0()
    {
        while(isOn() == true){
            System.out.println("Bem Vindo a App");
            System.out.println("1-Registar um usuario");
            System.out.println("2-Logar a sua conta");
            System.out.println("3-Sair");
            System.out.println("Escolha: ");
            String Opcao = myObj.nextLine();
            menu1(Opcao);
        }
    }

    public ArrayList<Utilizador> getListaUtilizador() {
        return ListaUtilizador;
    }

    public void menu1(String Opcao){
        switch (Opcao){
            case "1" : {
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
                if(GuardarUser(u)){
                    System.out.println("Registrado com sucesso Sr/Sra - " + P_N + " " + U_N);
                }else{
                    System.out.println("Foi detetado um erro quando estava a fazer o registo, " +
                            "tente novamente mais tarde");
                }
                break;
            }
            case "2":{
                System.out.println("Email: ");
                String email = myObj.nextLine();
                System.out.println("Palavra Passe: ");
                String pp = myObj.nextLine();
                boolean Login = true;
                for (Utilizador utilizador: ListaUtilizador){
                    String tEmail = utilizador.getEmail();
                    String tpp = utilizador.getPalavraPasse();
                    boolean auteEmail = email.equals(tEmail);
                    boolean autePalavra = pp.equals(tpp);
                    if (auteEmail && autePalavra) {
                        System.out.println("Logado");
                        APP(email,pp);
                    }else{
                        System.out.println("Email/senha Incorretos");
                    }
                }
                break;
            }
            case "3" : {
                System.out.println("Obrigado e um bom dia");
                setOff(false);
                break;
            }
        }
    }

    public void APP(String email, String pass){
        for (Utilizador u : ListaUtilizador){
            if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                System.out.println("Bem Vindo "+u.getPrimeiroNome()+" "+u.getUltimoNome());
                System.out.println("1- Alterar os seus dados de usuario");
                //System.out.println("3- Adicionar um produto");
                //System.out.println("4- Editar as informações de um produto existente");
                System.out.println("5- Logout");
                String opcao = myObj.nextLine();
                menu2(opcao, email,pass);
            }
        }

    }
    public void menu2(String opcao, String email, String pass){
        switch (opcao){
            case "1":{
                for (Utilizador u: ListaUtilizador) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Quais informações deseja alterar?");
                        System.out.println("1-Primeiro nome");
                        System.out.println("2-Ultimo nome");
                        System.out.println("3-Email");
                        System.out.println("4-Palava-passe");
                        System.out.println("5-Todas as informações");
                        String op=myObj.nextLine();
                        menu3(op,email,pass);
                        break;
                    }

                }
            }
            case"5":{
                menu0();
            }
        }
    }
    public void menu3(String op,String email,String pass){
        switch(op){
            case "1" : {
                for (Utilizador u:
                     ListaUtilizador) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Primeiro nome atual: "+u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String nome = myObj.nextLine();
                        u.setPrimeiroNome(nome);
                        System.out.println("Nome alterado com sucesso");
                        APP(email,pass);
                    }
                }
                break;
            }
            case "2" : {
                for (Utilizador u:
                        ListaUtilizador) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Ultimo nome atual: "+u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String nome = myObj.nextLine();
                        u.setUltimoNome(nome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        APP(email,pass);
                    }
                }
                break;
            }
            case "3" : {
                for (Utilizador u:
                        ListaUtilizador) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Email atual: "+u.getEmail());
                        System.out.println("Novo email: ");
                        String tEmail = myObj.nextLine();
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        APP(tEmail,pass);
                    }
                }
                break;
            }
            case "4" : {
                for (Utilizador u:
                        ListaUtilizador) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Palavra-passe atual: "+u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = myObj.nextLine();
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        APP(email,tpp);
                    }
                }
                break;
            }
            case "5" : {
                for (Utilizador u:
                        ListaUtilizador) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        //Alterar primeiro nome
                        System.out.println("Primeiro nome atual: "+u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String Pnome = myObj.nextLine();
                        u.setPrimeiroNome(Pnome);
                        System.out.println("Nome alterado com sucesso");
                        //Alterar ultimo nome
                        System.out.println("Ultimo nome atual: "+u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String Unome = myObj.nextLine();
                        u.setUltimoNome(Unome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        //Alterar email
                        System.out.println("Email atual: "+u.getEmail());
                        System.out.println("Novo nome: ");
                        String tEmail = myObj.nextLine();
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        //Alterar Palaavra passe
                        System.out.println("Palavra-passe atual: "+u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = myObj.nextLine();
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        APP(tEmail,tpp);
                    }
                }
                break;
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

}
