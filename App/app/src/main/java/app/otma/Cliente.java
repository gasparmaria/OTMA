package app.otma;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String nome, cpf, celular, email, senha;
    private int idade;

    // CONSTRUTORES
    public Cliente(String nome, String CPF, String celular, int idade, String email, String senha) {
        this.nome = nome;
        this.cpf = CPF;
        this.celular = celular;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }

    // GETS
    public String getNome() { return nome; }

    public String getCPF() { return cpf; }

    public String getCelular() { return celular; }

    public int getIdade() { return idade; }

    public String getEmail() { return email; }

    public String getSenha() { return senha; }

    // SETS
    public void setNome(String nome) { this.nome = nome; }

    public void setClienteCPF(String CPF) { this.cpf = CPF; }

    public void setCelular(String celular) { this.celular = celular; }

    public void setIdade(int idade) { this.idade = idade; }

    public void setEmail(String email) { this.email = email; }

    public void setSenha(String senha) { this.senha = senha; }
}
