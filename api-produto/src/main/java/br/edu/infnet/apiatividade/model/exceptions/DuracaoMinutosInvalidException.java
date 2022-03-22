package br.edu.infnet.apiatividade.model.exceptions;

public class DuracaoMinutosInvalidException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuracaoMinutosInvalidException(String message) {
        super(message);
    }
}
