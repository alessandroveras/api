package br.edu.infnet.apiaula.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "TAula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;

    private Integer duracao;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idProfessor")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Atividade> atividades;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Aula() {
        this.data = LocalDateTime.now();
        this.duracao = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String mensagem = String.format("%d;%s;%d;%s;%s;%d",
                this.id,
                this.data.format(formato),
                this.duracao,
                this.professor,
                this.atividades.size()
        );

        return mensagem;

    }
}