package Martinho;
public class Menus {
    public Gestor gestor;

    public Menus(){

    }
    public void menu1(String Opcao){
        switch (Opcao){
            case "1" : {
                System.out.println("Primeiro nome: ");
                String P_N = gestor.myObj.nextLine();
                System.out.println("Ultimo nome: ");
                String U_N = gestor.myObj.nextLine();
                System.out.println("Email: ");
                String email = gestor.myObj.nextLine();
                System.out.println("Palavra passe: ");
                String P_P = gestor.myObj.nextLine();
                Utilizador u = new Utilizador();
                u.setPrimeiroNome(P_N);
                u.setUltimoNome(U_N);
                u.setEmail(email);
                u.setPalavraPasse(P_P);
                gestor.GuardarUser(u);
                if(gestor.GuardarUser(u)){
                    System.out.println("Registrado com sucesso Sr/Sra - " + P_N + " " + U_N);
                }else{
                    System.out.println("Foi detetado um erro quando estava a fazer o registo, " +
                            "tente novamente mais tarde");
                }
                break;
            }
            case "2":{
                System.out.println("Email: ");
                String email = gestor.myObj.nextLine();
                System.out.println("Palavra Passe: ");
                String pp = gestor.myObj.nextLine();
                boolean Login = true;
                for (Utilizador utilizador: gestor.getListaUtilizador()){
                    String tEmail = utilizador.getEmail();
                    String tpp = utilizador.getPalavraPasse();
                    boolean auteEmail = email.equals(tEmail);
                    boolean autePalavra = pp.equals(tpp);
                    if (auteEmail && autePalavra) {
                        System.out.println("Logado");
                        gestor.APP(email,pp);
                    }else{
                        System.out.println("Email/senha Incorretos");
                    }
                }
                break;
            }
            case "3" : {
                System.out.println("Obrigado e um bom dia");
                gestor.setOff(false);
                break;
            }
        }
    }
    public void menu2(String opcao, String email, String pass){
        switch (opcao){
            case "1":{
                for (Utilizador u: gestor.getListaUtilizador()) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Quais informações deseja alterar?");
                        System.out.println("1-Primeiro nome");
                        System.out.println("2-Ultimo nome");
                        System.out.println("3-Email");
                        System.out.println("4-Palava-passe");
                        System.out.println("5-Todas as informações");
                        String op=gestor.myObj.nextLine();
                        menu3(op,email,pass);
                        break;
                    }

                }
            }
            case"2":{
                for (Utilizador u: gestor.getListaUtilizador()) {
                    if (email.equals(u.getEmail()) && pass.equals(u.getPalavraPasse())) {
                        System.out.println("Nome do produto: ");
                        String N_P = gestor.myObj.nextLine();
                        System.out.println("Categoria: ");
                        String Categ = gestor.myObj.nextLine();
                        System.out.println("Preço: ");
                        String tPreco = gestor.myObj.nextLine();
                        double preco = Double.parseDouble(tPreco);
                        System.out.println("Stock: ");
                        String tStock = gestor.myObj.nextLine();
                        int Stock = Integer.parseInt(tStock);
                        Produtos p = new Produtos();
                        p.setNomeProduto(N_P);
                        p.setNomeProduto(Categ);
                        p.setPreco(preco);
                        p.setStock(Stock);
                        String origin = "";
                        origin.concat(u.getEmail());
                        p.setOrigem(origin);
                        System.out.println("Produto adicionado com sucesso");
                        break;
                    }
                }
            }
            case"4":{
                //Editar as informações de um produto existente
                for (Produtos produtos: gestor.getListaProdutos()) {
                    System.out.println(produtos);
                }
                break;
            }
            case"5":{
                gestor.menu0();
            }
        }
    }
    public void menu3(String op,String email,String pass){
        switch(op){
            case "1" : {
                for (Utilizador u:
                        gestor.getListaUtilizador()) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Primeiro nome atual: "+u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String nome = gestor.myObj.nextLine();
                        u.setPrimeiroNome(nome);
                        System.out.println("Nome alterado com sucesso");
                        gestor.APP(email,pass);
                    }
                }
                break;
            }
            case "2" : {
                for (Utilizador u:
                        gestor.getListaUtilizador()) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Ultimo nome atual: "+u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String nome = gestor.myObj.nextLine();
                        u.setUltimoNome(nome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        gestor.APP(email,pass);
                    }
                }
                break;
            }
            case "3" : {
                for (Utilizador u:
                        gestor.getListaUtilizador()) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Email atual: "+u.getEmail());
                        System.out.println("Novo email: ");
                        String tEmail = gestor.myObj.nextLine();
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        gestor.APP(tEmail,pass);
                    }
                }
                break;
            }
            case "4" : {
                for (Utilizador u:
                        gestor.getListaUtilizador()) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        System.out.println("Palavra-passe atual: "+u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = gestor.myObj.nextLine();
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        gestor.APP(email,tpp);
                    }
                }
                break;
            }
            case "5" : {
                for (Utilizador u:
                        gestor.getListaUtilizador()) {
                    if(email.equals(u.getEmail())&&pass.equals(u.getPalavraPasse())){
                        //Alterar primeiro nome
                        System.out.println("Primeiro nome atual: "+u.getPrimeiroNome());
                        System.out.println("Novo nome: ");
                        String Pnome = gestor.myObj.nextLine();
                        u.setPrimeiroNome(Pnome);
                        System.out.println("Nome alterado com sucesso");
                        //Alterar ultimo nome
                        System.out.println("Ultimo nome atual: "+u.getUltimoNome());
                        System.out.println("Novo nome: ");
                        String Unome = gestor.myObj.nextLine();
                        u.setUltimoNome(Unome);
                        System.out.println("Ultimo nome alterado com sucesso");
                        //Alterar email
                        System.out.println("Email atual: "+u.getEmail());
                        System.out.println("Novo nome: ");
                        String tEmail = gestor.myObj.nextLine();
                        u.setEmail(tEmail);
                        System.out.println("Email alterado com sucesso");
                        //Alterar Palaavra passe
                        System.out.println("Palavra-passe atual: "+u.getPalavraPasse());
                        System.out.println("Nova palavra-passe: ");
                        String tpp = gestor.myObj.nextLine();
                        u.setPalavraPasse(tpp);
                        System.out.println("Palavra-passe alterado com sucesso");
                        gestor.APP(tEmail,tpp);
                    }
                }
                break;
            }

        }
    }

}
