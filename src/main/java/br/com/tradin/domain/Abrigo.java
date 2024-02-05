package br.com.tradin.domain;

import java.util.List;

public class Abrigo {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Pet[] pets;

    public Abrigo(){}

    public Abrigo(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return """
               "id":%s,"nome":"%s","telefone":"%s","email":"%s"
               """.formatted(this.id, this.nome, this.telefone, this.email);
    }
}
