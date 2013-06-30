package br.ufs.dcomp.locadora.entity;

import java.util.ArrayList;
import java.util.List;

public class Locacao {

	private static List<Locacao> locacoes = new ArrayList<Locacao>();

	private Cliente cliente;
	private Veiculo veiculo;
	private Periodo periodo;

	public Locacao(Cliente cliente, Veiculo veiculo, Periodo periodo) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.periodo = periodo;
	}

	public static List<Locacao> getLocacoes() {
		return locacoes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public boolean realizarLocacao() {

		for (Locacao locacao : locacoes) {
			if (locacao.getVeiculo().equals(this.getVeiculo())
					&& locacao.getPeriodo().compareTo(this.getPeriodo()) == 0) {
				return false;
			}
		}

		locacoes.add(this);

		return true;
	}

	public boolean finalizarLocacao() {

		Locacao locacaoParaSerFinalizada = null;
		for (Locacao locacao: locacoes) {
			if (this.equals(locacao)) {
				locacaoParaSerFinalizada = locacao;
				break;
			}
		}
		
		if (locacaoParaSerFinalizada != null) {
			locacoes.remove(locacaoParaSerFinalizada);
			return true;
		}
		
		return false;
	}

}
