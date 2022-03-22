package br.edu.infnet.apiaula.model.domain;

import br.edu.infnet.apiaula.model.exceptions.DuracaoMinutosInvalidException;
import br.edu.infnet.apiaula.model.exceptions.IntensidadeInvalidException;
import br.edu.infnet.apiaula.model.exceptions.MembroNullException;

public class Alongamento extends Atividade {

    private String membro;
    private String aparelho;
    private Boolean requerAssistencia;

    public Alongamento(Integer duracaoMinutos, String descricao, String intensidade, Boolean supervisionada) throws DuracaoMinutosInvalidException, IntensidadeInvalidException {
        super(duracaoMinutos, descricao, intensidade, supervisionada);
    }

    public String getMembro() {
        return membro;
    }

    public void setMembro(String membro) throws MembroNullException {
        if (membro == null) {
            throw new MembroNullException("O parametro [membro] da classe [Alongamento] é obrigatório");
        }
        this.membro = membro;
    }

    public String getAparelho() {
        return aparelho;
    }

    public void setAparelho(String aparelho) {
        this.aparelho = aparelho;
    }

    public Boolean getRequerAssistencia() {
        return requerAssistencia;
    }

    public void setRequerAssistencia(Boolean requerAssistencia) {
        this.requerAssistencia = requerAssistencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(";");
        sb.append(membro);
        sb.append(";");
        sb.append(aparelho);
        sb.append(";");
        sb.append(requerAssistencia);
        sb.append(";");

        return sb.toString();
    }

    @Override
    public Integer calcularCaloriasQueimadas() {

        Integer caloriasQueimadas = 80;
        return caloriasQueimadas;
    }
}
