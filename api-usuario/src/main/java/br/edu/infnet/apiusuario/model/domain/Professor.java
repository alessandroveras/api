package br.edu.infnet.apiusuario.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TProfessor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String cpf;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idendereco")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonIgnore
    private Usuario usuario;

    public Professor() {
    }

    public Professor(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(id);
        sb.append(";");
        sb.append(nome);
        sb.append(";");
        sb.append(email);
        sb.append(";");
        sb.append(cpf);

        return sb.toString();
    }
}
