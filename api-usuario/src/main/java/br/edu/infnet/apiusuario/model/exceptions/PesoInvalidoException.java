package br.edu.infnet.apiusuario.model.exceptions;

public class PesoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public PesoInvalidoException(String mensagem) {
		super(mensagem);
	}
}