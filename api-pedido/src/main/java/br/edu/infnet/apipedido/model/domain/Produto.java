package br.edu.infnet.apipedido.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.edu.infnet.apipedido.model.exceptions.PesoInvalidoException;
import br.edu.infnet.apipedido.model.exceptions.ValorInvalidoException;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Bebida.class, name = "Bebida"), 	
	@JsonSubTypes.Type(value = Comida.class, name = "Comida") 
})
public abstract class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private float valor;
	private float peso;
	@ManyToMany(mappedBy = "produtos")
	@JsonBackReference
	private List<Pedido> pedidos;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonIgnore
	private Usuario usuario;
	
	public Produto() {
		
	}
	
	public Produto(String descricao, float valor, float peso) throws ValorInvalidoException, PesoInvalidoException {
		
		if(valor < 0) {
			throw new ValorInvalidoException("Impossível cadastrar o produto: valor negativo!");
		}
		
		if(valor == 0) {
			throw new ValorInvalidoException("Impossível cadastrar o produto: valor zerado!");
		}

		if(peso < 0) {
			throw new PesoInvalidoException("Impossível cadastrar o produto: peso negativo!");
		}
		
		if(peso == 0) {
			throw new PesoInvalidoException("Impossível cadastrar o produto: peso zerado!");
		}

		this.descricao = descricao;
		this.valor = valor;
		this.peso = peso;
	}
	
	public abstract float calcularValorVenda();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();

		sb.append(id);
		sb.append(";");
		sb.append(descricao);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(this.calcularValorVenda());
		
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}