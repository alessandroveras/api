package br.edu.infnet.apiusuario.model.exceptions;

public class ValorInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValorInvalidoException(String mensagem) {
		super(mensagem);
	}
}