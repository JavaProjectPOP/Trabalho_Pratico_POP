import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestao {
    private List<Produto> produtos;
    private List<Utilizador> utillizadores;
    private List<Cliente> clientes;
    private List<Venda> vendas;


    public Gestao() {
        produtos = new ArrayList<>();
        utillizadores = new ArrayList<>();
        clientes = new ArrayList<>();
        vendas = new ArrayList<>();
    }
    public void addInfos(Utilizador utilizador){
        utillizadores.add(utilizador);
    }
    public void isLoginValid(){
        for (Utilizador i : utillizadores) {
            
        }
    }
    /**public static void menu_inicial(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo!");
        System.out.println("\n1-Fazer login\n2-Registar-se");
        while (!sc.hasNextInt()) {
            sc.next();
        }
        int select = sc.nextInt();
        switch (select) {
            case 1:
                
            break;
            case 2:
                
            break;

            default:
                menu_inicial();  //would you re call itself again here? or is there any otherway to do without recalling itself?

        }
    }**/
}
