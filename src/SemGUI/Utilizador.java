package SemGUI;

public class Utilizador {
    private String PrimeiroNome;
    private String UltimoNome;
    private String PalavraPasse;
    private String Email;
    private String morada;


    public Utilizador(){
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPalavraPasse(String palavraPasse) {
        PalavraPasse = palavraPasse;
    }

    public void setPrimeiroNome(String primeiroNome) {
        PrimeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        UltimoNome = ultimoNome;
    }

    public String getEmail() {
        return Email;
    }

    public String getPalavraPasse() {
        return PalavraPasse;
    }

    public String getPrimeiroNome() {
        return PrimeiroNome;
    }

    public String getUltimoNome() {
        return UltimoNome;
    }
    public String getUtilizador(){
        return "||Email="+Email+"||Palavra Passe="+PalavraPasse+"||"+PrimeiroNome+"||"+UltimoNome;
    }

}
