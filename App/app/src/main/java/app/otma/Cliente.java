package app.otma;

public class Cliente {

    private String ClienteNome;
    private String ClienteCPF;
    private String ClienteCelular;
    private int ClienteIdade;
    private String ClienteEmail;
    private String ClienteSenha;

    //CONSTRUTORES

    public Cliente() {}

    public Cliente(String clienteNome, String clienteCPF, String clienteCelular, int clienteIdade, String clienteEmail, String clienteSenha) {
        ClienteNome = clienteNome;
        ClienteCPF = clienteCPF;
        ClienteCelular = clienteCelular;
        ClienteIdade = clienteIdade;
        ClienteEmail = clienteEmail;
        ClienteSenha = clienteSenha;
    }

    // GETTERS
    public String getClienteNome() {
        return ClienteNome;
    }

    public String getClienteCPF() {
        return ClienteCPF;
    }

    public String getClienteCelular() {
        return ClienteCelular;
    }

    public int getClienteIdade() {
        return ClienteIdade;
    }

    public String getClienteEmail() {
        return ClienteEmail;
    }

    public String getClienteSenha() {
        return ClienteSenha;
    }

    //SETTERS
    public void setClienteNome(String clienteNome) {
        ClienteNome = clienteNome;
    }

    public void setClienteCPF(String clienteCPF) {
        ClienteCPF = clienteCPF;
    }

    public void setClienteCelular(String clienteCelular) {
        ClienteCelular = clienteCelular;
    }

    public void setClienteIdade(int clienteIdade) {
        ClienteIdade = clienteIdade;
    }

    public void setClienteEmail(String clienteEmail) {
        ClienteEmail = clienteEmail;
    }

    public void setClienteSenha(String clienteSenha) {
        ClienteSenha = clienteSenha;
    }
}
