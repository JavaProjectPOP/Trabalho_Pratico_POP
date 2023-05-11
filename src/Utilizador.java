public class Utilizador {
    private String Username;
    private String Password;

    public Utilizador(String username, String password){
        this.Password=password;
        this.Username=username;
    }

    public void Login(){

    }
    public void Register(){

    }
    
    public String getUsername(){
        return Username;
    }

    public String getPassword() {
        return Password;
    }
}
