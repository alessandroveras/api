package br.edu.infnet.apipedido.model.exceptions;

public class QuantidadeServidoNegativaException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantidadeServidoNegativaException(String mensagem) {
		super(mensagem);
	}
}