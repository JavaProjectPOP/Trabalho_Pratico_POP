// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Gestao g1= new Gestao();
        Utilizador u1 = new Utilizador("cenas","pp123");
        Utilizador u2 = new Utilizador("roig","rpgo");
        g1.addInfos(u1);
        g1.addInfos(u2);
        g1.isLoginValid();
    }
}